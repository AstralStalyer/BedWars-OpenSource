package com.andrei1058.bedwars.tower;

import org.bukkit.block.*;
import com.andrei1058.bedwars.api.arena.team.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import com.andrei1058.bedwars.*;
import com.andrei1058.bedwars.api.region.*;
import java.util.*;

public class PlaceBlock
{
    public PlaceBlock(final Block b, final String xyz, final TeamColor color, final Player p, final boolean ladder, final int ladderdata) {
        final int x = Integer.parseInt(xyz.split(", ")[0]);
        final int y = Integer.parseInt(xyz.split(", ")[1]);
        final int z = Integer.parseInt(xyz.split(", ")[2]);
        if (b.getRelative(x, y, z).getType().equals((Object)Material.AIR)) {
            for (final Region r : BedWars.getAPI().getArenaUtil().getArenaByPlayer(p).getRegionsList()) {
                if (r.isInRegion(b.getRelative(x, y, z).getLocation())) {
                    return;
                }
            }
            if (!ladder) {
                if (BedWars.getAPI().getVersionSupport().getVersion() >= 7) {
                    b.getRelative(x, y, z).setType(color.woolMaterial());
                    BedWars.getAPI().getArenaUtil().getArenaByPlayer(p).addPlacedBlock(b.getRelative(x, y, z));
                }
                else {
                    b.getRelative(x, y, z).setType(Material.WOOL);
                    BedWars.getAPI().getVersionSupport().setBlockTeamColor(b.getRelative(x, y, z), color);
                    BedWars.getAPI().getArenaUtil().getArenaByPlayer(p).addPlacedBlock(b.getRelative(x, y, z));
                }
            }
            else {
                b.getRelative(x, y, z).setType(Material.LADDER);
                b.getRelative(x, y, z).setData((byte)ladderdata);
                BedWars.getAPI().getArenaUtil().getArenaByPlayer(p).addPlacedBlock(b.getRelative(x, y, z));
            }
        }
    }
}
