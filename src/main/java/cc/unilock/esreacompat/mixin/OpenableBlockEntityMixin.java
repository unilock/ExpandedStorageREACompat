package cc.unilock.esreacompat.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import compasses.expandedstorage.impl.block.entity.extendable.OpenableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(OpenableBlockEntity.class)
public class OpenableBlockEntityMixin {
	@ModifyConstant(method = "isValidAndPlayerInRange", constant = @Constant(doubleValue = 36.0D))
	private double init(double reachDistance, PlayerEntity player) {
		return ReachEntityAttributes.getSquaredReachDistance(player, reachDistance);
	}
}
