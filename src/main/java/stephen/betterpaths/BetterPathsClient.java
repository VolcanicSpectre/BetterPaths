package stephen.betterpaths;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stephen.betterpaths.block.GrassSlab;
import stephen.betterpaths.block.ModBlocks;

import static stephen.betterpaths.block.ModBlocks.DIRT_PATH_SLAB;
import static stephen.betterpaths.block.ModBlocks.GRASS_SLAB;

public class BetterPathsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {if (world == null || pos == null) {
            return GrassColors.getDefaultColor();
        }
            return BiomeColors.getGrassColor(world, pos);}, GRASS_SLAB);
        BlockRenderLayerMap.INSTANCE.putBlock(GRASS_SLAB, RenderLayer.getCutoutMipped());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getDefaultColor(), GRASS_SLAB);
    }
}
