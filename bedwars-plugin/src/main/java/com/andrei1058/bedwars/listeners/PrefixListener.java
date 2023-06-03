package com.andrei1058.bedwars.listeners;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PrefixListener implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String prefix = LuckPermsProvider.get().getUserManager().getUser(player.getName()).getCachedData().getMetaData().getPrefix().substring(0, 2);
        if (prefix == null) {
            player.sendMessage(color("&c出现了一个错误,可能是由于检测前缀字符串结果为无,请反馈至服务器管理员"));
        }
    }

    public static String color(final String color) {
        return color.replace('&', '§');
    }

}
