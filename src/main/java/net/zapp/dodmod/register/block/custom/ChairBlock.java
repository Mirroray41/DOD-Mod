package net.zapp.dodmod.register.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.zapp.dodmod.register.entity.EntityRegister;
import net.zapp.dodmod.register.entity.custom.SeatEntity;

public class ChairBlock extends OrientableFurnitureBlock{
    public ChairBlock(Properties p_54120_) {
        super(p_54120_);
    }

    private static final VoxelShape SHAPE =  Block.box(1, 0, 1, 15, 11, 15);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {

        if (!player.getItemInHand(hand).is(Items.AIR)) {
            return InteractionResult.FAIL;
        }

        Entity vehicle = player.getVehicle();
        if (vehicle != null) {
            if (vehicle instanceof SeatEntity && player.isCrouching()) {
                vehicle.remove(Entity.RemovalReason.KILLED);
            }
            return InteractionResult.FAIL;
        }

        Vec3 vec = new Vec3(pos.getX() + 0.5F, pos.getY() + 0.4F, pos.getZ() + 0.5F);
        double maxDistance = 2.0D;

        if (Math.pow(vec.x - player.getX(), 2) + Math.pow(vec.y - player.getY(), 2) + Math.pow(vec.z - player.getZ(), 2) > Math.pow(maxDistance, 2)) {
            return InteractionResult.FAIL;
        }

        if (level.getBlockState(pos).getBlock() instanceof ChairBlock) {
            SeatEntity entity = new SeatEntity(EntityRegister.SEAT.get(), level);
            entity.setDirection(level.getBlockState(pos).getValue(FACING));
            entity.setPos(vec);
            level.addFreshEntity(entity);
            player.startRiding(entity);
        }
        return super.use(state, level, pos, player, hand, result);
    }
}
