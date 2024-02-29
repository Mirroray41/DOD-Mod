package net.zapp.dodmod.register.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.effects.custom.DiabetesEffect;

public class EffectRegister {
    public static final DeferredRegister<MobEffect> MOB_EFFECT
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DodMod.MOD_ID);


    public static final RegistryObject<MobEffect> DIABETES_EFFECT = MOB_EFFECT.register("diabetes_effect",
            () -> new DiabetesEffect(MobEffectCategory.HARMFUL, 8406272));

    public static void register(IEventBus eventBus) {
        MOB_EFFECT.register(eventBus);
    }
}
