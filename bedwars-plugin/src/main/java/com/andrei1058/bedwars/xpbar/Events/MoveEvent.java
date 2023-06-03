package com.andrei1058.bedwars.xpbar.Events;

import com.andrei1058.bedwars.xpbar.Utils;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class MoveEvent implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerMoveEvent(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        Utils.updateLevel(p);
        Utils.updateExp(p);
    }
}
