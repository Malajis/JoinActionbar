package me.malajis.betteraccess;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    static Main onEnable;
    @Override
    public void onEnable() {
        //启动文本
        getLogger().info("\n" +
                "╔══╗─╔═══╗╔════╗╔════╗╔═══╗╔═══╗╔══╗╔══╗╔══╗╔═══╗╔══╗╔══╗\n" +
                "║╔╗║─║╔══╝╚═╗╔═╝╚═╗╔═╝║╔══╝║╔═╗║║╔╗║║╔═╝║╔═╝║╔══╝║╔═╝║╔═╝\n" +
                "║╚╝╚╗║╚══╗──║║────║║──║╚══╗║╚═╝║║╚╝║║║──║║──║╚══╗║╚═╗║╚═╗\n" +
                "║╔═╗║║╔══╝──║║────║║──║╔══╝║╔╗╔╝║╔╗║║║──║║──║╔══╝╚═╗║╚═╗║\n" +
                "║╚═╝║║╚══╗──║║────║║──║╚══╗║║║║─║║║║║╚═╗║╚═╗║╚══╗╔═╝║╔═╝║\n" +
                "╚═══╝╚═══╝──╚╝────╚╝──╚═══╝╚╝╚╝─╚╝╚╝╚══╝╚══╝╚═══╝╚══╝╚══╝");
        //注册事件监听器
        Bukkit.getPluginManager().registerEvents(new AccessListener(),this);
        //注册命令类
        Objects.requireNonNull(Bukkit.getPluginCommand("bareload")).setExecutor(new Command());
        //生成配置文件
        saveDefaultConfig();
        onEnable=this;
    }
    @Override
    public void onDisable() {
        //关闭文本
        getLogger().info("\n" +
                "╔══╗─╔═══╗╔════╗╔════╗╔═══╗╔═══╗╔══╗╔══╗╔══╗╔═══╗╔══╗╔══╗\n" +
                "║╔╗║─║╔══╝╚═╗╔═╝╚═╗╔═╝║╔══╝║╔═╗║║╔╗║║╔═╝║╔═╝║╔══╝║╔═╝║╔═╝\n" +
                "║╚╝╚╗║╚══╗──║║────║║──║╚══╗║╚═╝║║╚╝║║║──║║──║╚══╗║╚═╗║╚═╗\n" +
                "║╔═╗║║╔══╝──║║────║║──║╔══╝║╔╗╔╝║╔╗║║║──║║──║╔══╝╚═╗║╚═╗║\n" +
                "║╚═╝║║╚══╗──║║────║║──║╚══╗║║║║─║║║║║╚═╗║╚═╗║╚══╗╔═╝║╔═╝║\n" +
                "╚═══╝╚═══╝──╚╝────╚╝──╚═══╝╚╝╚╝─╚╝╚╝╚══╝╚══╝╚═══╝╚══╝╚══╝");
    }
}
