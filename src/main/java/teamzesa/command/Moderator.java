package teamzesa.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.command.register.CommandRegisterSection;
import teamzesa.util.Enum.ColorList;
import teamzesa.util.Enum.CommandExecutorMap;

import java.sql.Struct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Moderator extends CommandRegisterSection {
    private final Set<String> moderatorName;

    public Moderator() {
        super(CommandExecutorMap.MODERATOR);
        this.moderatorName = new HashSet<>();
        moderList();
    }

    private void moderList() {
        this.moderatorName.add("27d84b4f-5991-4001-89d5-0fdfd3374a3d");//jaxple
        this.moderatorName.add("7e57dd28-bdba-4312-84ea-2da58cd6e598");//kelriex
        this.moderatorName.add("581a57af-91c9-4cf1-a173-85a2b48b68a7");//18_70015401
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        String successComment = "지금부터 관리자 입니다.";

        Optional.ofNullable(Bukkit.getPlayer(args[0])).ifPresent(
                player -> {
                    if (checkUPModerator(player)) {
                        playerSendMsgComponentExchanger(player, successComment, ColorList.ORANGE);
                        player.setOp(true);
                    }
                }
        );
        return true;
    }

    private boolean checkUPModerator(@NotNull Player sendPlayer) {
        String senderUUID = sendPlayer.getUniqueId().toString(); //String 대쉬 표기
        return this.moderatorName.stream().anyMatch(senderUUID::equals);
    }
}
