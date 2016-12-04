public class Instruction {
		private TurnDirection turn;
		private int blocks;
		
		public Instruction(String input) {
			this.turn = TurnDirection.valueOf(Character.toString(input.charAt(0)));
			this.blocks = Integer.parseInt(Character.toString(input.charAt(1)));
		}

		public TurnDirection getTurn() {
			return turn;
		}

		public int getBlocks() {
			return blocks;
		}
		
		
	}