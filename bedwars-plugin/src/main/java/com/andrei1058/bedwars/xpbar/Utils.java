package com.andrei1058.bedwars.xpbar;

import com.andrei1058.bedwars.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Utils {
    public static void updateLevel(final Player p) {
        if (p != null) {
            if (BedWars.specialmode = false) {
                Bukkit.getScheduler().runTaskLater(BedWars.plugin, () -> {
                    p.setLevel(0);
                    p.setLevel(BedWars.getLevelSupport().getPlayerLevel(p));
                }, 10L);
            } else {
                Bukkit.getScheduler().runTaskLater(BedWars.plugin, () -> {
                    p.setLevel(0);
                }, 10L);
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Event's player is null,Please Support for Starry_Killer");
        }
    }

    public static void updateExp(final Player p) {
        if (p != null) {
            if (BedWars.specialmode = false) {
                Bukkit.getScheduler().runTaskLater(BedWars.plugin, () -> {
                    if (BedWars.getLevelSupport().getCurrentXp(p) > BedWars.getLevelSupport().getRequiredXp(p)) {
                        p.setExp(0.0f);
                    } else {
                        p.setExp(0.0f);
                        p.setExp(BedWars.getLevelSupport().getCurrentXp(p) / (float) BedWars.getLevelSupport().getRequiredXp(p));
                    }
                }, 10L);
            } else {
                Bukkit.getScheduler().runTaskLater(BedWars.plugin, () -> {
                    if (BedWars.getLevelSupport().getCurrentXp(p) > BedWars.getLevelSupport().getRequiredXp(p)) {
                        p.setExp(0.0f);
                    } else {
                        p.setExp(0.0f);
                    }
                }, 10L);
            }
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Event's player is null,Please Support for Starry_Killer");
        }
    }

    public static void sendfireworks(final Player p) {
        final Firework firework = (Firework)p.getWorld().spawn(p.getLocation(), (Class)Firework.class);
        final FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.WHITE).build());
        meta.setPower(1);
        firework.setFireworkMeta(meta);
        p.getWorld().playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5.0f, 0.5f);
    }
}
