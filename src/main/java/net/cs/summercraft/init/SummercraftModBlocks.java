
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.cs.summercraft.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.cs.summercraft.block.TragaperrasBlock;
import net.cs.summercraft.block.ExpendAmarillaBlock;
import net.cs.summercraft.block.CajeroAutomaticoBlock;
import net.cs.summercraft.SummercraftMod;

public class SummercraftModBlocks {
	public static Block TRAGAPERRAS;
	public static Block EXPEND_AMARILLA;
	public static Block CAJERO_AUTOMATICO;

	public static void load() {
		TRAGAPERRAS = register("tragaperras", new TragaperrasBlock());
		EXPEND_AMARILLA = register("expend_amarilla", new ExpendAmarillaBlock());
		CAJERO_AUTOMATICO = register("cajero_automatico", new CajeroAutomaticoBlock());
	}

	public static void clientLoad() {
		TragaperrasBlock.clientInit();
		ExpendAmarillaBlock.clientInit();
		CajeroAutomaticoBlock.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(SummercraftMod.MODID, registryName), block);
	}
}
