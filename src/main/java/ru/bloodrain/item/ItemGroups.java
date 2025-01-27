package ru.bloodrain.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier("king_of_wakanda", "mod_group"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.NECKLACE))
            .displayName(Text.translatable("itemGroup.king_of_wakanda.mod_group"))
            .entries((context, entries) -> {
                entries.add(ModItems.NECKLACE);
                entries.add(ModItems.HERB_POTION);
                entries.add(ModItems.VIBRANIUM_SHIELD);
                entries.add(ModItems.VIBRANIUM_SHEET);
            })
            .build());

    public static void initialize() {
    }
}
