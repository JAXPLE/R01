package teamzesa.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.command.register.CommandRegisterSection;
import teamzesa.entity.User;
import teamzesa.util.Enum.CommandExecutorMap;
import teamzesa.util.Interface.StringComponentExchanger;
import teamzesa.util.userHandler.UserController;
import teamzesa.util.userHandler.UserIOHandler;
import teamzesa.util.Enum.ColorList;

import java.util.Optional;


public class SaveUserData extends CommandRegisterSection {
    private Player senderPlayer;
    private boolean isConsoleSend = false;

    public SaveUserData() {
        super(CommandExecutorMap.SAVE_USER_DATA);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, String label, String[] args) {
        User senderUser = new UserController().readUser(sender.getName());
        Optional.ofNullable(senderUser).ifPresentOrElse(
                existUser -> this.senderPlayer = Bukkit.getPlayer(existUser.uuid()),
                ()        -> this.isConsoleSend = true
        );

        if (senderUser != null && !this.senderPlayer.isOp()) {
            playerSendMsgComponentExchanger(this.senderPlayer,"해당 명령어는 플레이어가 사용할 수 없습니다.", ColorList.RED);
            return false;
        }

        sendComment("Success to saving UserData");
        return true;
    }

    private void sendComment(String comment) {
        if (isConsoleSend)
            Bukkit.getLogger().info("[R01] " + comment);
        else playerSendMsgComponentExchanger(this.senderPlayer, comment, ColorList.YELLOW);
        UserIOHandler.exportUserData("Using Save User Command");
    }
}
