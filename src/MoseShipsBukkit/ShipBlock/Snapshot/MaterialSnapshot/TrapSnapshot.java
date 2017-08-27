package MoseShipsBukkit.ShipBlock.Snapshot.MaterialSnapshot;

import org.bukkit.block.BlockState;

import MoseShipsBukkit.ShipBlock.Snapshot.AttachableSnapshot;
import MoseShipsBukkit.ShipBlock.Snapshot.BlockSnapshot;
import MoseShipsBukkit.ShipBlock.Snapshot.RotatableSnapshot;

public class TrapSnapshot extends BlockSnapshot implements AttachableSnapshot, RotatableSnapshot {

	public TrapSnapshot(BlockState state) {
		super(state);
	}

	@SuppressWarnings("deprecation")
	@Override
	public byte getRotateLeft() {
		byte data = getData().getData();
		switch (data) {
		case 1:
			return 4;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 1;

		case 5:
			return 8;
		case 6:
			return 7;
		case 7:
			return 6;
		case 8:
			return 7;
		}
		return data;
	}

	@Override
	public byte getRotateRight() {
		return getRotateLeft();
	}

}