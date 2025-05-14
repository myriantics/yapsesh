package net.myriantics.yapsesh.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import net.myriantics.yapsesh.YapSeshClient;
import net.myriantics.yapsesh.YapSeshCore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Inject(
            method = "keyPressed",
            at = @At(value = "RETURN", ordinal = 8)
    )
    public void yapsesh$resetTicksSinceLastKeyPressHook(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        YapSeshCore.resetTicksSinceLastKeyPress();
    }
}