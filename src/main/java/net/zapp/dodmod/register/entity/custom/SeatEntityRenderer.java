package net.zapp.dodmod.register.entity.custom;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.zapp.dodmod.DodMod;

public class SeatEntityRenderer extends MobRenderer<SeatEntity, SeatEntityModel<SeatEntity>> {


    public SeatEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SeatEntityModel<>(), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity p_114482_) {
        return new ResourceLocation(DodMod.MOD_ID, "textures/entity/seat.png");
    }

    @Override
    public boolean shouldRender(SeatEntity p_115468_, Frustum p_115469_, double p_115470_, double p_115471_, double p_115472_) {
        return false;
    }
}
