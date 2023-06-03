package com.andrei1058.bedwars.forcestart.listeners;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.forcestart.event.Item;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public boolean onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        IArena a = Arena.getArenaByPlayer(p);
        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) return false;
        ItemStack i = BedWars.getAPI().getVersionSupport().getItemInHand(e.getPlayer());
        if (i == null) return false;
        if (i.getType() == Material.AIR) return false;
        if (!BedWars.getAPI().getVersionSupport().isCustomBedWarsItem(i)) return false;
        if (BedWars.getAPI().getVersionSupport().getCustomData(i).equals(Item.FORCESTART)) {
            if (p.hasPermission("bw.forcestart")) {
                e.setCancelled(true);
                a.changeStatus(GameState.starting);
                if (a.getStartingTask().getCountdown() < 5) return true;
                a.getStartingTask().setCountdown(0);
                p.sendMessage(color("&c强制开始游戏成功!"));
                return true;
            }
            else {
                p.sendMessage(color("&c你没有权限来强制开始一场游戏!"));
            }
        }
        return false;
    }

    public static String color(final String color) {
        return color.replace('&', '§');
    }

}