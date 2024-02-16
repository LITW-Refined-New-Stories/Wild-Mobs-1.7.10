package com.wildmobsmod.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

import com.wildmobsmod.entity.monster.seascorpion.EntitySeaScorpion;

public class ItemSeaScorpionBucket extends ItemWM {

    public ItemSeaScorpionBucket() {
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, true);
        if (mop.typeOfHit == MovingObjectType.BLOCK) {
            Block block = world.getBlock(mop.blockX, mop.blockY, mop.blockZ);
            if (block.getMaterial() == Material.water && block instanceof BlockLiquid) {
                if (!world.isRemote) {
                    EntitySeaScorpion entityliving = new EntitySeaScorpion(world);
                    entityliving.setLocationAndAngles(
                        (double) mop.blockX + 0.5D,
                        mop.blockY,
                        mop.blockZ + 0.5D,
                        MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F),
                        0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((IEntityLivingData) null);
                    entityliving.setIsWild(false);
                    entityliving.setIsSeaMonster(false);
                    switch (stack.getItemDamage()) {
                        case 1:
                            entityliving.setSize(0);
                            break;
                        case 2:
                            entityliving.setGrowingAge(-24000);
                            entityliving.setSize(0);
                            break;
                        case 3:
                            entityliving.setGrowingAge(-24000);
                            entityliving.setSize(1);
                            break;
                        default:
                            entityliving.setGrowingAge(-24000);
                            entityliving.setSize(2);
                            break;
                    }
                    if (stack.hasDisplayName()) {
                        entityliving.setCustomNameTag(stack.getDisplayName());
                    }
                    world.spawnEntityInWorld(entityliving);
                }
                return new ItemStack(Items.water_bucket);
            }
        }
        return stack;
    }
}
