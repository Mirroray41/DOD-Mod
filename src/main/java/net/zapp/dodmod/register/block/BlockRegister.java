package net.zapp.dodmod.register.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.block.custom.ChocolateCakeBlock;
import net.zapp.dodmod.register.item.ItemRegister;

import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DodMod.MOD_ID);

    public static final RegistryObject<Block> TEMPBLOCK = registerBlock("tempblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)
                    .strength(0.1f)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = registerBlock("chocolate_cake",
            () -> new ChocolateCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegister.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}