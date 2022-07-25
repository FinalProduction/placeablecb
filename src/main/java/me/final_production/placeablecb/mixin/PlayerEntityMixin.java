package me.final_production.placeablecb.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }
    @Inject(method = "canUseGameMasterBlocks", at = @At("HEAD"), cancellable = true)
    private void canUseGameMasterBlocks(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.getPermissionLevel() >= 2);
    }
}
