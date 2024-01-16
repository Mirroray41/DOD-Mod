package net.zapp.dodmod.register.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class ChocolateCakeBlock extends CakeBlock {
    public ChocolateCakeBlock(Properties p_51184_) {
        super(p_51184_);
    }

    public InteractionResult use(BlockState p_51202_, Level p_51203_, BlockPos p_51204_, Player p_51205_, InteractionHand p_51206_, BlockHitResult p_51207_) {
        ItemStack itemstack = p_51205_.getItemInHand(p_51206_);

        if (p_51203_.isClientSide) {
            if (eat(p_51203_, p_51204_, p_51202_, p_51205_).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(p_51203_, p_51204_, p_51202_, p_51205_);
    }

    protected static InteractionResult eat(LevelAccessor p_51186_, BlockPos p_51187_, BlockState p_51188_, Player p_51189_) {
        if (!p_51189_.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            p_51189_.awardStat(Stats.EAT_CAKE_SLICE);
            p_51189_.getFoodData().eat(3, 0.1F);
            p_51189_.addEffect(new MobEffectInstance(MobEffect.byId(1), 100, 1));
            int i = p_51188_.getValue(BITES);
            p_51186_.gameEvent(p_51189_, GameEvent.EAT, p_51187_);
            if (i < 6) {
                p_51186_.setBlock(p_51187_, p_51188_.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                p_51186_.removeBlock(p_51187_, false);
                p_51186_.gameEvent(p_51189_, GameEvent.BLOCK_DESTROY, p_51187_);
            }

            return InteractionResult.SUCCESS;
        }
    }
}
