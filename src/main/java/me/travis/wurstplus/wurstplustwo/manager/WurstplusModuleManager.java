//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.manager;

import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import net.minecraft.client.renderer.Tessellator;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventRender;
import me.travis.turok.draw.RenderHelp;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import java.util.Iterator;
import java.util.function.Function;
import java.util.Comparator;
import me.travis.wurstplus.wurstplustwo.hacks.dev.WurstplusFakePlayer;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusSpeedmine;
import me.travis.wurstplus.wurstplustwo.hacks.misc.WurstplusFastUtil;
import me.travis.wurstplus.wurstplustwo.hacks.misc.WurstplusAutoNomadHut;
import me.travis.wurstplus.wurstplustwo.hacks.misc.WurstplusAutoReplenish;
import me.travis.wurstplus.wurstplustwo.hacks.misc.WurstplusStopEXP;
import me.travis.wurstplus.wurstplustwo.hacks.misc.WurstplusMiddleClickFriends;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusCityEsp;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusAlwaysNight;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusCapes;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusChams;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusSkyColour;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusTracers;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusFuckedDetector;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusNameTags;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusAntifog;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusVoidESP;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusViewmodleChanger;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusShulkerPreview;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusHoleESP;
import me.travis.wurstplus.wurstplustwo.hacks.render.WurstplusHighlight;
import me.travis.wurstplus.wurstplustwo.hacks.movement.WurstPlusAnchor;
import me.travis.wurstplus.wurstplustwo.hacks.movement.WurstplusSprint;
import me.travis.wurstplus.wurstplustwo.hacks.movement.WurstplusStep;
import me.travis.wurstplus.wurstplustwo.hacks.movement.WurstplusStrafe;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusNoHandshake;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusCoordExploit;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusBuildHeight;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusEntityMine;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusPacketMine;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusPortalGodMode;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusNoSwing;
import me.travis.wurstplus.wurstplustwo.hacks.exploit.WurstplusXCarry;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoMine;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoTotem;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoGapple;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusOffhand;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusBedAura;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoWeb;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusWebfill;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAuto32k;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoArmour;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusSelfTrap;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusSocks;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusTrap;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusHoleFill;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusAutoCrystal;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusVelocity;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusSurround;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusKillAura;
import me.travis.wurstplus.wurstplustwo.hacks.combat.WurstplusCriticals;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusAnnouncer;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusAntiRacist;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusAutoEz;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusChatMods;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusClearChat;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusTotempop;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusVisualRange;
import me.travis.wurstplus.wurstplustwo.hacks.chat.WurstplusChatSuffix;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusClickHUD;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusClickGUI;
import net.minecraft.client.Minecraft;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import java.util.ArrayList;

public class WurstplusModuleManager
{
    public static ArrayList<WurstplusHack> array_hacks;
    public static Minecraft mc;
    
    public WurstplusModuleManager() {
        this.add_hack(new WurstplusClickGUI());
        this.add_hack(new WurstplusClickHUD());
        this.add_hack(new WurstplusChatSuffix());
        this.add_hack(new WurstplusVisualRange());
        this.add_hack(new WurstplusTotempop());
        this.add_hack(new WurstplusClearChat());
        this.add_hack(new WurstplusChatMods());
        this.add_hack(new WurstplusAutoEz());
        this.add_hack(new WurstplusAntiRacist());
        this.add_hack(new WurstplusAnnouncer());
        this.add_hack(new WurstplusCriticals());
        this.add_hack(new WurstplusKillAura());
        this.add_hack(new WurstplusSurround());
        this.add_hack(new WurstplusVelocity());
        this.add_hack(new WurstplusAutoCrystal());
        this.add_hack(new WurstplusHoleFill());
        this.add_hack(new WurstplusTrap());
        this.add_hack(new WurstplusSocks());
        this.add_hack(new WurstplusSelfTrap());
        this.add_hack(new WurstplusAutoArmour());
        this.add_hack(new WurstplusAuto32k());
        this.add_hack(new WurstplusWebfill());
        this.add_hack(new WurstplusAutoWeb());
        this.add_hack(new WurstplusBedAura());
        this.add_hack(new WurstplusOffhand());
        this.add_hack(new WurstplusAutoGapple());
        this.add_hack(new WurstplusAutoTotem());
        this.add_hack(new WurstplusAutoMine());
        this.add_hack(new WurstplusXCarry());
        this.add_hack(new WurstplusNoSwing());
        this.add_hack(new WurstplusPortalGodMode());
        this.add_hack(new WurstplusPacketMine());
        this.add_hack(new WurstplusEntityMine());
        this.add_hack(new WurstplusBuildHeight());
        this.add_hack(new WurstplusCoordExploit());
        this.add_hack(new WurstplusNoHandshake());
        this.add_hack(new WurstplusStrafe());
        this.add_hack(new WurstplusStep());
        this.add_hack(new WurstplusSprint());
        this.add_hack(new WurstPlusAnchor());
        this.add_hack(new WurstplusHighlight());
        this.add_hack(new WurstplusHoleESP());
        this.add_hack(new WurstplusShulkerPreview());
        this.add_hack(new WurstplusViewmodleChanger());
        this.add_hack(new WurstplusVoidESP());
        this.add_hack(new WurstplusAntifog());
        this.add_hack(new WurstplusNameTags());
        this.add_hack(new WurstplusFuckedDetector());
        this.add_hack(new WurstplusTracers());
        this.add_hack(new WurstplusSkyColour());
        this.add_hack(new WurstplusChams());
        this.add_hack(new WurstplusCapes());
        this.add_hack(new WurstplusAlwaysNight());
        this.add_hack(new WurstplusCityEsp());
        this.add_hack(new WurstplusMiddleClickFriends());
        this.add_hack(new WurstplusStopEXP());
        this.add_hack(new WurstplusAutoReplenish());
        this.add_hack(new WurstplusAutoNomadHut());
        this.add_hack(new WurstplusFastUtil());
        this.add_hack(new WurstplusSpeedmine());
        this.add_hack(new WurstplusFakePlayer());
        WurstplusModuleManager.array_hacks.sort(Comparator.comparing((Function<? super WurstplusHack, ? extends Comparable>)WurstplusHack::get_name));
    }
    
    public void add_hack(final WurstplusHack module) {
        WurstplusModuleManager.array_hacks.add(module);
    }
    
    public ArrayList<WurstplusHack> get_array_hacks() {
        return WurstplusModuleManager.array_hacks;
    }
    
    public ArrayList<WurstplusHack> get_array_active_hacks() {
        final ArrayList<WurstplusHack> actived_modules = new ArrayList<WurstplusHack>();
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.is_active()) {
                actived_modules.add(modules);
            }
        }
        return actived_modules;
    }
    
    public Vec3d process(final Entity entity, final double x, final double y, final double z) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * x, (entity.posY - entity.lastTickPosY) * y, (entity.posZ - entity.lastTickPosZ) * z);
    }
    
    public Vec3d get_interpolated_pos(final Entity entity, final double ticks) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(this.process(entity, ticks, ticks, ticks));
    }
    
    public void render(final RenderWorldLastEvent event) {
        WurstplusModuleManager.mc.profiler.startSection("wurstplus");
        WurstplusModuleManager.mc.profiler.startSection("setup");
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        GlStateManager.disableDepth();
        GlStateManager.glLineWidth(1.0f);
        final Vec3d pos = this.get_interpolated_pos((Entity)WurstplusModuleManager.mc.player, event.getPartialTicks());
        final WurstplusEventRender event_render = new WurstplusEventRender(RenderHelp.INSTANCE, pos);
        event_render.reset_translation();
        WurstplusModuleManager.mc.profiler.endSection();
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.is_active()) {
                WurstplusModuleManager.mc.profiler.startSection(modules.get_tag());
                modules.render(event_render);
                WurstplusModuleManager.mc.profiler.endSection();
            }
        }
        WurstplusModuleManager.mc.profiler.startSection("release");
        GlStateManager.glLineWidth(1.0f);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
        RenderHelp.release_gl();
        WurstplusModuleManager.mc.profiler.endSection();
        WurstplusModuleManager.mc.profiler.endSection();
    }
    
    public void update() {
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.is_active()) {
                modules.update();
            }
        }
    }
    
    public void render() {
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.is_active()) {
                modules.render();
            }
        }
    }
    
    public void bind(final int event_key) {
        if (event_key == 0) {
            return;
        }
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.get_bind(0) == event_key) {
                modules.toggle();
            }
        }
    }
    
    public WurstplusHack get_module_with_tag(final String tag) {
        WurstplusHack module_requested = null;
        for (final WurstplusHack module : this.get_array_hacks()) {
            if (module.get_tag().equalsIgnoreCase(tag)) {
                module_requested = module;
            }
        }
        return module_requested;
    }
    
    public ArrayList<WurstplusHack> get_modules_with_category(final WurstplusCategory category) {
        final ArrayList<WurstplusHack> module_requesteds = new ArrayList<WurstplusHack>();
        for (final WurstplusHack modules : this.get_array_hacks()) {
            if (modules.get_category().equals(category)) {
                module_requesteds.add(modules);
            }
        }
        return module_requesteds;
    }
    
    static {
        WurstplusModuleManager.array_hacks = new ArrayList<WurstplusHack>();
        WurstplusModuleManager.mc = Minecraft.getMinecraft();
    }
}
