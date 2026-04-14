package net.FoxyWoxy.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class ModSwordItem extends SwordItem {

    private static final UUID REACH_UUID = UUID.fromString("12345678-1234-1234-1234-123456789012");
    private static final UUID HEALTH_UUID = UUID.fromString("87654321-4321-4321-4321-210987654321");

    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public ModSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        // Keep vanilla sword attributes
        builder.putAll(super.getDefaultAttributeModifiers(EquipmentSlot.MAINHAND));

        // +3 Reach
        builder.put(ForgeMod.ENTITY_REACH.get(),
                new AttributeModifier(REACH_UUID, "Reach boost", 3.0D, AttributeModifier.Operation.ADDITION));

        // +20 Max Health
        builder.put(Attributes.MAX_HEALTH,
                new AttributeModifier(HEALTH_UUID, "Health boost", 20.0D, AttributeModifier.Operation.ADDITION));

        attributeModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getDefaultAttributeModifiers(slot);
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (level.isClientSide) return;

        if (entity instanceof Player player && isSelected) {

            // Only heal if not full HP
            if (player.getHealth() < player.getMaxHealth()) {

                if (player.tickCount % 20 == 0) {

                    player.heal(2.0F); // half heart per second

                }
            }
        }

        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }
    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }
}