package be.pxl.collections.opdracht3;

import java.util.*;

public class PrioBot extends Robot{
	
	private Queue<Command> commandList = this.getCommandList();
	
	public PrioBot(String name){
		super(name);
	}
	
	public void addCommand(Action action, String value, int priority){
		commandList.offer(new Command(action, value, priority));
	}
	
	public Command execute(){	
		Queue<Command> sortedCommandList = new PriorityQueue<>(
				new Comparator<Command>(){

					@Override
					public int compare(Command o1, Command o2) {
						if(o1.getPriority() != o2.getPriority()){
							return o1.getPriority() - o2.getPriority();
						} else {
							return o1.getPriority();
						}
					}
				});
		sortedCommandList.addAll(commandList);
		Command command = getCommandList().poll();
		
		if(command == null){
			command = new Command(Action.NONE, "leeg", 0);
		}
		return command;			
	}
}
