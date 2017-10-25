package be.pxl.collections.opdracht3;

import static org.junit.Assert.*;
import org.junit.Test;

import be.pxl.collections.opdracht3.Robot.Command;

public class PrioBotTest {

	@Test
	public void addCommandIncreasesCommandListSize() {
		PrioBot prioBot = new PrioBot("robot2");
		prioBot.addCommand(Action.MOVE, "left", 5);
		prioBot.addCommand(Action.MOVE, "forward", 2);
		prioBot.addCommand(Action.ATTACK, "lasers", 4);
		assertEquals(3, prioBot.getCommandList().size());
	}
	
	@Test
	public void removedCommandGoneAfterExecute(){
		PrioBot prioBot = new PrioBot("robot2");
		prioBot.addCommand(Action.MOVE, "left", 5);
		prioBot.addCommand(Action.MOVE, "forward", 2);
		prioBot.addCommand(Action.ATTACK, "lasers", 4);
		Command output = prioBot.execute();
		Command oldest = prioBot.getCommandList().peek();
		assertFalse(output.equals(oldest));
	}
	
	@Test
	public void returnsNoneWhenListIsEmpty(){
		PrioBot prioBot = new PrioBot("robot2");
		Command output = prioBot.execute();
		assertEquals(Action.NONE, output.getAction());
	}
	
	@Test
	public void highestPriorityExecutedFirst(){
		PrioBot prioBot = new PrioBot("robot2");
		prioBot.addCommand(Action.MOVE, "left", 5);
		prioBot.addCommand(Action.MOVE, "forward", 2);
		prioBot.addCommand(Action.ATTACK, "lasers", 4);
		Command output = prioBot.execute();
		assertEquals(5, output.getPriority());
	}
	
	@Test
	public void oldestFirstWhenPriorityIsEqual(){
		PrioBot prioBot = new PrioBot("robot2");
		prioBot.addCommand(Action.MOVE, "left1", 5);
		prioBot.addCommand(Action.MOVE, "forward1", 6);
		prioBot.addCommand(Action.MOVE, "left2", 5);
		prioBot.addCommand(Action.MOVE, "forward2", 6);
		prioBot.addCommand(Action.ATTACK, "lasers1", 6);
		prioBot.execute();
		Command output = prioBot.execute();
		assertEquals("forward1", output.getValue());
	}
}
