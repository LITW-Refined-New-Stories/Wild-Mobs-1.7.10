package com.wildmobsmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBugNet extends ItemWM {

    public ItemBugNet() {
        this.setMaxStackSize(1);
        this.setMaxDamage(59);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
}
