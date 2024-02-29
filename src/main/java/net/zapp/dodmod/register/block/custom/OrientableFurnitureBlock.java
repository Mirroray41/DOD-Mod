package net.zapp.dodmod.register.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class OrientableFurnitureBlock extends HorizontalDirectionalBlock {
    public OrientableFurnitureBlock(Properties p_54120_) {
        super(p_54120_);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder< Block, BlockState > p_48725_) {
        p_48725_.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (pContext.getPlayer().isCrouching()) {
            return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getCounterClockWise());
        }
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite().getCounterClockWise());
    }

    public boolean skipRendering(BlockState p_53972_, BlockState p_53973_, Direction p_53974_) {
        return p_53973_.is(this) ? true : super.skipRendering(p_53972_, p_53973_, p_53974_);
    }

    public VoxelShape getVisualShape(BlockState p_48735_, BlockGetter p_48736_, BlockPos p_48737_, CollisionContext p_48738_) {
        return Shapes.empty();
    }

    public float getShadeBrightness(BlockState p_48731_, BlockGetter p_48732_, BlockPos p_48733_) {
        return 1.0F;
    }

    public boolean propagatesSkylightDown(BlockState p_48740_, BlockGetter p_48741_, BlockPos p_48742_) {
        return true;
    }
}
