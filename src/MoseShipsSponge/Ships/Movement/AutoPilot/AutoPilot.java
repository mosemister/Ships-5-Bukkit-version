package MoseShipsSponge.Ships.Movement.AutoPilot;

public class AutoPilot {
	
	/*List<StoredMovement> MOVEMENTS = new ArrayList<StoredMovement>();
	LiveAutoPilotable SHIP;
	User USER;
	int TARGET;
	boolean SHOULD_REPEATE;
	int PROCESSED = 0;

	public AutoPilot(LiveAutoPilotable type, List<StoredMovement> movements, boolean repeate, int start,
			@Nullable User user) {
		MOVEMENTS = movements;
		SHIP = type;
		SHOULD_REPEATE = repeate;
		TARGET = start;
		USER = user;
	}

	public AutoPilot(LiveAutoPilotable type, List<StoredMovement> movements, boolean repeate, @Nullable User user) {
		MOVEMENTS = movements;
		SHIP = type;
		SHOULD_REPEATE = repeate;
		USER = user;
	}

	public AutoPilot(LiveAutoPilotable type, Block moveTo, int speed, @Nullable User user) {
		int height = 500;

		int toX = moveTo.getX();
		int toZ = moveTo.getZ();

		Location<World> from = type.getLocation();
		int fromX = from.getBlockX();
		int fromZ = from.getBlockZ();

		Location<World> stageOne = new Location<>(from.getWorld(), fromX, height, fromZ);
		Location<World> stageTwo = new Location<>(from.getWorld(), fromX, height, toZ);
		Location<World> stageThree = new Location<>(from.getWorld(), toX, height, toZ);

		List<Location<World>> listOne = getBetween(from, stageOne, speed);
		List<Location<World>> listTwo = getBetween(stageOne, stageTwo, speed);
		List<Location<World>> listThree = getBetween(stageTwo, stageThree, speed);
		List<Location<World>> listFour = getBetween(stageThree, moveTo.getLocation(), speed);
		List<Location<World>> collection = new ArrayList<>();
		collection.addAll(listOne);
		collection.addAll(listTwo);
		collection.addAll(listThree);
		collection.addAll(listFour);
		for (Location<World> loc : collection) {
			StoredMovement.Builder builder = new StoredMovement.Builder();
			builder.setTeleportTo(loc);
			StoredMovement movement = builder.build();
			MOVEMENTS.add(movement);
		}
		SHIP = type;
		SHOULD_REPEATE = false;
		USER = user;
	}

	public AutoPilot(LiveAutoPilotable type, double X, double Y, double Z, int speed, @Nullable User user) {
		int height = 150;
		Location<World> moveTo = type.getLocation().clone().add(X, Y, Z);

		int toX = moveTo.getBlockX();
		int toZ = moveTo.getBlockZ();

		Location<World> from = type.getLocation();
		int fromX = from.getBlockX();
		int fromZ = from.getBlockZ();

		Location<World> stageOne = new Location(from.getWorld(), fromX, height, fromZ);
		Location<World> stageTwo = new Location(from.getWorld(), fromX, height, toZ);
		Location<World> stageThree = new Location(from.getWorld(), toX, height, toZ);

		List<Location<World>> listOne = getBetween(from, stageOne, speed);
		List<Location<World>> listTwo = getBetween(stageOne, stageTwo, speed);
		List<Location<World>> listThree = getBetween(stageTwo, stageThree, speed);
		List<Location<World>> listFour = getBetween(stageThree, moveTo, speed);
		List<Location<World>> collection = new ArrayList<>();
		collection.addAll(listOne);
		collection.add(stageOne);
		collection.addAll(listTwo);
		collection.add(stageTwo);
		collection.addAll(listThree);
		collection.add(stageThree);
		collection.addAll(listFour);
		System.out.println("size of movements: " + collection.size());
		for (Location<World> loc : collection) {
			StoredMovement.Builder builder = new StoredMovement.Builder();
			builder.setTeleportTo(loc);
			StoredMovement movement = builder.build();
			MOVEMENTS.add(movement);
		}
		SHIP = type;
		SHOULD_REPEATE = false;
		USER = user;
	}
	
	public int getMovesDone(){
		return PROCESSED;
	}
	
	public void setMovesDone(int A){
		PROCESSED = A;
	}

	public List<StoredMovement> getMovements() {
		return MOVEMENTS;
	}

	public LiveAutoPilotable getTargetShip() {
		return SHIP;
	}

	public Optional<User> getTargetPlayer() {
		return Optional.ofNullable(USER);
	}

	public boolean isRepeating() {
		return SHOULD_REPEATE;
	}

	public OrderedMap<Integer, Location<World>> getPath() {
		OrderedMap<Integer, Location<World>> map = new OrderedMap<Integer, Location<World>>();
		map.put(0, SHIP.getLocation().getBlock());
		Location<World> previousLoc = SHIP.getLocation().getBlock();
		for (int A = 1; A < MOVEMENTS.size(); A++) {
			StoredMovement movement = MOVEMENTS.get(A - 1);
			Location<World> ret = movement.getEndResult(previousLoc);
			map.put(A, ret);
			previousLoc = ret;
		}
		return map;
	}

	private List<Location<World>> getBetween(Location<World> loc1, Location<World> loc2, int spacing) {
		System.out.println("\n X = " + loc1.getX() + " Y = " + loc1.getY() + " Z = " + loc1.getZ() + "\n X = " + loc2.getX() + " Y = " + loc2.getY() + " Z = " + loc2.getZ());
		List<Location<World>> blocks = new ArrayList<Location<World>>();
		World world = loc1.getExtent();
		if (loc1.getBlockX() == loc2.getBlockX()) {
			if (loc1.getBlockZ() < loc2.getBlockZ()) {
				int x = loc2.getBlockX();
				int y = loc2.getBlockY();
				int z = loc2.getBlockZ();
				int distance = (loc2.getBlockZ() - loc1.getBlockZ()) / spacing;
				for (int A = 0; A < distance; A++) {
					int Z = (z + A + spacing);
					if (Z > loc1.getBlockZ()) {
						blocks.add(new Location<>(world, x, y, loc1.getBlockZ()));
					} else {
						blocks.add(new Location<>(world, x, y, Z));
					}
				}
				return blocks;
			} else {
				int x = loc1.getBlockX();
				int y = loc1.getBlockY();
				int z = loc1.getBlockZ();
				int distance = (loc1.getBlockZ() - loc2.getBlockZ()) / spacing;
				for (int A = 0; A < distance; A++) {
					int Z = (z + A + spacing);
					if (Z > loc2.getBlockZ()) {
						blocks.add(new Location<>(world, x, y, loc2.getBlockZ()));
					} else {
						blocks.add(new Location<>(world, x, y, Z));
					}
				}
				return blocks;
			}
		} else {
			if (loc1.getBlockX() > loc2.getBlockX()) {
				int x = loc2.getBlockX();
				int y = loc2.getBlockY();
				int z = loc2.getBlockZ();
				int distance = (loc2.getBlockX() - loc1.getBlockX()) / spacing;
				for (int A = 0; A < distance; A++) {
					int X = (x + A + spacing);
					if (X > loc1.getBlockX()) {
						blocks.add(new Location<>(world, loc1.getBlockX(), y, z));
					} else {
						blocks.add(new Location<>(world, X, y, z));
					}
				}
				return blocks;
			} else {
				int x = loc1.getBlockX();
				int y = loc1.getBlockY();
				int z = loc1.getBlockZ();
				int distance = (loc1.getBlockX() - loc2.getBlockX()) / spacing;
				for (int A = 0; A < distance; A++) {
					int X = (x + A + spacing);
					if (X > loc2.getBlockX()) {
						blocks.add(new Location<>(world, loc2.getBlockX(), y, z));
					} else {
						blocks.add(new Location<>(world, X, y, z));
					}
				}
				return blocks;
			}
		}
}
*/
}
