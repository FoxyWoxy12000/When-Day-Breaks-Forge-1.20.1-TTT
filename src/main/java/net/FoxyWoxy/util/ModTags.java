package net.FoxyWoxy.util;

import net.FoxyWoxy.whendaybreaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.BlockTags;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> EXECUTIONER = tag("executioner");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(whendaybreaks.MODID, name));
        }
    }
}
