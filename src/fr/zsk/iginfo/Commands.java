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
			String permadmin = config.getString("permission.admin");
			String permall = config.getString("permission.all");
			String servername = config.getString("server-name");
			String permuse = config.getString("permission.use");
			boolean activeuse = config.getBoolean("active-perm-use-server");
			if(activeuse = true){
				if(p.hasPermission(permuse) || p.hasPermission(permadmin) || p.hasPermission(permall)){
					p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
					p.sendMessage("§7Voici les informations serveur:");
					p.sendMessage("§7Nom du serveur: §e" + servername);
					p.sendMessage("§7IP: §e"+ s.getIp());
					p.sendMessage("§7MOTD: §e" + s.getMotd());
					p.sendMessage("§7Version: §e" + s.getVersion());
					p.sendMessage("§7Joueurs en ligne: §e" + s.getOnlinePlayers().size() + "/" + s.getMaxPlayers());
					p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("adminsrinfos")){
			boolean activeuse = config.getBoolean("active-infos-server");
			if(activeuse = true){
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
		}
		if(cmd.getName().equalsIgnoreCase("playerinfos")){
			boolean activeuse = config.getBoolean("active-infos-player");
			String permadmin = config.getString("permission.admin");
			String permall = config.getString("permission.all");
			String permuse = config.getString("permission.usp");
			
			Player p = (Player) sender;
			Player targetPlayer = Bukkit.getPlayer(args[1]);
			if(activeuse = true){
				if(p.hasPermission(permuse) || p.hasPermission(permadmin) || p.hasPermission(permall)){
					if(targetPlayer.isOnline()){
						p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
						p.sendMessage("§7Informations sur le joueur: §e"+ targetPlayer.getName());
						p.sendMessage("§7En ligne depuis: §e" + targetPlayer.getPlayerTime());
						p.sendMessage("§7Vie: §e" + targetPlayer.getHealth());
						p.sendMessage("§7Level: §e" + targetPlayer.getLevel());
						p.sendMessage("§7XP restant avant de levelup: §e" + targetPlayer.getExp() +"§7/§e"+ targetPlayer.getExpToLevel());
						p.sendMessage("§l§m§e+----------§7----------§e----------§7----------§e+");
					}else{
						p.sendMessage("§cLe joueur "+ args[1].toString() +" n'est pas en ligne !");
					}
				}
			}
		}
		return false;
	}

}
