package com.andrei1058.bedwars.xpbar.Events;

import com.andrei1058.bedwars.api.events.player.*;
import com.andrei1058.bedwars.xpbar.Utils;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class KillDeathEvent implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerKillDeathEvent(final PlayerKillEvent e) {
        final Player killer = e.getKiller();
        final Player victim = e.getVictim();
        Utils.updateLevel(killer);
        Utils.updateLevel(victim);
    }
}
