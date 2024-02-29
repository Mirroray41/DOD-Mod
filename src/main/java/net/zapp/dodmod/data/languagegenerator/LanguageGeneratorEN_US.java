package net.zapp.dodmod.data.languagegenerator;


import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.zapp.dodmod.DodMod;
import net.zapp.dodmod.register.block.BlockRegister;
import net.zapp.dodmod.register.item.ItemRegister;

public class LanguageGeneratorEN_US extends LanguageProvider {
    public LanguageGeneratorEN_US(PackOutput output) {
        //Change the locale parameter to add different languages!
        super(output, DodMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemtab.prore_tab","DOD Mod!");

        add(ItemRegister.TEMPITEM.get(), "Temp Item");
        add(BlockRegister.TEMPBLOCK.get(), "Temp Block");
        add(BlockRegister.LINOTITH.get(), "Linolith");

        add(BlockRegister.CHOCOLATE_CAKE.get(), "Chocolate Cake");
    }
}