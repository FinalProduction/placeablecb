package me.final_production.placeablecb.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CommandBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.CommandBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({CommandBlock.class})
public class CommandBlockMixin
{
    @ModifyArg(method = { "<init>" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/BaseEntityBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V"), index = 0)
    private static BlockBehaviour.Properties overrideProperties(final BlockBehaviour.Properties properties) {
        return BlockBehaviour.Properties.of(Material.METAL).strength(5.0f, 2400.0f).noOcclusion();
    }
    /**
     * @author Final_Production
     * @reason This overwrites the existing Command Block code to prevent players from cheating and using the block in survival.
     */
    @Overwrite
    public InteractionResult use(BlockState block, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockentity = world.getBlockEntity(pos);
        if (blockentity instanceof CommandBlockEntity && player.isCreative()) {
            player.openCommandBlock((CommandBlockEntity)blockentity);
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
