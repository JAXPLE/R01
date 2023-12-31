package teamzesa.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;
import teamzesa.util.ComponentExchanger;
import teamzesa.util.Enum.ColorList;
import teamzesa.event.EventExecutor;

import java.util.Optional;

public class ArmourSet extends ComponentExchanger implements CommandExecutor, EventExecutor {
    private PlayerInventory playerInventory;

    private enum ArmourType {
        hat
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player = (Player) sender;
        this.playerInventory = player.getInventory();

        ItemStack tmpItemInHand = playerInventory.getItemInMainHand();
        if (tmpItemInHand.isEmpty()) {
            playerSendMsgComponentExchanger(player,"손에 아이템이 없습니다.", ColorList.RED);
            return false;
        }

        ArmourType armourType = ArmourType.valueOf(label);
        switch (armourType) {
            case hat -> headSet(tmpItemInHand);
        }
        return true;
    }

    private void headSet(ItemStack temp){
        ItemStack armourHead = playerInventory.getHelmet();
        playerInventory.setHelmet(temp);
        playerInventory.setItemInMainHand(armourHead);
    }
}
