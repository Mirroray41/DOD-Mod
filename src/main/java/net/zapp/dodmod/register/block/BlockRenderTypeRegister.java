package net.zapp.dodmod.register.block;


import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.zapp.dodmod.DodMod;

@Mod.EventBusSubscriber(modid = DodMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockRenderTypeRegister{
    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.TABLE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.TABLE_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.TABLE_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.RACK_3.get(), RenderType.cutout());
    }
}