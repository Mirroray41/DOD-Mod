package net.zapp.dodmod.register.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class ShelfBlock extends OrientableFurnitureBlock{
    public ShelfBlock(Properties p_54120_) {
        super(p_54120_);
    }

    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        if (p_60567_.getBlockState(p_60568_.above()).is(Blocks.AIR)) {
            p_60567_.setBlockAndUpdate(p_60568_.above(), Blocks.BARRIER.defaultBlockState());
        }
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (level.getBlockState(pos.above()).is(Blocks.BARRIER)) {
            level.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
