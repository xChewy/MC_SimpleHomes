package me.xchewy.simplehomes;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleHomes extends JavaPlugin {
    @Override
    public void onEnable() {
        Commands commands = new Commands();

        getCommand("Home").setExecutor(commands);
        getCommand("Spawn").setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[Simple Homes - Ver (" + getDescription().getVersion() + ")]" + ChatColor.GREEN + " is running!");
    }
}