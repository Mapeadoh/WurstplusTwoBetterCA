// 
// Decompiled by Procyon v0.5.36
// 

package me.travis.wurstplus.wurstplustwo.event.events;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import me.travis.wurstplus.wurstplustwo.event.WurstplusEventCancellable;

public class WurstplusEventBlock extends WurstplusEventCancellable
{
    public BlockPos pos;
    public EnumFacing facing;
    private int stage;
    
    public WurstplusEventBlock(final int stage, final BlockPos pos, final EnumFacing facing) {
        this.pos = pos;
        this.facing = facing;
        this.stage = stage;
    }
    
    public void set_stage(final int stage) {
        this.stage = stage;
    }
    
    public int get_stage() {
        return this.stage;
    }
}
