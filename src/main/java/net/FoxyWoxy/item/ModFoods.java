package net.FoxyWoxy.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods {
    public static final FoodProperties FLESH = new FoodProperties.Builder().alwaysEat()
            .saturationMod(3).nutrition(4).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 0.2f).build();
}
