package fr.zsk.iginfo;

import org.bukkit.plugin.java.JavaPlugin;

public class IGInfos extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		
		this.getCommand("serverinfos").setExecutor(new Commands(this));
		this.getCommand("adminsrinfos").setExecutor(new Commands(this));
		this.getCommand("playerinfos").setExecutor(new Commands(this));
		//Bukkit.getPluginManager().registerEvents(new EventsListener(), this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		
		super.onDisable();
	}
	
}
