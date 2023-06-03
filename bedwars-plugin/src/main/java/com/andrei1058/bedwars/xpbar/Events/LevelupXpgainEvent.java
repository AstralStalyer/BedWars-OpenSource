package com.andrei1058.bedwars.xpbar.Events;

import com.andrei1058.bedwars.xpbar.Utils;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import com.andrei1058.bedwars.api.events.player.*;

public class LevelupXpgainEvent implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void LevelUpEvent(final PlayerLevelUpEvent e) {
        final Player p = e.getPlayer();
        Utils.updateLevel(p);
        Utils.updateExp(p);
        Utils.sendfireworks(p);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void XpGainEvent(final PlayerXpGainEvent e) {
        final Player p = e.getPlayer();
        Utils.updateLevel(p);
        Utils.updateExp(p);
    }
}
