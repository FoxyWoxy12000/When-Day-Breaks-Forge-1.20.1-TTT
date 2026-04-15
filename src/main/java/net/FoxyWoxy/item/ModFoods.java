package net.FoxyWoxy.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods {
    public static final FoodProperties FLESH = new FoodProperties.Builder().alwaysEat()
            .saturationMod(3).nutrition(4).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 1), 0.2f).build();
    public static final FoodProperties FLESH_BLOCK_FOOD = new FoodProperties.Builder().alwaysEat()
            .saturationMod(6).nutrition(8).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 5), 0.5f).build();

    public static final FoodProperties FLESH_COOKED = new FoodProperties.Builder().alwaysEat()
            .saturationMod(4).nutrition(5).build();
    public static final FoodProperties FLESH_BLOCK_COOKED = new FoodProperties.Builder().alwaysEat()
            .saturationMod(8).nutrition(10).build();
}
