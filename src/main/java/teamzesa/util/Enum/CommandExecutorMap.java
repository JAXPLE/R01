package teamzesa.util.Enum;

import org.bukkit.command.CommandExecutor;
import teamzesa.command.*;
import teamzesa.event.EnhanceStuffEvent;

public enum CommandExecutorMap {
    FLY("fly", new Fly()),
    MOTD("motd", new Motd()),
    GOD_MODE("god", new God()),
    ARMOUR_HEAD("hat", new Hat()),
    ARMOUR_CHEST("몸통", new Hat()),
    ARMOUR_LEGS("바지", new Hat()),
    ARMOUR_FEET("신발", new Hat()),
    MODERATOR("moderator", new Moderator()),
    HEALTH_RESET("setHealth", new SetHealth()),
    TOTEM_STACKING("totem", new Totem()),
    USER_OBJECT_CHECKER("vo", new ValueObjectChecker()),
    SAVE_USER_DATA("SaveUserData", new SaveUserData()),
    CONFIG_RELOAD("dataFileReload", new DataFileReload()),
    ANNOUNCING("공지", new AnnouncingOnOff()),
    ENHANCE("강화", new EnhanceStuff());

    private final String command;
    private final CommandExecutor executor;

    CommandExecutorMap(String command, CommandExecutor executor) {
        this.command = command;
        this.executor = executor;
    }

    public String getCommand() {
        return command;
    }

    public CommandExecutor newInstance() {
        return executor;
    }
}
