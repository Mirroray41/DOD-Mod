package net.zapp.dodmod.data;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.zapp.dodmod.register.block.BlockRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BlockLootTablesGenerator extends BlockLootSubProvider {
    public BlockLootTablesGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegister.TEMPBLOCK.get());
        dropOther(BlockRegister.CHOCOLATE_CAKE.get(), Items.AIR);
        dropSelf(BlockRegister.LINOTITH.get());
        dropSelf(BlockRegister.TABLE_1.get());
        dropSelf(BlockRegister.TABLE_2.get());
        dropSelf(BlockRegister.TABLE_3.get());
        dropSelf(BlockRegister.CHAIR_1.get());
        dropSelf(BlockRegister.RACK_1.get());
        dropSelf(BlockRegister.PC_1.get());
        dropSelf(BlockRegister.PC_2.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegister.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}