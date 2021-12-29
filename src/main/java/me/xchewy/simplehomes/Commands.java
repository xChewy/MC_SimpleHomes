package me.xchewy.simplehomes;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!((sender) instanceof Player)) {return true;}
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("Home")) {
            if (player.getBedSpawnLocation() == null) {
                player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.RED + " You have no bed placed!");
            } else {
                player.teleport(player.getBedSpawnLocation());
                player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 0.5f);
                player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.GREEN + " Teleporting to home!");
            }
        }

        if (cmd.getName().equalsIgnoreCase("Spawn")) {
            player.teleport(getServer().getWorld(player.getWorld().getName()).getSpawnLocation());
            player.playSound(player.getLocation(), Sound.ITEM_CHORUS_FRUIT_TELEPORT, 1, 0.5f);
            player.sendMessage(ChatColor.GOLD + "[Simple Homes]" + ChatColor.GREEN + " Teleporting to spawn!");
        }

        return true;
    }
}