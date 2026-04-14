package net.FoxyWoxy.item;

import net.FoxyWoxy.whendaybreaks;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, whendaybreaks.MODID);


    public static final RegistryObject<Item> CONSUMABLE_FLESH_CHUNK = ITEMS.register("consumable_flesh",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLDY_WEAPON = ITEMS.register("godly_weapon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EXECUTION_SWORD = ITEMS.register("execution_sword",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}