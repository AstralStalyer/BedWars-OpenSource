package com.andrei1058.bedwars.forcestart.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.forcestart.event.Item;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    @EventHandler
    //Prevent inventory move
    public void onInventoryClick(InventoryClickEvent e) {
        ItemStack i = e.getCurrentItem();
        if (i == null) return;
        if (i.getType() == Material.AIR) return;
        if (Item.openGUIs.contains(e.getWhoClicked().getUniqueId())) e.setCancelled(true);
        if (!BedWars.getAPI().getVersionSupport().isCustomBedWarsItem(i)) return;
        String identifier = BedWars.getAPI().getVersionSupport().getCustomData(i);
    }
}
