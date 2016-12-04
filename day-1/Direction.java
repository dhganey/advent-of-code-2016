
public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	
	public static Direction turn(Direction from, TurnDirection turn) {
		if (turn == TurnDirection.L) {
			int newOrdinal = from.ordinal() - 1 < 0 ? 3 : from.ordinal() - 1;
			return values()[newOrdinal];
		} else {
			return values()[(from.ordinal() + 1) % values().length];
		}
	}
}
