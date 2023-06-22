package teamzesa.comabt;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDyingSet implements Listener {
    @EventHandler
    public void onDeathPlayer(PlayerDeathEvent e) {
        e.getEntity().setHealthScale(20);
    }
}