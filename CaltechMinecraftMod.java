package edu.caltech.cs001;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CaltechMinecraftMod implements Listener {
    private final JavaPlugin plugin;

    public CaltechMinecraftMod(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    protected void onDropItem(PlayerDropItemEvent event) {}
    protected void onBucketEmpty(PlayerBucketEmptyEvent event) {}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setOp(true);
    }

    @EventHandler  // tagging with @EventHandler will make Minecraft listen to this method
    public void onDropItemSynced(PlayerDropItemEvent event) {
        // We are just making sure all the code in onDropItem() happens at the same time.
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> this.onDropItem(event), 1);
    }


        
    @EventHandler  // tagging with @EventHandler will make Minecraft listen to this method
    public void onBucketEmptySynced(PlayerBucketEmptyEvent event) {
        // We are just making sure all the code in onBucketEmpty() happens at the same time.
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> this.onBucketEmpty(event), 1);
    }
}
