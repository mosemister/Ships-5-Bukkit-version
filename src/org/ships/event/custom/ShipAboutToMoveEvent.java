package org.ships.event.custom;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.ships.ship.Ship;
import org.ships.ship.movement.MovementMethod;

public class ShipAboutToMoveEvent extends Event implements Cancellable {

	/*
	 * This event is called when a vessel is told to move. The
	 * ForceMove/ForceTeleport will bypass this activation
	 */

	MovementMethod METHOD;
	int SPEED;
	Ship VESSEL;
	OfflinePlayer PLAYER;
	boolean CANCEL;
	static HandlerList LIST = new HandlerList();

	public ShipAboutToMoveEvent(MovementMethod method, int speed, Ship vessel,
			OfflinePlayer player) {
		METHOD = method;
		SPEED = speed;
		VESSEL = vessel;
		PLAYER = player;
	}

	public MovementMethod getMethod() {
		return METHOD;
	}

	public void setMethod(MovementMethod method) {
		METHOD = method;
	}

	public int getSpeed() {
		return SPEED;
	}

	public void setSpeed(int A) {
		SPEED = A;
	}

	public Player getPlayer() {
		return PLAYER.getPlayer();
	}

	public OfflinePlayer getOfflinePlayer() {
		return PLAYER;
	}

	public void setPlayer(OfflinePlayer player) {
		PLAYER = player;
	}

	public Ship getVessel() {
		return VESSEL;
	}

	@Override
	public boolean isCancelled() {
		return CANCEL;
	}

	@Override
	public void setCancelled(boolean arg0) {
		CANCEL = arg0;

	}

	@Override
	public HandlerList getHandlers() {
		return LIST;
	}

	public static HandlerList getHandlerList() {
		return LIST;
	}

}