package com.andrei1058.bedwars.tab;

import org.bukkit.event.*;
import org.bukkit.entity.*;

public class TabSendEvent extends Event
{
    private static final HandlerList handlers;
    private final Player player;
    private String header;
    private boolean cancelled;

    static {
        handlers = new HandlerList();
    }

    public TabSendEvent(final Player player, final String header) {
        this.cancelled = false;
        this.player = player;
        this.header = header;
    }

    public HandlerList getHandlers() {
        return TabSendEvent.handlers;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(final String header) {
        this.header = header;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
}
