package teamzesa.event;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import teamzesa.util.ComponentExchanger;

public class EnhanceStuffEvent extends ComponentExchanger implements EventRegister{
    private Action action;
    private Player player;
    private final PlayerInteractEvent event;

    public EnhanceStuffEvent(PlayerInteractEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
        this.action = this.event.getAction();
        this.player = this.event.getPlayer();
    }

    @Override
    public void execute() {
        playerSendMsgComponentExchanger(this.player, this.action.name());
    }
}