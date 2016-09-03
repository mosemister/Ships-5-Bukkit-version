package MoseShipsSponge.Utils;

import org.bukkit.entity.Player;

import MoseShipsSponge.Ships.VesselTypes.StaticShipType;

public enum Permissions {

	CREATE_VESSEL(true, "ships.*", "ships.*.make", "ships.%VesselType%.make");

	public static boolean USE_PERMISSIONS = false;

	String[] PERMISSIONS;
	boolean NO_PERMISSION_VALUE;

	private Permissions(boolean noPerms, String... perms) {
		PERMISSIONS = perms;
		NO_PERMISSION_VALUE = noPerms;
	}

	public boolean hasPermission(Player player) {
		return hasPermission(player, "", "");
	}

	public boolean hasPermission(Player player, StaticShipType type) {
		return hasPermission(player, "%VesselType%", type.getName());
	}

	private boolean hasPermission(Player player, String old, String replace) {
		if (USE_PERMISSIONS) {
			for(String permission : PERMISSIONS){
				if(player.hasPermission(permission.replace(old, replace))){
					return true;
				}
			}
			return false;
		} else {
			return NO_PERMISSION_VALUE;
		}
	}

}
