package net.myriantics.yapsesh;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YapSeshClient implements ClientModInitializer {
	public static final String MOD_ID = "yapsesh";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		ClientTickEvents.START_CLIENT_TICK.register(new YapSeshCore());
		LOGGER.info("Initialized YapSesh / I'm Not Done Talking!");
	}
}