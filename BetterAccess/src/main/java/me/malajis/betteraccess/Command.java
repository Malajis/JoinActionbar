package me.malajis.betteraccess;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        Main.onEnable.reloadConfig();
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        System.out.println(yellow+"BetterAccess已经重载成功！"+reset);
        commandSender.sendMessage(Main.onEnable.getConfig().getString("Message.reload").replace("&","§"));
        return false;
    }
}
