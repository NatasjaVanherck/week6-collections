package be.pxl.collections.opdracht2;

import static org.junit.Assert.*;

import org.junit.Test;

import be.pxl.collections.opdracht2.Robot.Command;

public class RobotTest {
	
	@Test
	public void addCommandIncreasesCommandListSize() {
		Robot robot = new Robot("robot1");
		robot.addCommand(Action.MOVE, "left");
		robot.addCommand(Action.MOVE, "forward");
		robot.addCommand(Action.ATTACK, "lasers");
		assertEquals(3, robot.getCommandList().size());
	}
	
	@Test
	public void oldestCommandExecuted(){
		Robot robot = new Robot("robot1");
		robot.addCommand(Action.MOVE, "left");
		robot.addCommand(Action.MOVE, "forward");
		robot.addCommand(Action.ATTACK, "lasers");
		Command oldest = robot.getCommandList().peek();
		Command output = robot.execute();
		assertEquals(oldest, output);
	}
	
	@Test
	public void removedCommandGoneAfterExecute(){
		Robot robot = new Robot("robot1");
		robot.addCommand(Action.MOVE, "left");
		robot.addCommand(Action.MOVE, "forward");
		robot.addCommand(Action.ATTACK, "lasers");
		Command output = robot.execute();
		Command oldest = robot.getCommandList().peek();
		assertFalse(output.equals(oldest));
	}
	
	@Test
	public void returnsNoneWhenListIsEmpty(){
		Robot robot = new Robot("robot1");
		Command output = robot.execute();
		assertEquals(Action.NONE, output.getAction());
	}
}
