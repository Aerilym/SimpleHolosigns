package com.aerilym.simpleholosigns;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class CommandHolosign implements CommandExecutor {

    // This method is called, when somebody uses our command
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            
            if (args.length == 0) {
                player.sendMessage(ChatColor.AQUA + "/holosign" + ChatColor.GOLD + " - Get commands and information. Alias: " + ChatColor.AQUA + "/hs /hsign /hologram /holo");
                player.sendMessage(ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " create <color> " + ChatColor.GRAY + "[f1] [f2] [f3] [f4]" + ChatColor.AQUA + " <text>" + ChatColor.GOLD + " - Creates a holosign at your location with the text provided, color, and formatting (optional: bold, italic etc.)");
                player.sendMessage(ChatColor.WHITE + "/holosign" + ChatColor.AQUA + " delete " + ChatColor.GRAY + "[range]" + ChatColor.GOLD + " - Deletes holosigns (armor stands) in a radius around you (default 2)");
                return true;
            } else {
            	if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("c")) {
            		String color = args[1].toLowerCase();
            		args[0] = "";
            		args[1] = "";
            		String boldstate = "";
            		String italicstate = "";
            		String obfuscatedstate = "";
            		String strikestate = "";
            		
            		if (args[2].equalsIgnoreCase("bold")) {
            			boldstate = ",`bold`:`true`".replace('`', '"');
            			args[2] = "";
            		} else if (args[2].equalsIgnoreCase("italic")) {
            			italicstate = ",`italic`:`true`".replace('`', '"');
            			args[2] = "";
            		} else if (args[2].equalsIgnoreCase("obfuscated")) {
            			obfuscatedstate = ",`obfuscated`:`true`".replace('`', '"');
            			args[2] = "";
            		} else if (args[2].equalsIgnoreCase("strikethrough")) {
            			strikestate = ",`strikethrough`:`true`".replace('`', '"');
            			args[2] = "";
            		}
            		
            		if (args.length > 3) {
                		if (args[3].equalsIgnoreCase("bold")) {
                			boldstate = ",`bold`:`true`".replace('`', '"');
                			args[3] = "";
                		} else if (args[3].equalsIgnoreCase("italic")) {
                			italicstate = ",`italic`:`true`".replace('`', '"');
                			args[3] = "";
                		} else if (args[3].equalsIgnoreCase("obfuscated")) {
                			obfuscatedstate = ",`obfuscated`:`true`".replace('`', '"');
                			args[3] = "";
                		} else if (args[3].equalsIgnoreCase("strikethrough")) {
                			strikestate = ",`strikethrough`:`true`".replace('`', '"');
                			args[3] = "";
                		}
            		}
            		
            		if (args.length > 4) {
                		if (args[4].equalsIgnoreCase("bold")) {
                			boldstate = ",`bold`:`true`".replace('`', '"');
                			args[4] = "";
                		} else if (args[4].equalsIgnoreCase("italic")) {
                			italicstate = ",`italic`:`true`".replace('`', '"');
                			args[4] = "";
                		} else if (args[4].equalsIgnoreCase("obfuscated")) {
                			obfuscatedstate = ",`obfuscated`:`true`".replace('`', '"');
                			args[4] = "";
                		} else if (args[4].equalsIgnoreCase("strikethrough")) {
                			strikestate = ",`strikethrough`:`true`".replace('`', '"');
                			args[4] = "";
                		}
            		}
            		
            		if (args.length > 5) {
                		if (args[5].equalsIgnoreCase("bold")) {
                			boldstate = ",`bold`:`true`".replace('`', '"');
                			args[5] = "";
                		} else if (args[5].equalsIgnoreCase("italic")) {
                			italicstate = ",`italic`:`true`".replace('`', '"');
                			args[5] = "";
                		} else if (args[5].equalsIgnoreCase("obfuscated")) {
                			obfuscatedstate = ",`obfuscated`:`true`".replace('`', '"');
                			args[5] = "";
                		} else if (args[5].equalsIgnoreCase("strikethrough")) {
                			strikestate = ",`strikethrough`:`true`".replace('`', '"');
                			args[5] = "";
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
            		int range = Integer.parseInt("1");
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
