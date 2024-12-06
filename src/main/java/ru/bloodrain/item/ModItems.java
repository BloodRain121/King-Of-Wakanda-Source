package ru.bloodrain.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ru.bloodrain.KingOfWakanda;
import ru.bloodrain.item.custom.HerbPotionItem;
import ru.bloodrain.item.custom.NecklaceItem;

public class ModItems {

    public static final Item HERB_POTION = registerItem("herb_potion", new HerbPotionItem(new Item.Settings().food(new FoodComponent.Builder().build())));

    public static final Item NECKLACE = registerItem("black_panther_necklace", new NecklaceItem(new Item.Settings()));

    private static Item registerItem(String id, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(KingOfWakanda.MOD_ID, id), item);
    }

    private static void addItemsToFoodGroup(FabricItemGroupEntries entries) {
        entries.add(HERB_POTION);
    }

    private static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        entries.add(NECKLACE);
    }

    public static void register()
    {
        KingOfWakanda.LOGGER.debug("Registering");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatGroup);
    }
}
