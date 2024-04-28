package me.malajis.betteraccess;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class AccessListener implements Listener {
    //进入服务器触发事件
    @EventHandler
    public void onJoin(PlayerJoinEvent j) {
        j.setJoinMessage(null);
        Player p = j.getPlayer();
        String message = "JoinMessage";
        if (p.hasPermission("betteraccess.op")) {
            message = "JoinMessageOP";
        }else if(p.hasPermission("betteraccess.vip")){
            message = "JoinMessageVIP";
        }
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Objects.requireNonNull(Main.onEnable.getConfig().getString(message)).replace("%player%", p.getName()).replace("&", "§")));
        }
    }
    //退出服务器触发事件
    @EventHandler
    public void onQuit(PlayerQuitEvent q){
        q.setQuitMessage(null);
        Player p = q.getPlayer();
        String message = "QuitMessage";
        if (p.hasPermission("betteraccess.op")) {
            message = "QuitMessageOP";
        }else if(p.hasPermission("betteraccess.vip")){
            message = "QuitMessageVIP";
        }
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Objects.requireNonNull(Main.onEnable.getConfig().getString(message)).replace("%player%", p.getName()).replace("&", "§")));
        }
    }
}
