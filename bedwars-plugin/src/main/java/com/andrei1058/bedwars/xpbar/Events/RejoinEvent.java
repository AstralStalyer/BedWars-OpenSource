package com.andrei1058.bedwars.xpbar.Events;

import com.andrei1058.bedwars.api.events.player.*;
import com.andrei1058.bedwars.xpbar.Utils;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class RejoinEvent implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerRejoinEvent(final PlayerReJoinEvent e) {
        final Player p = e.getPlayer();
        Utils.updateLevel(p);
        Utils.updateExp(p);
    }
}
