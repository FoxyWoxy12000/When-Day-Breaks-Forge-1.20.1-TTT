package net.FoxyWoxy.item;

import net.FoxyWoxy.util.ModTags;
import net.FoxyWoxy.whendaybreaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraft.world.item.Tier;

import java.util.List;

public class ModToolTeirs {
    public static final Tier EXECUTIONER = TierSortingRegistry.registerTier(
            new ForgeTier(8, 2000, 0f, 200f, 25,
                    ModTags.Blocks.EXECUTIONER, () -> Ingredient.of(ModItems.GOLDY_WEAPON.get())),
            new ResourceLocation(whendaybreaks.MODID, "executioner"), List.of(Tiers.NETHERITE), List.of());
}
