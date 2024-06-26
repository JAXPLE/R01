package teamzesa.event.Restricted;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import teamzesa.event.EventRegister.EventRegister;
import teamzesa.util.Interface.StringComponentExchanger;
import teamzesa.util.Enum.ColorMap;

public class RestrictedShulkerChest extends StringComponentExchanger implements EventRegister {

    private Player player;
    private ItemStack itemStack;
    private Inventory clickerInventory;
    private Inventory currentOpeningContainerInventory;
    private final InventoryClickEvent event;

    public RestrictedShulkerChest(InventoryClickEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
        this.player = (Player) this.event.getWhoClicked();
        this.itemStack = this.event.getCurrentItem();
        this.clickerInventory = this.event.getClickedInventory();
        this.currentOpeningContainerInventory = this.event.getInventory();
    }

    @Override
    public void execute() {
//        System.out.println("null check");
        if (this.clickerInventory == null)
            return;

//        System.out.println("getClickedInv > " + this.playerInventory.getType());
//        System.out.println("getInv > " + this.currentOpeningContainerInventory.getType());

//        System.out.println("current click container Typing Check");
        if (this.currentOpeningContainerInventory.getType() != InventoryType.SHULKER_BOX)
            return;

//        System.out.println("clicker container Typing Check");
        if (this.clickerInventory.getType() != InventoryType.PLAYER)
            return;

//        System.out.println("itemStack Type Check");
        if (this.itemStack.getType() != Material.TOTEM_OF_UNDYING)
            return;

//        System.out.println("itemStack amount Check");
        if (this.itemStack.getAmount() <= 1)
            return;

//        System.out.println("cancel");
        this.event.setCancelled(true);
        playerSendMsgComponentExchanger(player, "겹쳐진 토템은 셜커에 보관할 수 없습니다.", ColorMap.RED);
    }
}
