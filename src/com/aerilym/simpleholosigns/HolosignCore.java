package com.aerilym.simpleholosigns;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HolosignCore extends JavaPlugin implements Listener{
	FileConfiguration config = this.getConfig();
	
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
        config.addDefault("JoinMessageTutorial", true);
        config.addDefault("MaxSignDeleteRangeBeforeWarning", 5);
        config.options().copyDefaults(true);
        saveConfig();
    	
    	this.getCommand("holosign").setExecutor(new CommandHolosign());
    	this.getCommand("holosign").setTabCompleter(new HolosignTab());
    	
    	getServer().getPluginManager().registerEvents(this, this);
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    	
        Player player = event.getPlayer();

        if (config.getBoolean("JoinMessageTutorial")) {
            player.sendMessage("To create an armor stand holosign start by typing /holosign. You can disable this message in the config");
        }
    }

}
