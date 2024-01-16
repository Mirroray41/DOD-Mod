package net.zapp.dodmod.register.itemtab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.block.BlockRegister;
import net.zapp.dodmod.register.item.ItemRegister;

public class ItemTabRegister {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            DodMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> DOD_TAB = CREATIVE_MODE_TABS.register("dod_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(BlockRegister.CHOCOLATE_CAKE.get()))
                    .title(Component.translatable("itemtab.prore_tab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}