package me.malajis.betteraccess;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class AccessListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent j) {
        Player p = j.getPlayer();
        String name = p.getName();
        j.setJoinMessage(null);
        String msg = Main.onEnable.getConfig().getString("JoinMessage");
        for (Player playeronline : Bukkit.getOnlinePlayers()) {
            playeronline.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg.replace("%player%",name).replace("&","§")));
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent q){
        Player p = q.getPlayer();
        String name = p.getName();
        q.setQuitMessage(null);
        String msg = Main.onEnable.getConfig().getString("QuitMessage");
        for (Player playeronline : Bukkit.getOnlinePlayers()) {
            playeronline.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg.replace("%player%",name).replace("&","§")));
        }
    }
}