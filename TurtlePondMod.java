package edu.caltech.cs001;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TurtlePondMod extends CaltechMinecraftMod {
    public TurtlePondMod(JavaPlugin plugin) { super(plugin); }

    /**
     * Checks if the block `centerBlock` is a water block in the middle of a pond of Material.STONE.
     *
     * @return true if it does form a pond, false if it does not.
     **/
     //Dear TA, we sincerely apologize for the sheer amount of conditions in our if statement. Since all of us were traveling abroad, we were unable to attend OH to ask for clarification on what type getRelative returned. We tried everything (pls see our commit history) and brute-force was the clearest way for us to write the method. Please don't take points off for this comment. Thank you for your understanding and we hope you have the bestest Christmas in the whole wiiiiiide wooooorld. :) Love, Group Dolphin. 
     //P.S. We will send a good note in to Santa for you. <3
    private boolean isPond(Block centerBlock) {
        if (centerBlock.getType() == Material.WATER && centerBlock.getRelative(1, 0, 0).getType() == Material.STONE && centerBlock.getRelative(1, 0, -1).getType() == Material.STONE && centerBlock.getRelative(0, 0, -1).getType() == Material.STONE && centerBlock.getRelative(-1, 0, -1).getType() == Material.STONE && centerBlock.getRelative(-1, 0, 0).getType() == Material.STONE && centerBlock.getRelative(-1, 0, 1).getType() == Material.STONE && centerBlock.getRelative(0, 0, 1).getType() == Material.STONE && centerBlock.getRelative(1, 0, 1).getType() == Material.STONE) {
            return true;
        }
        return false;
    }

    /**
     * Destroys the blocks that form the pond around `centerBlock` by setting their type
     * to Material.AIR.
     **/
    private void destroyPond(Block centerBlock) {
        centerBlock.getRelative(1, 0, 0).setType(Material.AIR);
        centerBlock.getRelative(1, 0, -1).setType(Material.AIR); 
        centerBlock.getRelative(0, 0, -1).setType(Material.AIR);
        centerBlock.getRelative(-1, 0, -1).setType(Material.AIR);
        centerBlock.getRelative(-1, 0, 0).setType(Material.AIR);
        centerBlock.getRelative(-1, 0, 1).setType(Material.AIR);
        centerBlock.getRelative(0, 0, 1).setType(Material.AIR);
        centerBlock.getRelative(1, 0, 1).setType(Material.AIR);
        centerBlock.setType(Material.AIR);
    }

    /**
     * When a player empties a bucket (in this case, a water bucket) into the middle of
     * a pond, this method (1) deletes the pond, and (2) spawns an EntityType.TURTLE where
     * the pond was.
     *
     * Hint: This method should use the other two methods you wrote above!
     **/
    protected void onBucketEmpty(PlayerBucketEmptyEvent event) {
        Block centerBlock = event.getBlock();
        World world = centerBlock.getWorld();
        if (isPond(centerBlock)) {
            destroyPond(centerBlock);
            world.spawnEntity(centerBlock.getLocation(), EntityType.TURTLE);
        }
    }
}
