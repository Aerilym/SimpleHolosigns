package com.aerilym.simpleholosigns;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class CommandHolosign implements CommandExecutor{

    // This method is called, when somebody uses our command
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            
            if (args.length == 0) {
            	player.sendMessage(ChatColor.GOLD + "Simple Holosigns is created by Aerilym - For help & support go to " + ChatColor.AQUA + ChatColor.UNDERLINE + "https://github.com/Aerilym/SimpleHolosigns");
                player.sendMessage(ChatColor.AQUA + "/holosign" + ChatColor.GOLD + " - Get commands and information. Alias: " + ChatColor.AQUA + "/hs /hsign /hologram /holo");
                player.sendMessage(ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " create <color> " + ChatColor.GRAY + "[f1] [f2] [f3] [f4]" + ChatColor.AQUA + " <text>" + ChatColor.GOLD + " - Creates a holosign at your location with the text provided, color, and formatting (optional: bold, italic etc.)");
                player.sendMessage(ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " delete " + ChatColor.GRAY + "[range]" + ChatColor.GOLD + " - Deletes holosigns (armor stands) in a radius around you (default 2)");
                return true;
            } else {
            	if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("c")) {
            		if (args.length < 2) {
            			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " create <color> " + ChatColor.GRAY + "[f1] [f2] [f3] [f4]" + ChatColor.AQUA + " <text>" + ChatColor.GOLD + " - Creates a holosign at your location with the text provided, color, and formatting (optional: bold, italic etc.)");
            			return true;
            		}
            		String color = args[1].toLowerCase();
            		args[0] = "";
            		args[1] = "";
            		String boldstate = "";
            		String italicstate = "";
            		String obfuscatedstate = "";
            		String strikestate = "";
            		
            		String boldstatetrue = ",`bold`:`true`".replace('`', '"');
            		String italicstatetrue = ",`italic`:`true`".replace('`', '"');
            		String obfuscatedstatetrue = ",`obfuscated`:`true`".replace('`', '"');
            		String strikestatetrue = ",`strikethrough`:`true`".replace('`', '"');
            		
            		int formatchecklength = Integer.min(5, args.length);
            		for (int i = 2; i < formatchecklength; i++) {
                		if (args[i].equalsIgnoreCase("bold")) {
                			boldstate = boldstatetrue;
                			args[i] = "";
                		} else if (args[i].equalsIgnoreCase("italic")) {
                			italicstate = italicstatetrue;
                			args[i] = "";
                		} else if (args[i].equalsIgnoreCase("obfuscated")) {
                			obfuscatedstate = obfuscatedstatetrue;
                			args[i] = "";
                		} else if (args[i].equalsIgnoreCase("strikethrough")) {
                			strikestate = strikestatetrue;
                			args[i] = "";
                		}
            		}
            		
            		String content = String.join(" ", args);
            		String filteredcontent = content.replace("      ", "");
            		filteredcontent = filteredcontent.replace("     ", "");
            		filteredcontent = filteredcontent.replace("    ", "");
            		filteredcontent = filteredcontent.replace("   ", "");
            		filteredcontent = filteredcontent.replace("  ", "");
            		Bukkit.dispatchCommand(sender, "summon armor_stand ~ ~ ~ {Invisible:1b,Invulnerable:1b,PersistenceRequired:1b,NoGravity:1b,Marker:1b,CustomName:'{`text`:`".replace('`', '"') + filteredcontent + "`,`color`:`".replace('`', '"')+ color +"`".replace('`', '"') + boldstate + italicstate + obfuscatedstate + strikestate + "}',CustomNameVisible:1b}".replace('`', '"'));
            		player.sendMessage("You made a sign");
            		return true;
            	}
            	if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("d") || args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("r")) {
            		
            		if (args.length < 2) {
            			player.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " delete " + ChatColor.GRAY + "[range]" + ChatColor.GOLD + " - Deletes holosigns (armor stands) in a radius around you (default 2)");
            			return true;
            		}
            		
            		int range = 1;
            		         		
            		int max_range = 5;
            		
            		if (args.length > 1) {
            			range = Integer.parseInt(args[1]);
            		}
            		
            		if (range > 5) {
            			if (args.length > 2) {
            				if (args[2].equalsIgnoreCase("confirm")) {
                        		Bukkit.dispatchCommand(sender,"minecraft:kill @e[type=armor_stand,distance=.."+ range +"]");
                        		return true;
            				} else {
            					return false;
            				}
            			} else {
            			player.sendMessage(ChatColor.RED + "You attempted to remove signs (armor stands) in a radius of " + ChatColor.AQUA + range + ChatColor.RED + " blocks. To use this command with a range greater than " + ChatColor.AQUA + max_range + ChatColor.RED + " add "+ ChatColor.AQUA + "confirm" + ChatColor.RED + "to the end of the command or change the max range in the config.");
            			player.sendMessage(ChatColor.RED + "eg. " + ChatColor.AQUA + "/holosign delete " + range + " confirm");
            			return true;
            			}
            		} else {
                		Bukkit.dispatchCommand(sender,"minecraft:kill @e[type=armor_stand,distance=.."+ range +"]");
                		return true;
            		}
        
            	}
            	if (args[0].equalsIgnoreCase("nearby")) {
            		player.sendMessage("sign nearby is ...");
            		return true;
            	}
            }
            
        }
		return false;
    }
}
