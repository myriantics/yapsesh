package net.myriantics.yapsesh;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;

public class YapSeshCore implements ClientTickEvents.StartTick{
    private static long ticksSinceLastChatScreenKeyPress;

    public static final int chatScreenKeepaliveWindowTicks = 20;

    @Override
    public void onStartTick(MinecraftClient client) {
        // only increment this if a chat screen is open
        if (client.currentScreen instanceof ChatScreen) {
            ticksSinceLastChatScreenKeyPress++;
        } else if (ticksSinceLastChatScreenKeyPress != 0) {
            resetTicksSinceLastKeyPress();
        }
    }

    public static void resetTicksSinceLastKeyPress() {
        ticksSinceLastChatScreenKeyPress = 0;
    }

    public static long getTicksSinceLastChatScreenKeyPress() {
        return ticksSinceLastChatScreenKeyPress;
    }

    public static boolean canServerCloseChatWindow() {
        return ticksSinceLastChatScreenKeyPress > chatScreenKeepaliveWindowTicks;
    }
}
