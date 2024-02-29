package net.zapp.dodmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.entity.EntityRegister;
import net.zapp.dodmod.register.entity.custom.SeatEntity;

@Mod.EventBusSubscriber(modid = DodMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterMobAtributesEvent {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegister.SEAT.get(), SeatEntity.createAttributes().build());
    }
}
