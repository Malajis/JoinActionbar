package me.malajis.joinactionbar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    static Main onEnable;
    @Override
    public void onEnable() {
        getLogger().info("\n" +
                "+------------------------------------------+\n" +
                "|                                          |\n" +
                "|     JoinActionbar v1.4                   |\n" +
                "|     by Malajis                           |\n" +
                "|                                          |\n" +
                "+------------------------------------------+");
        Bukkit.getPluginManager().registerEvents(new AccessListener(),this);
        Objects.requireNonNull(Bukkit.getPluginCommand("jareload")).setExecutor(new Command());
        saveDefaultConfig();
        onEnable=this;
    }
    @Override
    public void onDisable() {
        getLogger().info("\n" +
                "+------------------------------------------+\n" +
                "|                                          |\n" +
                "|     JoinActionbar v1.4                   |\n" +
                "|     by Malajis                           |\n" +
                "|                                          |\n" +
                "+------------------------------------------+");
    }
}
