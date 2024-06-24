/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.crafteandoservidores.summercraft.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;

import net.crafteandoservidores.summercraft.SummercraftMod;

public class SummercraftModItems {
	public static Item CAJERO_AUTOMATICO_0;

	public static void load() {
		CAJERO_AUTOMATICO_0 = register("cajero_automatico_0", new BlockItem(SummercraftModBlocks.CAJERO_AUTOMATICO_0, new Item.Properties()));
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
