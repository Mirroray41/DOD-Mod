package net.zapp.dodmod.register.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.entity.custom.SeatEntity;

public class EntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DodMod.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            ENTITY_TYPES.register("seat", () -> EntityType.Builder.of(SeatEntity::new, MobCategory.MISC)
                    .sized(0.1f, 0.1f).build("seat"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}