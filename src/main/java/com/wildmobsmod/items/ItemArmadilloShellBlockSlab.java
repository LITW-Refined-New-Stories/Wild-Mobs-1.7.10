package com.wildmobsmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import com.wildmobsmod.blocks.WildMobsModBlocks;

public class ItemArmadilloShellBlockSlab extends ItemSlab {

    public ItemArmadilloShellBlockSlab(Block block) {
        super(
            block,
            WildMobsModBlocks.armadilloShellBlockSlabSingle,
            WildMobsModBlocks.armadilloShellBlockSlabDouble,
            false);
    }
}
