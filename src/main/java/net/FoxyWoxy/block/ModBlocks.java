package net.FoxyWoxy.block;

import net.FoxyWoxy.item.ModFoods;
import net.FoxyWoxy.item.ModItems;
import net.FoxyWoxy.whendaybreaks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Function;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, whendaybreaks.MODID);

    public static final RegistryObject<Block> TRIPLE_T_BLOCK = registerBlock("big_t_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().lightLevel(state -> 0)));

    public static final RegistryObject<Block> EVIL_PAINTER_REGECTED_BLOCK = registerBlock("evil_painter_block",
    () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));

    public static final RegistryObject<Block> FLESH_BLOCK = registerBlock("flesh_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WET_SPONGE).sound(SoundType.SLIME_BLOCK)),
            block -> new BlockItem(block, new Item.Properties().food(ModFoods.FLESH_BLOCK_FOOD)));

    public static final RegistryObject<Block> FLESH_BLOCK_COOKED = registerBlock("flesh_block_cooked",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WET_SPONGE).sound(SoundType.HONEY_BLOCK)),
            block -> new BlockItem(block, new Item.Properties().food(ModFoods.FLESH_BLOCK_COOKED)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     Function<T, BlockItem> itemFactory) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> itemFactory.apply(toReturn.get()));
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
