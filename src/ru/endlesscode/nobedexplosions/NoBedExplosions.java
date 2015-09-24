package ru.endlesscode.nobedexplosions;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by OsipXD on 16.09.2015
 * It is part of the NoBedExplosions.
 * All rights reserved 2014 - 2015 © «EndlessCode Group»
 */
public class NoBedExplosions extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BedListener(), this);
    }

    private class BedListener implements Listener {
        @EventHandler
        public void onPlayerGoToSleep(PlayerInteractEvent event) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.BED_BLOCK && event.getClickedBlock().getBiome() == Biome.HELL) {
                event.getPlayer().sendMessage("You can't sleep in the HELL!");
                event.setCancelled(true);
            }
        }
    }
}
