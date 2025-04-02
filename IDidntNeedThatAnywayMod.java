package edu.caltech.cs001;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class IDidntNeedThatAnywayMod extends CaltechMinecraftMod {
    public IDidntNeedThatAnywayMod(JavaPlugin plugin) { super(plugin); }

    protected void onDropItem(PlayerDropItemEvent event) {
        Bukkit.broadcastMessage("I dropped an item!");
        Item item = event.getItemDrop();
        World world = item.getWorld();
        world.spawnEntity(item.getLocation(), EntityType.ARROW);
        item.remove();
        Bukkit.broadcastMessage("Just kidding...!");
    }
}
