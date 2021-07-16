//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.12 stable mappings"!

// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.util;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import me.travis.wurstplus.wurstplustwo.guiscreen.settings.WurstplusSetting;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

public class WurstplusEntityUtil
{
    public static final Minecraft mc;
    
    public static void attackEntity(final Entity entity, final boolean packet, final WurstplusSetting setting) {
        if (packet) {
            WurstplusEntityUtil.mc.player.connection.sendPacket((Packet)new CPacketUseEntity(entity));
        }
        else {
            WurstplusEntityUtil.mc.playerController.attackEntity((EntityPlayer)WurstplusEntityUtil.mc.player, entity);
        }
        if (setting.in("Mainhand") || setting.in("Both")) {
            WurstplusEntityUtil.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
        if (setting.in("Offhand") || setting.in("Both")) {
            WurstplusEntityUtil.mc.player.swingArm(EnumHand.OFF_HAND);
        }
    }
    
    public static boolean isLiving(final Entity e) {
        return e instanceof EntityLivingBase;
    }
    
    public static Vec3d getInterpolatedAmount(final Entity entity, final double x, final double y, final double z) {
        return new Vec3d((entity.posX - entity.lastTickPosX) * x, 0.0 * y, (entity.posZ - entity.lastTickPosZ) * z);
    }
    
    public static Vec3d getInterpolatedAmount(final Entity entity, final double ticks) {
        return getInterpolatedAmount(entity, ticks, ticks, ticks);
    }
    
    public static Vec3d getInterpolatedPos(final Entity entity, final float ticks) {
        return new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(getInterpolatedAmount(entity, ticks));
    }
    
    public static Vec3d getInterpolatedRenderPos(final Entity entity, final float ticks) {
        return getInterpolatedPos(entity, ticks).subtract(WurstplusEntityUtil.mc.getRenderManager().renderPosX, WurstplusEntityUtil.mc.getRenderManager().renderPosY, WurstplusEntityUtil.mc.getRenderManager().renderPosZ);
    }
    
    public static BlockPos is_cityable(final EntityPlayer player, final boolean end_crystal) {
        final BlockPos pos = new BlockPos(player.posX, player.posY, player.posZ);
        if (WurstplusEntityUtil.mc.world.getBlockState(pos.north()).getBlock() == Blocks.OBSIDIAN) {
            if (end_crystal) {
                return pos.north();
            }
            if (WurstplusEntityUtil.mc.world.getBlockState(pos.north().north()).getBlock() == Blocks.AIR) {
                return pos.north();
            }
        }
        if (WurstplusEntityUtil.mc.world.getBlockState(pos.east()).getBlock() == Blocks.OBSIDIAN) {
            if (end_crystal) {
                return pos.east();
            }
            if (WurstplusEntityUtil.mc.world.getBlockState(pos.east().east()).getBlock() == Blocks.AIR) {
                return pos.east();
            }
        }
        if (WurstplusEntityUtil.mc.world.getBlockState(pos.south()).getBlock() == Blocks.OBSIDIAN) {
            if (end_crystal) {
                return pos.south();
            }
            if (WurstplusEntityUtil.mc.world.getBlockState(pos.south().south()).getBlock() == Blocks.AIR) {
                return pos.south();
            }
        }
        if (WurstplusEntityUtil.mc.world.getBlockState(pos.west()).getBlock() == Blocks.OBSIDIAN) {
            if (end_crystal) {
                return pos.west();
            }
            if (WurstplusEntityUtil.mc.world.getBlockState(pos.west().west()).getBlock() == Blocks.AIR) {
                return pos.west();
            }
        }
        return null;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
