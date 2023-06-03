package com.andrei1058.bedwars.xpbar.Events;

import com.andrei1058.bedwars.api.events.player.PlayerJoinArenaEvent;
import com.andrei1058.bedwars.xpbar.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class JoinArenaEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerJoinArenaEvent(final PlayerJoinArenaEvent e) {
        final Player p = e.getPlayer();
        Utils.updateLevel(p);
        Utils.updateExp(p);
    }

}
