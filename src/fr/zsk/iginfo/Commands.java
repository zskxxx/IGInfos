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
	
	String permadmin = config.getString("permission.admin");
	String permall = config.getString("permission.all");
	boolean activepermuse = config.getBoolean("active-use-permission");
	String permuse = config.getString("permission.use");
	String servername = config.getString("server-name");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("serverinfos")){
			Player p = (Player) sender;
			Server s = Bukkit.getServer();
			if(args.length == 0){
				p.sendMessage("Voici les informations serveur:");
				p.sendMessage("Nom du serveur: " + servername);
				p.sendMessage("IP: "+ s.getIp());
				p.sendMessage("MOTD: " + s.getMotd());
				p.sendMessage("Version: " + s.getVersion());
				p.sendMessage("Joueurs en ligne: " + s.getOnlinePlayers() + "/" + s.getMaxPlayers());
			}
			if(args.length >= 1){
				if(args[1].equalsIgnoreCase("admin")){
					if(p.hasPermission(permadmin) || p.hasPermission(permall)){
						p.sendMessage("Informations serveurs (Admins):");
						p.sendMessage("Nom du serveur: " + servername);
						p.sendMessage("IP: "+ s.getIp());
						p.sendMessage("MOTD: " + s.getMotd());
						p.sendMessage("Version: " + s.getVersion());
						p.sendMessage("Joueurs en ligne: " + s.getOnlinePlayers() + "/" + s.getMaxPlayers());
						p.sendMessage("Version Bukkit: " + s.getBukkitVersion());
						p.sendMessage("Dossier d'update: " + s.getUpdateFolder());
						p.sendMessage("Server ID: " + s.getServerId());
					}
				}
			}
		}
		return false;
	}

}
