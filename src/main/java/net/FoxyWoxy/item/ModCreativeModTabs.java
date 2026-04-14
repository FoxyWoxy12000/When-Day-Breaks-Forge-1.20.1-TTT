package net.FoxyWoxy.item;

import net.FoxyWoxy.block.ModBlocks;
import net.FoxyWoxy.whendaybreaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, whendaybreaks.MODID);
 public static final RegistryObject<CreativeModeTab> WHEN_DAY_BREAKES_TAB = CREATIVE_MODE_TABS.register("whendaybreaks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CONSUMABLE_FLESH_CHUNK.get()))
                    .title(Component.translatable("creativetab.whendaybreaks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.CONSUMABLE_FLESH_CHUNK.get());
                    pOutput.accept(ModItems.GOLDY_WEAPON.get());
                    pOutput.accept(ModBlocks.TRIPLE_T_BLOCK.get());
                    pOutput.accept(ModBlocks.FLESH_BLOCK.get());
                    pOutput.accept(ModItems.EXECUTION_SWORD.get());
                    })
                    .build());

    public static void  register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
