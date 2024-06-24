/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.cs.summercraft.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;

import net.cs.summercraft.SummercraftMod;

public class SummercraftModItems {
	public static Item TRAGAPERRAS;
	public static Item EXPENDEDORAAMARILLA;
	public static Item EXPEND_AMARILLA;

	public static void load() {
		TRAGAPERRAS = register("tragaperras", new BlockItem(SummercraftModBlocks.TRAGAPERRAS, new Item.Properties()));
		EXPENDEDORAAMARILLA = register("expendedoraamarilla", new BlockItem(SummercraftModBlocks.EXPENDEDORAAMARILLA, new Item.Properties()));
		EXPEND_AMARILLA = register("expend_amarilla", new BlockItem(SummercraftModBlocks.EXPEND_AMARILLA, new Item.Properties()));
	}

	public static void clientLoad() {
	}

	private static Item register(String registryName, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SummercraftMod.MODID, registryName), item);
	}

	private static void registerBlockingProperty(Item item) {
		ItemProperties.register(item, new ResourceLocation("blocking"), (ClampedItemPropertyFunction) ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
	}
}
