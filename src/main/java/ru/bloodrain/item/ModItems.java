package ru.bloodrain.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.threetag.palladium.item.PalladiumItems;
import ru.bloodrain.KingOfWakanda;
import ru.bloodrain.item.custom.HerbPotionItem;
import ru.bloodrain.item.custom.NecklaceItem;
import ru.bloodrain.item.custom.VibraniumShield;

public class ModItems {

    public static final Item HERB_POTION = registerItem("herb_potion", new HerbPotionItem(new Item.Settings().food(new FoodComponent.Builder().build()).maxCount(1)));

    public static final Item NECKLACE = registerItem("black_panther_necklace", new NecklaceItem(new Item.Settings().maxCount(1)));

    public static final Item VIBRANIUM_SHIELD = registerItem("vibranium_shield", new VibraniumShield(ToolMaterials.NETHERITE, 5, -2.4F, new Item.Settings().maxCount(1)));

    public static final Item VIBRANIUM_SHEET = registerItem("vibranium_sheet", new Item(new Item.Settings()));

    private static Item registerItem(String id, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(KingOfWakanda.MOD_ID, id), item);
    }

    private static void addItemsToFoodGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.SUSPICIOUS_STEW, HERB_POTION);
    }

    private static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.TURTLE_HELMET, NECKLACE);
        entries.addAfter(Items.SHIELD, VIBRANIUM_SHIELD);
    }

    public static void addItemsToIngredientsGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.NETHERITE_INGOT, VIBRANIUM_SHEET);
    }

    public static void register()
    {
        KingOfWakanda.LOGGER.debug("Registering");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsGroup);
    }
}
