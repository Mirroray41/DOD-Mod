package net.zapp.dodmod.register.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.block.custom.*;
import net.zapp.dodmod.register.item.ItemRegister;

import java.util.function.Supplier;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DodMod.MOD_ID);

    public static final RegistryObject<Block> TEMPBLOCK = registerBlock("tempblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK)
                    .strength(0.1f)));

    public static final RegistryObject<Block> LINOTITH = registerBlock("linolith",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = registerBlock("chocolate_cake",
            () -> new ChocolateCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

    public static final RegistryObject<Block> CHAIR_1 = registerBlock("chair_1",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().noCollission()));

    public static final RegistryObject<Block> TABLE_1 = registerBlock("table_1",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> TABLE_2 = registerBlock("table_2",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> TABLE_3 = registerBlock("table_3",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    public static final RegistryObject<Block> PC_1 = registerBlock("pc_1",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PC_2 = registerBlock("pc_2",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().noCollission()));

    public static final RegistryObject<Block> RACK_1 = registerBlock("rack_1",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RACK_2 = registerBlock("rack_2",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().noCollission()));

    public static final RegistryObject<Block> RACK_3 = registerBlock("rack_3",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RACK_4 = registerBlock("rack_4",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> PROJECTOR_1 = registerBlock("projector_1",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().noCollission()));

    public static final RegistryObject<Block> SHELF_1 = registerBlock("shelf_1",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> BOX_1 = registerBlock("box_1",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> LIGHT_1 = registerBlock("light_1",
            () -> new OrientableFurnitureBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().lightLevel((blockState) -> 15).noCollission()));


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