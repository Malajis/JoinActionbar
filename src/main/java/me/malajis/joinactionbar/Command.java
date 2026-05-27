package me.malajis.joinactionbar;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        Main.onEnable.reloadConfig();
        commandSender.sendMessage(Objects.requireNonNull(Main.onEnable.getConfig().getString("Message.reload")).replace("&","§"));
        return false;
    }
}
