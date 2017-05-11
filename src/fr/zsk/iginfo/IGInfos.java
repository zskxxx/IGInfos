package fr.zsk.iginfo;

import org.bukkit.plugin.java.JavaPlugin;

public class IGInfos extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getCommand("serverinfos").setExecutor(new Commands(this));
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		
		
		super.onDisable();
	}
	
}
