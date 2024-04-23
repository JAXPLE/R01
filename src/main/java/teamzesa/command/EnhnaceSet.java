package teamzesa.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import teamzesa.command.register.CommandRegisterSection;
import teamzesa.util.Enum.ColorList;
import teamzesa.util.Enum.CommandExecutorMap;
import teamzesa.util.Enum.EnhanceComment;

import java.util.Collections;

public class EnhnaceSet extends CommandRegisterSection {

    private String comment;

    public EnhnaceSet() {
        super(CommandExecutorMap.ENHANCE_SET);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        if (!commandSender.isOp()) {
            playerSendMsgComponentExchanger(player,"해당 명령어는 플레이어가 사용할 수 없습니다.", ColorList.RED);
            return false;
        }

        int enhanceLevel = Integer.parseInt(strings[0]);
        if (enhanceLevel < 0 || enhanceLevel > 10) {
            playerSendMsgComponentExchanger(player,"0 ~ 10 사이 값만 대입 가능합니다.", ColorList.RED);
            return false;
        }

        ItemStack targetStuff = player.getInventory().getItemInMainHand();
        targetStuff.setCustomModelData(enhanceLevel);
        targetStuff.lore(Collections.singletonList(getLoreCommentComponent(targetStuff)));

        playerSendMsgComponentExchanger(player, getComment(enhanceLevel) , ColorList.GREEN);
        return true;
    }

    private String getComment(int enhanceLevel) {
        return switch (enhanceLevel) {
            case 0 -> "강화를 초기화 했습니다.";
            case 10 -> "최고 레벨로 강화했습니다.";
            default -> enhanceLevel + "강 으로 강화했습니다.";
        };
    }

    private Component getLoreCommentComponent(ItemStack item) {
        for (EnhanceComment enhanceComment : EnhanceComment.values()) {
            if (item.getCustomModelData() == enhanceComment.getStep())
                return enhanceComment.getLoreComment();
        }
        return null;
    }
}