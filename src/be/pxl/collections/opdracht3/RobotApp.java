package be.pxl.collections.opdracht3;

public class RobotApp {

	public static void main(String[] args) {
		Robot robot = new Robot("robot1");
		
		robot.addCommand(Action.MOVE, "left");
		robot.addCommand(Action.MOVE, "forward");
		robot.addCommand(Action.ATTACK, "lasers");
		
		String output = robot.execute().display();
		System.out.println(output);
		output = robot.execute().display();
		System.out.println(output);
		output = robot.execute().display();
		System.out.println(output);
		output = robot.execute().display();
		System.out.println(output);
	}

}
