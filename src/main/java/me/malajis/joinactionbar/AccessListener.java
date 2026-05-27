package me.malajis.joinactionbar;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccessListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent j) {
        j.setJoinMessage(null);
        Player p = j.getPlayer();
        sendActionbar(getGroupMessage(p, "join"), p);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent q) {
        q.setQuitMessage(null);
        Player p = q.getPlayer();
        sendActionbar(getGroupMessage(p, "quit"), p);
    }

    private String getGroupMessage(Player p, String type) {
        ConfigurationSection groups = Main.onEnable.getConfig().getConfigurationSection("Groups");
        if (groups == null) {
            return "";
        }

        List<Map.Entry<String, ConfigurationSection>> sortedGroups = new ArrayList<>();
        for (String key : groups.getKeys(false)) {
            ConfigurationSection group = groups.getConfigurationSection(key);
            if (group != null) {
                sortedGroups.add(new AbstractMap.SimpleEntry<>(key, group));
            }
        }

        sortedGroups.sort((a, b) -> {
            int pa = a.getValue().getInt("priority", 0);
            int pb = b.getValue().getInt("priority", 0);
            return Integer.compare(pb, pa);
        });

        String defaultMessage = "";

        for (Map.Entry<String, ConfigurationSection> entry : sortedGroups) {
            ConfigurationSection group = entry.getValue();
            String permission = group.getString("permission");

            if (permission == null || permission.isEmpty()) {
                if (defaultMessage.isEmpty()) {
                    defaultMessage = group.getString(type, "");
                }
                continue;
            }

            if (p.hasPermission(permission)) {
                return group.getString(type, "");
            }
        }

        return defaultMessage;
    }

    public void sendActionbar(String message, Player p) {
        if (message == null || message.isEmpty()) {
            return;
        }
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message.replace("%player%", p.getName()).replace("&", "\u00a7")));
        }
    }
}
