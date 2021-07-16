//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus;

import me.travis.turok.task.Font;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import me.travis.wurstplus.wurstplustwo.event.WurstplusEventRegister;
import org.lwjgl.opengl.Display;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusCommandManager;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusEventManager;
import me.travis.wurstplus.wurstplustwo.event.WurstplusEventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.mojang.realmsclient.gui.ChatFormatting;
import me.travis.turok.Turok;
import me.travis.wurstplus.wurstplustwo.guiscreen.WurstplusHUD;
import me.travis.wurstplus.wurstplustwo.guiscreen.WurstplusGUI;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusHUDManager;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusModuleManager;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusConfigManager;
import me.travis.wurstplus.wurstplustwo.manager.WurstplusSettingManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "wurstplus", version = "1.0")
public class Wurstplus
{
    @Mod.Instance
    private static Wurstplus MASTER;
    public static final String WURSTPLUS_NAME = "Wurst+ 2";
    public static final String WURSTPLUS_VERSION = "1.0";
    public static final String WURSTPLUS_SIGN = " ";
    public static final int WURSTPLUS_KEY_GUI = 54;
    public static final int WURSTPLUS_KEY_DELETE = 211;
    public static final int WURSTPLUS_KEY_GUI_ESCAPE = 1;
    public static Logger wurstplus_register_log;
    private static WurstplusSettingManager setting_manager;
    private static WurstplusConfigManager config_manager;
    private static WurstplusModuleManager module_manager;
    private static WurstplusHUDManager hud_manager;
    public static WurstplusGUI click_gui;
    public static WurstplusHUD click_hud;
    public static Turok turok;
    public static ChatFormatting g;
    public static ChatFormatting r;
    
    @Mod.EventHandler
    public void WurstplusStarting(final FMLInitializationEvent event) {
        this.init_log("Wurst+ 2");
        WurstplusEventHandler.INSTANCE = new WurstplusEventHandler();
        send_minecraft_log("initialising managers");
        Wurstplus.setting_manager = new WurstplusSettingManager();
        Wurstplus.config_manager = new WurstplusConfigManager();
        Wurstplus.module_manager = new WurstplusModuleManager();
        Wurstplus.hud_manager = new WurstplusHUDManager();
        final WurstplusEventManager event_manager = new WurstplusEventManager();
        final WurstplusCommandManager command_manager = new WurstplusCommandManager();
        send_minecraft_log("done");
        send_minecraft_log("initialising guis");
        Display.setTitle("Wurst+ 2");
        Wurstplus.click_gui = new WurstplusGUI();
        Wurstplus.click_hud = new WurstplusHUD();
        send_minecraft_log("done");
        send_minecraft_log("initialising skidded framework");
        Wurstplus.turok = new Turok("Turok");
        send_minecraft_log("done");
        send_minecraft_log("initialising commands and events");
        WurstplusEventRegister.register_command_manager(command_manager);
        WurstplusEventRegister.register_module_manager(event_manager);
        send_minecraft_log("done");
        send_minecraft_log("loading settings");
        Wurstplus.config_manager.load_settings();
        send_minecraft_log("done");
        if (Wurstplus.module_manager.get_module_with_tag("GUI").is_active()) {
            Wurstplus.module_manager.get_module_with_tag("GUI").set_active(false);
        }
        if (Wurstplus.module_manager.get_module_with_tag("HUD").is_active()) {
            Wurstplus.module_manager.get_module_with_tag("HUD").set_active(false);
        }
        send_minecraft_log("client started");
        send_minecraft_log("we gaming");
    }
    
    public void init_log(final String name) {
        Wurstplus.wurstplus_register_log = LogManager.getLogger(name);
        send_minecraft_log("starting wurstplustwo");
    }
    
    public static void send_minecraft_log(final String log) {
        Wurstplus.wurstplus_register_log.info(log);
    }
    
    public static String get_name() {
        return "Wurst+ 2";
    }
    
    public static String get_version() {
        return "1.0";
    }
    
    public static String get_actual_user() {
        return Minecraft.getMinecraft().getSession().getUsername();
    }
    
    public static WurstplusConfigManager get_config_manager() {
        return Wurstplus.config_manager;
    }
    
    public static WurstplusModuleManager get_hack_manager() {
        return Wurstplus.module_manager;
    }
    
    public static WurstplusSettingManager get_setting_manager() {
        return Wurstplus.setting_manager;
    }
    
    public static WurstplusHUDManager get_hud_manager() {
        return Wurstplus.hud_manager;
    }
    
    public static WurstplusModuleManager get_module_manager() {
        return Wurstplus.module_manager;
    }
    
    public static WurstplusEventHandler get_event_handler() {
        return WurstplusEventHandler.INSTANCE;
    }
    
    public static String smoth(final String base) {
        return Font.smoth(base);
    }
    
    static {
        Wurstplus.g = ChatFormatting.DARK_GRAY;
        Wurstplus.r = ChatFormatting.RESET;
    }
}
