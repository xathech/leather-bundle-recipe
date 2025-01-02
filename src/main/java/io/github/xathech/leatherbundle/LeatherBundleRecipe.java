package io.github.xathech.leatherbundle;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class LeatherBundleRecipe implements ModInitializer {
	public static final String MOD_ID = "leather-bundle-recipe";

	@Override
	public void onInitialize() {

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		addToItemGroup();
	}

	private static void addToItemGroup() {

		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
				.register((itemGroup) -> itemGroup.add(Items.BUNDLE));
	}
}