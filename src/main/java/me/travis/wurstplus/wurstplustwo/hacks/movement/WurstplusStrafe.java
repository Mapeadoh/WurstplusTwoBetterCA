//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.hacks.movement;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.MobEffects;
import java.util.function.Predicate;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventMove;
import me.zero.alpine.fork.listener.EventHandler;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPlayerJump;
import me.zero.alpine.fork.listener.Listener;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;

public class WurstplusStrafe extends WurstplusHack
{
    WurstplusSetting speed_mode;
    WurstplusSetting auto_sprint;
    WurstplusSetting on_water;
    WurstplusSetting auto_jump;
    WurstplusSetting backward;
    WurstplusSetting bypass;
    @EventHandler
    private Listener<WurstplusEventPlayerJump> on_jump;
    @EventHandler
    private Listener<WurstplusEventMove> player_move;
    
    public WurstplusStrafe() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);
        this.speed_mode = this.create("Mode", "StrafeMode", "Strafe", this.combobox("Strafe", "On Ground"));
        this.auto_sprint = this.create("Auto Sprint", "StrafeSprint", true);
        this.on_water = this.create("On Water", "StrafeOnWater", true);
        this.auto_jump = this.create("Auto Jump", "StrafeAutoJump", true);
        this.backward = this.create("Backwards", "StrafeBackwards", true);
        this.bypass = this.create("Bypass", "StrafeBypass", false);
        this.on_jump = new Listener<WurstplusEventPlayerJump>(event -> {
            if (this.speed_mode.in("Strafe")) {
                event.cancel();
            }
            return;
        }, (Predicate<WurstplusEventPlayerJump>[])new Predicate[0]);
        float player_speed;
        float move_forward;
        float move_strafe;
        float rotation_yaw;
        int amp;
        this.player_move = new Listener<WurstplusEventMove>(event -> {
            if (this.speed_mode.in("On Ground")) {
                return;
            }
            else if ((WurstplusStrafe.mc.player.isInWater() || WurstplusStrafe.mc.player.isInLava()) && !this.speed_mode.get_value(true)) {
                return;
            }
            else if (WurstplusStrafe.mc.player.isSneaking() || WurstplusStrafe.mc.player.isOnLadder() || WurstplusStrafe.mc.player.isInWeb || WurstplusStrafe.mc.player.isInLava() || WurstplusStrafe.mc.player.isInWater() || WurstplusStrafe.mc.player.capabilities.isFlying) {
                return;
            }
            else {
                player_speed = 0.2873f;
                move_forward = WurstplusStrafe.mc.player.movementInput.moveForward;
                move_strafe = WurstplusStrafe.mc.player.movementInput.moveStrafe;
                rotation_yaw = WurstplusStrafe.mc.player.rotationYaw;
                if (WurstplusStrafe.mc.player.isPotionActive(MobEffects.SPEED)) {
                    amp = WurstplusStrafe.mc.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
                    player_speed *= 1.2f * (amp + 1);
                }
                if (!this.bypass.get_value(true)) {
                    player_speed *= 1.0064f;
                }
                if (move_forward == 0.0f && move_strafe == 0.0f) {
                    event.set_x(0.0);
                    event.set_z(0.0);
                }
                else {
                    if (move_forward != 0.0f) {
                        if (move_strafe > 0.0f) {
                            rotation_yaw += ((move_forward > 0.0f) ? -45 : 45);
                        }
                        else if (move_strafe < 0.0f) {
                            rotation_yaw += ((move_forward > 0.0f) ? 45 : -45);
                        }
                        move_strafe = 0.0f;
                        if (move_forward > 0.0f) {
                            move_forward = 1.0f;
                        }
                        else if (move_forward < 0.0f) {
                            move_forward = -1.0f;
                        }
                    }
                    event.set_x(move_forward * player_speed * Math.cos(Math.toRadians(rotation_yaw + 90.0f)) + move_strafe * player_speed * Math.sin(Math.toRadians(rotation_yaw + 90.0f)));
                    event.set_z(move_forward * player_speed * Math.sin(Math.toRadians(rotation_yaw + 90.0f)) - move_strafe * player_speed * Math.cos(Math.toRadians(rotation_yaw + 90.0f)));
                }
                event.cancel();
                return;
            }
        }, (Predicate<WurstplusEventMove>[])new Predicate[0]);
        this.name = "Strafe";
        this.tag = "Strafe";
        this.description = "its like running, but faster";
    }
    
    @Override
    public void update() {
        if (WurstplusStrafe.mc.player.isRiding()) {
            return;
        }
        if ((WurstplusStrafe.mc.player.isInWater() || WurstplusStrafe.mc.player.isInLava()) && !this.on_water.get_value(true)) {
            return;
        }
        if (WurstplusStrafe.mc.player.moveForward != 0.0f || WurstplusStrafe.mc.player.moveStrafing != 0.0f) {
            if (WurstplusStrafe.mc.player.moveForward < 0.0f && !this.backward.get_value(true)) {
                return;
            }
            if (this.auto_sprint.get_value(true)) {
                WurstplusStrafe.mc.player.setSprinting(true);
            }
            if (WurstplusStrafe.mc.player.onGround && this.speed_mode.in("Strafe")) {
                if (this.auto_jump.get_value(true)) {
                    WurstplusStrafe.mc.player.motionY = 0.4050000011920929;
                }
                final float yaw = this.get_rotation_yaw() * 0.017453292f;
                final EntityPlayerSP player = WurstplusStrafe.mc.player;
                player.motionX -= MathHelper.sin(yaw) * 0.2f;
                final EntityPlayerSP player2 = WurstplusStrafe.mc.player;
                player2.motionZ += MathHelper.cos(yaw) * 0.2f;
            }
            else if (WurstplusStrafe.mc.player.onGround && this.speed_mode.in("On Ground")) {
                final float yaw = this.get_rotation_yaw();
                final EntityPlayerSP player3 = WurstplusStrafe.mc.player;
                player3.motionX -= MathHelper.sin(yaw) * 0.2f;
                final EntityPlayerSP player4 = WurstplusStrafe.mc.player;
                player4.motionZ += MathHelper.cos(yaw) * 0.2f;
                WurstplusStrafe.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(WurstplusStrafe.mc.player.posX, WurstplusStrafe.mc.player.posY + 0.4, WurstplusStrafe.mc.player.posZ, false));
            }
        }
        if (WurstplusStrafe.mc.gameSettings.keyBindJump.isKeyDown() && WurstplusStrafe.mc.player.onGround) {
            WurstplusStrafe.mc.player.motionY = 0.4050000011920929;
        }
    }
    
    private float get_rotation_yaw() {
        float rotation_yaw = WurstplusStrafe.mc.player.rotationYaw;
        if (WurstplusStrafe.mc.player.moveForward < 0.0f) {
            rotation_yaw += 180.0f;
        }
        float n = 1.0f;
        if (WurstplusStrafe.mc.player.moveForward < 0.0f) {
            n = -0.5f;
        }
        else if (WurstplusStrafe.mc.player.moveForward > 0.0f) {
            n = 0.5f;
        }
        if (WurstplusStrafe.mc.player.moveStrafing > 0.0f) {
            rotation_yaw -= 90.0f * n;
        }
        if (WurstplusStrafe.mc.player.moveStrafing < 0.0f) {
            rotation_yaw += 90.0f * n;
        }
        return rotation_yaw * 0.017453292f;
    }
}
