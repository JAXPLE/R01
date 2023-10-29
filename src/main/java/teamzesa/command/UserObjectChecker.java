package teamzesa.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.ComponentExchanger;
import teamzesa.dataValue.userData.User;
import teamzesa.dataValue.userData.UserMapHandler;
import teamzesa.resgisterEvent.EventExecutor;

import java.awt.*;
import java.util.Optional;

public class UserObjectChecker implements CommandExecutor, EventExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Optional<Player> player = Optional.ofNullable(Bukkit.getPlayer(args[0]));
        User user = null;

        if (player.isPresent())
            user = UserMapHandler.getUserHandler().getUser(player.get());

        sendContext((Player) sender, user);
        return true;
    }

    private void sendContext(Player sender, User user) {
        Bukkit.getLogger().info(user.toString());
        ComponentExchanger.playerAnnouncer(sender, user.toString(), Color.YELLOW);
    }
}
