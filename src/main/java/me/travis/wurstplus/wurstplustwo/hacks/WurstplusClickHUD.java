//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks;

import net.minecraft.client.gui.GuiScreen;
import me.travis.wurstplus.Wurstplus;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;

public class WurstplusClickHUD extends WurstplusHack
{
    WurstplusSetting frame_view;
    WurstplusSetting strings_r;
    WurstplusSetting strings_g;
    WurstplusSetting strings_b;
    WurstplusSetting strings_a;
    WurstplusSetting compass_scale;
    WurstplusSetting arraylist_mode;
    WurstplusSetting show_all_pots;
    WurstplusSetting max_player_list;
    
    public WurstplusClickHUD() {
        super(WurstplusCategory.WURSTPLUS_GUI);
        this.frame_view = this.create("info", "HUDStringsList", "Strings");
        this.strings_r = this.create("Color R", "HUDStringsColorR", 255, 0, 255);
        this.strings_g = this.create("Color G", "HUDStringsColorG", 255, 0, 255);
        this.strings_b = this.create("Color B", "HUDStringsColorB", 255, 0, 255);
        this.strings_a = this.create("Alpha", "HUDStringsColorA", 230, 0, 255);
        this.compass_scale = this.create("Compass Scale", "HUDCompassScale", 16, 1, 60);
        this.arraylist_mode = this.create("ArrayList", "HUDArrayList", "Free", this.combobox("Free", "Top R", "Top L", "Bottom R", "Bottom L"));
        this.show_all_pots = this.create("All Potions", "HUDAllPotions", false);
        this.max_player_list = this.create("Max Players", "HUDMaxPlayers", 24, 1, 64);
        this.name = "HUD";
        this.tag = "HUD";
        this.description = "gui for pinnables";
    }
    
    public void enable() {
        if (WurstplusClickHUD.mc.world != null && WurstplusClickHUD.mc.player != null) {
            Wurstplus.get_hack_manager().get_module_with_tag("GUI").set_active(false);
            Wurstplus.click_hud.back = false;
            WurstplusClickHUD.mc.displayGuiScreen((GuiScreen)Wurstplus.click_hud);
        }
    }
}
