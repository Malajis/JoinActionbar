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
        //取消原版提示
        j.setJoinMessage(null);
        Player p = j.getPlayer();
        String message = "JoinMessage";
        //判断权限对应提示文本
        if (p.hasPermission("betteraccess.op")) {
            message = "JoinMessageOP";
        }else if(p.hasPermission("betteraccess.vip")){
            message = "JoinMessageVIP";
        }
        //给所有在线玩家发送提示
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Objects.requireNonNull(Main.onEnable.getConfig().getString(message)).replace("%player%", p.getName()).replace("&", "§")));
        }
    }
    //退出服务器触发事件
    @EventHandler
    public void onQuit(PlayerQuitEvent q){
        //取消原版提示
        q.setQuitMessage(null);
        Player p = q.getPlayer();
        String message = "QuitMessage";
        //判断权限对应提示文本
        if (p.hasPermission("betteraccess.op")) {
            message = "QuitMessageOP";
        }else if(p.hasPermission("betteraccess.vip")){
            message = "QuitMessageVIP";
        }
        //给所有在线玩家发送提示
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(Objects.requireNonNull(Main.onEnable.getConfig().getString(message)).replace("%player%", p.getName()).replace("&", "§")));
        }
    }
}
