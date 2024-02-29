package net.zapp.dodmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zapp.dodmod.register.block.BlockRegister;
import net.zapp.dodmod.register.effects.EffectRegister;
import net.zapp.dodmod.register.entity.EntityRegister;
import net.zapp.dodmod.register.entity.custom.SeatEntityRenderer;
import net.zapp.dodmod.register.item.ItemRegister;
import net.zapp.dodmod.register.itemtab.ItemTabRegister;
import org.slf4j.Logger;


@Mod(DodMod.MOD_ID)
public class DodMod {
    public static final String MOD_ID = "dodmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DodMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegister.register(modEventBus);
        BlockRegister.register(modEventBus);
        ItemTabRegister.register(modEventBus);
        EffectRegister.register(modEventBus);
        EntityRegister.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == ItemTabRegister.DOD_TAB.get()) {
            event.accept(BlockRegister.CHOCOLATE_CAKE.get());
            event.accept(BlockRegister.CHAIR_1.get());
            event.accept(BlockRegister.TABLE_1.get());
            event.accept(BlockRegister.TABLE_2.get());
            event.accept(BlockRegister.TABLE_3.get());
            event.accept(BlockRegister.PC_1.get());
            event.accept(BlockRegister.PC_2.get());
            event.accept(BlockRegister.RACK_1.get());
            event.accept(BlockRegister.RACK_2.get());
            event.accept(BlockRegister.RACK_3.get());
            event.accept(BlockRegister.RACK_4.get());
            event.accept(BlockRegister.SHELF_1.get());
            event.accept(BlockRegister.BOX_1.get());
            event.accept(BlockRegister.PROJECTOR_1.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(EntityRegister.SEAT.get(), SeatEntityRenderer::new);
        }
    }
}