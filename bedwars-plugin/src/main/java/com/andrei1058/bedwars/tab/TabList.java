package com.andrei1058.bedwars.tab;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.configuration.ConfigPath;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TabList extends TabListAPI implements Listener {

    @EventHandler
    public void TABChangeEvent(final PlayerMoveEvent event) {
        Player player = event.getPlayer();
        IArena arena = Arena.getArenaByPlayer(player);
        if (arena != null) {
            if (arena.getStatus().equals(GameState.waiting) || arena.getStatus().equals(GameState.starting)) {
                try {
                    final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                    final String footer = color("\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                    TabListAPI.sendTablist(player, header, footer);
                } catch (Exception var9) {
                    var9.printStackTrace();
                }
            }
            if (arena.getStatus().equals(GameState.playing)) {
                if (arena.isSpectator(player)) {
                    try {
                        final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                        final String footer = color("\n&f你被遗留在了一片虚无中\n\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                        TabListAPI.sendTablist(player, header, footer);
                    } catch (Exception var9) {
                        var9.printStackTrace();
                    }
                } else {
                    try {
                        final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                        final String footer = color("\n&f击杀数 &a" + arena.getPlayerKills(player, false) + "  &f最终击杀 &a" + arena.getPlayerKills(player, true) + "  &f破坏床数 &a" + arena.getPlayerBedsDestroyed(player) + "\n\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                        TabListAPI.sendTablist(player, header, footer);
                    } catch (Exception var9) {
                        var9.printStackTrace();
                    }
                }
            }
        }
    }

    @EventHandler
    public void TABJoinEvent(final PlayerJoinArenaEvent event) {
        Player player = event.getPlayer();
        IArena arena = event.getArena();
        if (Bukkit.getServer().getName().equals("ShowCase")) {
            if (arena.getStatus().equals(GameState.waiting) || arena.getStatus().equals(GameState.starting)) {
                    try {
                        final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                        final String footer = color("\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                        TabListAPI.sendTablist(player, header, footer);
                    } catch (Exception var9) {
                        var9.printStackTrace();
                    }
            }
            if (arena.getStatus().equals(GameState.playing)) {
                if (arena.isSpectator(player)) {
                        try {
                            final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                            final String footer = color("\n&f你被遗留在了一片虚无中\n\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                            TabListAPI.sendTablist(player, header, footer);
                        } catch (Exception var9) {
                            var9.printStackTrace();
                        }
                } else {
                        try {
                             final String header = color((BedWars.config.getBoolean(ConfigPath.SHOWCASE_MODE) ? "\n&bStardust &8@ &f2023 &f| &cShowCase\n&7正在游玩 起床战争\n" : "\n&bStardust &8@ &f2023\n&7正在游玩 起床战争\n"));
                            final String footer = color("\n&f击杀数 &a" + arena.getPlayerKills(player, false) + "  &f最终击杀 &a" + arena.getPlayerKills(player, true) + "  &f破坏床数 &a" + arena.getPlayerBedsDestroyed(player) + "\n\n &7群号 &f1090558569 &7地址 &fStellarmc.cn \n&f&m                                          ");
                            TabListAPI.sendTablist(player, header, footer);
                        } catch (Exception var9) {
                            var9.printStackTrace();
                        }
                }
            }
        }
    }



    public static String color(final String color) {
        return color.replace('&', '§');
    }

}
