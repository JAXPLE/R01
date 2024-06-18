package teamzesa.DataBase.userHandler;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.DataBase.entity.User;

import java.util.*;

public class UserBuilder {
    private UUID uuid;
    private List<String> nameList = new ArrayList<>();
    private HashSet<String> connectionIPList = new HashSet<>();
    private int joinCount;
    private int level;
    private double healthScale;
    private int killCount;
    private boolean isGodMode;
    private boolean isAnnouncing;

    public UserBuilder(){}

    public UserBuilder(@NotNull User user) {
        uuid(user.uuid());
        nameList(user.nameList());
        ipList(user.connectionIPList());
        joinCount(user.joinCount());
        level(user.level());
        isGodMode(user.isGodMode());
        isAnnouncing(user.isAnnouncing());
    }

//    First Time add User
    public UserBuilder(Player player) {
        uuid(player.getUniqueId());
        nameList(player.getName());
        ipList(player.getAddress().getHostName());
        joinCount(0);
        level(player.getLevel());
        isGodMode(false);
        isAnnouncing(false);
    }

    public UserBuilder uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserBuilder nameList(List<String> name) {
        this.nameList = name;
        return this;
    }

    public UserBuilder nameList(String name) {
        this.nameList.add(name);
        return this;
    }

    public UserBuilder ipList(HashSet<String> ipList) {
        this.connectionIPList = ipList;
        return this;
    }

    public UserBuilder ipList(String ip) {
        this.connectionIPList.add(ip);
        return this;
    }

    public UserBuilder joinCount(int joinCnt) {
        this.joinCount = joinCnt;
        return this;
    }

    public UserBuilder level(int level) {
        this.level = level;
        return this;
    }

    public UserBuilder isGodMode(boolean currentGodMode) {
        this.isGodMode = currentGodMode;
        return this;
    }

    public UserBuilder isAnnouncing(boolean currentAnnouncingStatus) {
        this.isAnnouncing = currentAnnouncingStatus;
        return this;
    }

    public User build() {
        return new User(
                uuid,
                nameList,
                connectionIPList,
                joinCount,
                level,
                isGodMode,
                isAnnouncing
        );
    }

    public User buildAndUpdate() {
        User user = build();
        new UserController().updateUser(user);
        return user;
    }
}
