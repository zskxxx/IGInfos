package fr.zsk.iginfo;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	private FileConfiguration config;
	private IGInfos pl;
	public Commands(IGInfos igInfos) {
		this.pl = igInfos;
		this.config = pl.getConfig();
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("serverinfos")){
			
			Player p = (Player) sender;
			Server s = Bukkit.getServer();
			String servername = config.getString("server-name");
			p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
			p.sendMessage("§7Voici les informations serveur:");
			p.sendMessage("§7Nom du serveur: §e" + servername);
			p.sendMessage("§7IP: §e"+ s.getIp());
			p.sendMessage("§7MOTD: §e" + s.getMotd());
			p.sendMessage("§7Version: §e" + s.getVersion());
			p.sendMessage("§7Joueurs en ligne: §e" + s.getOnlinePlayers().size() + "/" + s.getMaxPlayers());
			p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
		}
		if(cmd.getName().equalsIgnoreCase("adminsrinfos")){
			String permadmin = config.getString("permission.admin");
			String permall = config.getString("permission.all");
			String servername = config.getString("server-name");
			Player p = (Player) sender;
			Server s = Bukkit.getServer();
			if(p.hasPermission(permadmin) || p.hasPermission(permall)){
				p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
				p.sendMessage("§7Informations serveurs (Admins):");
				p.sendMessage("§7Nom du serveur: §e" + servername);
				p.sendMessage("§7IP: §e"+ s.getIp());
				p.sendMessage("§7MOTD: §e" + s.getMotd());
				p.sendMessage("§7Version: §e" + s.getVersion());
				p.sendMessage("§7Joueurs en ligne: §e" + s.getOnlinePlayers().size() + "/" + s.getMaxPlayers());
				p.sendMessage("§7Version Bukkit: §e" + s.getBukkitVersion());
				p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
			}
		}
		return false;
	}

}
