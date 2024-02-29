package net.zapp.dodmod.register.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class TableBlock extends OrientableFurnitureBlock {
    public TableBlock(Properties p_54120_) {
        super(p_54120_);
    }


    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        if (p_60567_.getBlockState(p_60568_.relative(p_60567_.getBlockState(p_60568_).getValue(FACING).getOpposite())).is(Blocks.AIR)) {
            p_60567_.setBlockAndUpdate(p_60568_.relative(p_60567_.getBlockState(p_60568_).getValue(FACING).getOpposite()), Blocks.BARRIER.defaultBlockState());
        }
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (level.getBlockState(pos.relative(level.getBlockState(pos).getValue(FACING).getOpposite())).is(Blocks.BARRIER)) {
            level.setBlockAndUpdate(pos.relative(level.getBlockState(pos).getValue(FACING).getOpposite()), Blocks.AIR.defaultBlockState());
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
