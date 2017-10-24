package be.pxl.collections.opdracht2;

import java.util.*;

public class Robot {
	private String name;
	private Queue<Command> commandList = new LinkedList<>();
	
	public Robot(String name) {
		this.name = name;
	}
	
	class Command {
		private Action action;
		private String value;
		
		public Command(Action action, String value) {
			this.action = action;
			this.value = value;
		}
		
		public String display() {
			return action.toString() + " > " + value;
		}

		public Action getAction() {
			return action;
		}

		public String getValue() {
			return value;
		}
	}
	
	public Command execute(){
		Command command;
		command = commandList.poll();
		
		if(command == null){
			command = new Command(Action.NONE, "leeg");
		}
		return command;			
	}
	
	public void addCommand(Action action, String value){
		commandList.offer(new Command(action, value));
	}

	public String getName() {
		return name;
	}

	public Queue<Command> getCommandList() {
		return commandList;
	}
}
