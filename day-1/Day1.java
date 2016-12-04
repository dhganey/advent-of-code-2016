import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Day1 {
	
	public static void main(String[] args) {
		System.out.println(getBlocksAway());
	}
	
	private static String getBlocksAway() {
		InstructionGetter getter = new MockInstructionGetter();
		List<Instruction> instructions = getter.getInstructions();
		
		Point current = new Point(0, 0);
		Direction direction = Direction.NORTH;
		
		for (Instruction instruction : instructions) {
			direction = Direction.turn(direction, instruction.getTurn());
			int blocks = instruction.getBlocks();
			switch(direction) {
			case WEST:
				current.setX(current.getX() - blocks);
				break;
			case EAST:
				current.setX(current.getX() + blocks);
				break;
			case NORTH:
				current.setY(current.getY() + blocks);
				break;
			case SOUTH:
				current.setY(current.getY() - blocks);
				break;
			}
		}
		
		return (Math.abs(current.getX()) + Math.abs(current.getY())) + "";
	}
}



