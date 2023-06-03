package com.andrei1058.bedwars.forcestart.event;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Item {

    public static final String FORCESTART = "FORCESTART";
    public static ArrayList<UUID> openGUIs = new ArrayList<>();

    public static void giveItem(Player p, ITeam team) {
        ItemStack i = new ItemStack(Material.DIAMOND);
        ItemMeta im = i.getItemMeta();
        im.setLore(Collections.singletonList(color("&c注意!如果强制开始游戏,本场游戏将处于DEBUG模式,或将导致部分漏洞出现")));
        im.setDisplayName(color("&b强制开始 &7(右键点击)"));
        i.setItemMeta(im);
        i = BedWars.getAPI().getVersionSupport().addCustomData(i, Item.FORCESTART);
        p.getInventory().setItem(0, i);
    }

    public static String color(final String color) {
        return color.replace('&', '§');
    }
}
