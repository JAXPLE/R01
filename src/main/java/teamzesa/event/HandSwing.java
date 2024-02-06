package teamzesa.event;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import teamzesa.R01;


public class HandSwing implements EventRegister {
    private Player player;
    private final PlayerArmSwingEvent event;

    public HandSwing(PlayerArmSwingEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
        this.player = this.event.getPlayer();
    }

    @Override
    public void execute() {
        if (this.player.getInventory().getItemInMainHand().getType() != Material.AIR)
            return;

        if (this.player.getInventory().getItemInOffHand().getType() != Material.AIR)
            return;

        if (this.event.getAnimationType() == PlayerAnimationType.OFF_ARM_SWING)
            return;

        BukkitTask offHandSwing = Bukkit.getScheduler().runTaskLater(
                R01.getPlugin(R01.class),
                () -> this.event.getPlayer().swingOffHand(),
                7L
        );
    }
}
