package me.final_production.placeablecb.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import me.final_production.placeablecb.PlaceablecbCommonConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.GameMasterBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(GameMasterBlockItem.class)
public class GameMasterBlockItemMixin extends BlockItem{

	public GameMasterBlockItemMixin(Block p_40565_, Properties p_40566_) {
		super(p_40565_, p_40566_);
	}

	@Overwrite
	protected BlockState getPlacementState(BlockPlaceContext p_41321_) {
		BlockState state = super.getPlacementState(p_41321_);
		Player player = p_41321_.getPlayer();
		return player != null && 
				!(isInRightDimension(player) ||
				player.isCreative())
				? null : state;
	}
	
	private boolean isInRightDimension(Player player) {
		System.out.println(PlaceablecbCommonConfig.DIMIDS.get());
		System.out.println(player.getLevel().dimension().location().toString());
		boolean contains = PlaceablecbCommonConfig.DIMIDS.get().contains(player.getLevel().dimension().location().toString());
		if(!PlaceablecbCommonConfig.WHITELIST.get()) {
			contains = !contains;
		}
		return contains;
	}
}
