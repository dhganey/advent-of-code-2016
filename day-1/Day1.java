import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
		
		Set<Point> pointSet = new HashSet<>();
		pointSet.add(new Point(current.getX(), current.getY()));
		
		for (Instruction instruction : instructions) {
			direction = Direction.turn(direction, instruction.getTurn());
			int blocks = instruction.getBlocks();
			if (direction == Direction.WEST || direction == Direction.SOUTH) {
				blocks = blocks * -1;
			}
			
			int incrementalChange = blocks / Math.abs(blocks);
			if (direction == Direction.WEST || direction == direction.EAST) {
				for (int i = 0; i < Math.abs(blocks); i++) {
					current.setX(current.getX() + incrementalChange);
					Point newPoint = new Point(current.getX(), current.getY());
					if (pointSet.contains(newPoint)) {
						return (Math.abs(newPoint.getX()) + Math.abs(newPoint.getY())) + "";
					} else {
						pointSet.add(newPoint);
					}
				}
			} else {
				for (int i = 0; i < Math.abs(blocks); i++) {
					current.setY(current.getY() + incrementalChange);
					Point newPoint = new Point(current.getX(), current.getY());
					if (pointSet.contains(newPoint)) {
						return (Math.abs(newPoint.getX()) + Math.abs(newPoint.getY())) + "";
					} else {
						pointSet.add(newPoint);
					}
				}
			}
		}
		
		return (Math.abs(current.getX()) + Math.abs(current.getY())) + "";
	}
}



