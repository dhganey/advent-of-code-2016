import java.util.List;
import java.util.Scanner;

public class FileInstructionGetter implements InstructionGetter {
	public List<Instruction> getInstructions() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		return processInstructionString(input);
	}
}