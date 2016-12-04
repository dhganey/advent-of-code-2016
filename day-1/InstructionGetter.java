import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public abstract class InstructionGetter {
		public abstract List<Instruction> getInstructions();
		
		List<Instruction> processInstructionString(String input) {
			return Arrays.asList(input.split(", ")).stream().map(Instruction::new).collect(Collectors.toList());
		}
	}