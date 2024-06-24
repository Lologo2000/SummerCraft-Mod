
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.crafteandoservidores.summercraft.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.crafteandoservidores.summercraft.block.CajeroAutomatico0Block;
import net.crafteandoservidores.summercraft.SummercraftMod;

public class SummercraftModBlocks {
	public static Block CAJERO_AUTOMATICO_0;

	public static void load() {
		CAJERO_AUTOMATICO_0 = register("cajero_automatico_0", new CajeroAutomatico0Block());
	}

	public static void clientLoad() {
		CajeroAutomatico0Block.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(SummercraftMod.MODID, registryName), block);
	}
}
