package com.andrei1058.bedwars.tower;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.team.TeamColor;
import com.andrei1058.bedwars.tower.positions.TowerEast;
import com.andrei1058.bedwars.tower.positions.TowerNorth;
import com.andrei1058.bedwars.tower.positions.TowerSouth;
import com.andrei1058.bedwars.tower.positions.TowerWest;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ChestPlace implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlace(final BlockPlaceEvent e) {
        final Player player = e.getPlayer();
        if (e.getBlockPlaced().getType() == Material.CHEST && BedWars.getAPI().getArenaUtil().isPlaying(player) && !e.isCancelled()) {
            e.setCancelled(true);
            final Location loc = e.getBlockPlaced().getLocation();
            final Block chest = e.getBlockPlaced();
            final TeamColor col = BedWars.getAPI().getArenaUtil().getArenaByPlayer(player).getTeam(player).getColor();
            double rotation = (player.getLocation().getYaw() - 90.0f) % 360.0f;
            if (rotation < 0.0) {
                rotation += 360.0;
            }
            if (45.0 <= rotation && rotation < 135.0) {
                new TowerSouth(loc, chest, col, player);
            }
            else if (225.0 <= rotation && rotation < 315.0) {
                new TowerNorth(loc, chest, col, player);
            }
            else if (135.0 <= rotation && rotation < 225.0) {
                new TowerWest(loc, chest, col, player);
            }
            else if (0.0 <= rotation && rotation < 45.0) {
                new TowerEast(loc, chest, col, player);
            }
            else if (315.0 <= rotation && rotation < 360.0) {
                new TowerEast(loc, chest, col, player);
            }
        }
    }
}

