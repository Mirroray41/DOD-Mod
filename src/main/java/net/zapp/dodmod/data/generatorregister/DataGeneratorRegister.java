package net.zapp.dodmod.data.generatorregister;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.data.BlockStateGenerator;
import net.zapp.dodmod.data.ItemModelGenerator;
import net.zapp.dodmod.data.RecipeGenerator;
import net.zapp.dodmod.data.languagegenerator.LanguageGeneratorEN_US;

@Mod.EventBusSubscriber(modid = DodMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorRegister {
    @SubscribeEvent
    public static <PackOutput> void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        net.minecraft.data.PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new RecipeGenerator(packOutput));
        generator.addProvider(true, BlockLootTableRegister.create(packOutput));
        generator.addProvider(true, new BlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(true, new ItemModelGenerator(packOutput, existingFileHelper));

        generator.addProvider(true, new LanguageGeneratorEN_US(packOutput));
    }
}