package dev.rvbsm.reanviled.mixin;

import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin {

	@Inject(method = "getNextCost", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
	private static void getNextCost(int cost, CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(Math.round(cost * 1.5f + 1));
	}

	@ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40, ordinal = 2))
	private int updateResult$levelCap(int levelCap) {
		return Integer.MAX_VALUE;
	}
}
