package MoseShipsBukkit.Vessel.Common.Static;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

import MoseShipsBukkit.Configs.BasicConfig;
import MoseShipsBukkit.Vessel.Common.OpenLoader.OpenRAWLoader;
import MoseShipsBukkit.Vessel.Common.RootTypes.LiveShip;
import MoseShipsBukkit.Vessel.Common.RootTypes.ShipsData;

public interface StaticShipType {

	public static List<StaticShipType> TYPES = new ArrayList<StaticShipType>();

	public String getName();

	public int getDefaultSpeed();

	public int getBoostSpeed();

	public int getAltitudeSpeed();

	public Plugin getPlugin();

	public OpenRAWLoader[] getLoaders();

	public Optional<LiveShip> createVessel(String name, Block licence);

	public Optional<LiveShip> loadVessel(ShipsData data, BasicConfig config);

}
