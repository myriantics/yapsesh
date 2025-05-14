package net.myriantics.yapsesh.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import net.myriantics.yapsesh.YapSeshClient;
import net.myriantics.yapsesh.YapSeshCore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CloseScreenS2CPacket.class)
public class CloseScreenS2CPacketMixin {
	@Inject(
			method = "apply(Lnet/minecraft/network/listener/ClientPlayPacketListener;)V",
			at = @At("HEAD"),
			cancellable = true)
	private void yapSesh$closeHandledScreenOverride(CallbackInfo info) {
		Screen screen = MinecraftClient.getInstance().currentScreen;

		if (screen instanceof ChatScreen && !YapSeshCore.canServerCloseChatWindow()) {
			YapSeshClient.LOGGER.info("Blocked server from attempting to close chat window. Happy typing!");
			info.cancel();
		}
	}
}