
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.cs.summercraft.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.cs.summercraft.block.TragaperrasBlock;
import net.cs.summercraft.block.ExpendedoraamarillaBlock;
import net.cs.summercraft.block.ExpendAmarillaBlock;
import net.cs.summercraft.block.CajeroAutomatico0Block;
import net.cs.summercraft.SummercraftMod;

public class SummercraftModBlocks {
	public static Block TRAGAPERRAS;
	public static Block EXPEND_AMARILLA;
	public static Block EXPENDEDORAAMARILLA;
	public static Block CAJERO_AUTOMATICO_0;

	public static void load() {
		TRAGAPERRAS = register("tragaperras", new TragaperrasBlock());
		EXPEND_AMARILLA = register("expend_amarilla", new ExpendAmarillaBlock());
		EXPENDEDORAAMARILLA = register("expendedoraamarilla", new ExpendedoraamarillaBlock());
		CAJERO_AUTOMATICO_0 = register("cajero_automatico_0", new CajeroAutomatico0Block());
	}

	public static void clientLoad() {
		TragaperrasBlock.clientInit();
		ExpendAmarillaBlock.clientInit();
		ExpendedoraamarillaBlock.clientInit();
		CajeroAutomatico0Block.clientInit();
	}

	private static Block register(String registryName, Block block) {
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(SummercraftMod.MODID, registryName), block);
	}
}
