package net.zapp.dodmod.register.entity.custom;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public class SeatEntity extends Mob {

    private Direction facing = Direction.NORTH;


    public SeatEntity(EntityType<? extends Mob> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);
    }

    @Override
    public boolean isNoAi() {
        return true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes();
    }

    public void setDirection(Direction facing) {
        this.facing = facing;
    }
    boolean hasLastTick = true;
    @Override
    public void tick() {
        super.tick();

        self().setYBodyRot(this.facing.toYRot());
        if (self().getPassengers() instanceof LivingEntity) {
            System.out.println("player riding");
        }
        if (self().getPassengers().isEmpty() && !hasLastTick) {
            remove(RemovalReason.KILLED);
            System.out.println("killed");
        } else {
            hasLastTick = false;
        }
    }
}
