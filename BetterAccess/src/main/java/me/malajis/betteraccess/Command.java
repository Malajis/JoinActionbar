package me.malajis.betteraccess;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        Main.onEnable.reloadConfig();
        commandSender.sendMessage(Main.onEnable.getConfig().getString("Message.reload").replace("&","§"));
        return false;
    }
}
