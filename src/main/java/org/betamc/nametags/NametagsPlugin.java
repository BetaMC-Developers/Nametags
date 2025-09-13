package org.betamc.nametags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NametagsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[Nametags] Version " + getDescription().getVersion() + " enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[Nametags] Version " + getDescription().getVersion() + " disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("nametags.use")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be run by a player!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            player.setNameTag(player.getName());
            player.sendMessage(ChatColor.YELLOW + "Reset your name tag");
        } else {
            String nameTag = String.join(" ", args);
            player.setNameTag(nameTag);
            player.sendMessage(ChatColor.YELLOW + "Set your name tag to " + ChatColor.WHITE + player.getNameTag());
        }

        return true;
    }

}
