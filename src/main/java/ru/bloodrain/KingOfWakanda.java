package ru.bloodrain;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bloodrain.item.ItemGroups;
import ru.bloodrain.item.ModItems;

public class KingOfWakanda implements ModInitializer {
	public static final String MOD_ID = "king_of_wakanda";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		ItemGroups.initialize();
	}
}