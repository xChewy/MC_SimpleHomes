package me.xchewy.simplehomes;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public final class SimpleHomes extends JavaPlugin {
    @Override
    public void onEnable() {
        //saveDefaultConfig();

        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[Simple Homes - Ver (" + getDescription().getVersion() + ")]" + ChatColor.GREEN + " is running!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!((sender) instanceof Player)) {return true;}
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("SetHome") && !getConfig().getBoolean("use-beds")) {
            player.setRespawnLocation(player.getLocation());
            player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.GREEN + " Home set!");
        }

        if (command.getName().equalsIgnoreCase("Home")) {
            if (player.getRespawnLocation() == null) {
                player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.RED + " You have no bed set!");
            } else {
                player.teleport(player.getRespawnLocation());
                player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 0.5f);
                player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.GREEN + " Teleporting to home!");
            }
        }

        if (command.getName().equalsIgnoreCase("Spawn")) {
            player.teleport(getServer().getWorld(player.getWorld().getName()).getSpawnLocation());
            player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 0.5f);
            player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.GREEN + " Teleporting to spawn!");
        }

        return true;
    }
}