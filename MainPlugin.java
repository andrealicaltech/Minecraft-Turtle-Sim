package edu.caltech.cs001;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class MainPlugin extends JavaPlugin {
    private PluginManager manager;

    public MainPlugin() {
        super();
        this.manager = Bukkit.getServer().getPluginManager();
    }

    @Override
    public void onEnable() {
        this.manager.registerEvents(new TurtlePondMod(this), this);
    }
}
