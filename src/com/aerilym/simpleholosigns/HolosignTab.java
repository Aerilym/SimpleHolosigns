package com.aerilym.simpleholosigns;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class HolosignTab implements TabCompleter {
	
	List<String> arguments = new ArrayList<String>();
	
	List<String> arguments2 = new ArrayList<String>();
	
	List<String> arguments3 = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
		
		if (arguments.isEmpty()) {
			arguments.add("create");
			arguments.add("delete");
			arguments.add("remove");
			arguments.add("c");
			arguments.add("d");
			arguments.add("r");
		}
		
		if (arguments2.isEmpty()) {
			arguments2.add("black");
			arguments2.add("dark_blue");
			arguments2.add("dark_green");
			arguments2.add("dark_aqua");
			arguments2.add("dark_red");
			arguments2.add("dark_purple");
			arguments2.add("gold");
			arguments2.add("gray");
			arguments2.add("dark_gray");
			arguments2.add("blue");
			arguments2.add("aqua");
			arguments2.add("red");
			arguments2.add("light_purple");
			arguments2.add("yellow");
			arguments2.add("white");			
		}
		
		if (arguments3.isEmpty()) {
			arguments3.add("bold");
			arguments3.add("italic");
			arguments3.add("obfuscated");
			arguments3.add("strikethrough");
		}
		
		List<String> result = new ArrayList<String>();
		if (args.length == 1) {
			for (String a : arguments) {
				if (a.toLowerCase().startsWith(args[0].toLowerCase()))
					result.add(a);
			}
			return result;
		} else if (args.length == 2) {
			for (String a2 : arguments2) {
				if (a2.toLowerCase().startsWith(args[1].toLowerCase()))
					result.add(a2);
			}
			return result;
		} else if (args.length == 3) {
			for (String a3 : arguments3) {
				if (a3.toLowerCase().startsWith(args[2].toLowerCase()))
					result.add(a3);
			}
			return result;
		} else if (args.length == 4) {
			for (String a3 : arguments3) {
				if (a3.toLowerCase().startsWith(args[3].toLowerCase()))
					result.add(a3);
			}
			return result;
		} else if (args.length == 5) {
			for (String a3 : arguments3) {
				if (a3.toLowerCase().startsWith(args[4].toLowerCase()))
					result.add(a3);
			}
			return result;
		} else if (args.length == 6) {
			for (String a3 : arguments3) {
				if (a3.toLowerCase().startsWith(args[5].toLowerCase()))
					result.add(a3);
			}
			return result;
		}
		
		return null;
	}
}
