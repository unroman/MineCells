package com.github.mim1q.minecells.item;

import com.github.mim1q.minecells.registry.SoundRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class AssassinsDaggerItem extends ToolItem {
    public AssassinsDaggerItem(Settings settings) {
        super(ToolMaterials.IRON, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.damage(DamageSource.mob(attacker), this.getDamage());
        float difference = MathHelper.angleBetween(target.bodyYaw, attacker.getHeadYaw());
        if (difference < 60.0F) {
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundRegistry.CRIT, SoundCategory.PLAYERS, 0.5F, 1.0F);
            target.damage(DamageSource.mob(attacker), this.getDamage());
        }
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        stack.damage(2, miner, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public float getDamage() {
        return 5.0F;
    }
}