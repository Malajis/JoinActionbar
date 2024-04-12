package me.malajis.betteraccess;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    static Main onEnable;
    @Override
    public void onEnable() {
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        //启动文本
        System.out.println(yellow+"BetterAccess 已经成功加载至服务器"+reset);
        //注册事件监听器
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        //注册命令类
        Bukkit.getPluginCommand("bareload").setExecutor(new Command());
        //生成配置文件
        saveDefaultConfig();
        onEnable=this;
    }
    @Override
    public void onDisable() {
        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        //关闭文本
        System.out.println(yellow+"BetterAccess 已经成功从服务器中卸载"+reset);
    }
}
