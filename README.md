# JoinActionbar —— 更好的进出入提示

玩家进出服务器时，用 Actionbar（快捷栏上方）显示自定义提示，替代原版聊天栏消息。不同权限组的玩家可以看到不同的进出入提示。

## 安装

1. 把 jar 丢进 `plugins` 文件夹
2. 重启服务器，自动生成 `plugins/JoinActionbar/config.yml`
3. 按需修改配置文件，然后用 `/jareload` 热重载

## 指令

| 指令 | 说明 | 权限 |
|------|------|------|
| `/jareload` | 重载配置文件 | `joinactionbar.jareload`（默认 OP） |

## 配置文件

```yaml
Groups:
  op:
    permission: "joinactionbar.op"
    priority: 3
    join: "&6欢迎管理员 &c%player% &6加入服务器"
    quit: "&c管理员 &e%player% &c离开了服务器"
  vip:
    permission: "joinactionbar.vip"
    priority: 2
    join: "&d欢迎VIP &e%player% &d加入服务器"
    quit: "&cVIP &e%player% &c离开了服务器"
  default:
    priority: 1
    join: "&b欢迎玩家 &e%player% &b加入服务器"
    quit: "&c玩家 &e%player% &c离开了服务器"
Message:
  reload: "&aJoinActionbar 重载完成"
```

- 组名可以随便改（op、vip、default 只是示例）
- `priority` 越大越优先，玩家同时有多个权限时取最高的
- `%player%` 会替换成玩家名，`&` 开头是颜色代码
- `default` 组不需要填 `permission`，作为兜底

## 权限节点

| 权限 | 说明 |
|------|------|
| `joinactionbar.jareload` | 允许使用 `/jareload` 重载 |
| `joinactionbar.op` | 示例：OP 组权限 |
| `joinactionbar.vip` | 示例：VIP 组权限 |

权限组的权限节点是可以在 `config.yml` 里自定义的，上面只是默认配置。

## 兼容性

MC 1.13+，推荐 1.20.1+

---

[插件发布帖](https://klpbbs.com/thread-149692-1-1.html)
