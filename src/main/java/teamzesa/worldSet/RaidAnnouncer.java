package teamzesa.worldSet;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidTriggerEvent;
import teamzesa.ComponentExchanger;

import java.awt.*;

public class RaidAnnouncer implements Listener {
    private Location loc;
    private double x;
    private double z;

    @EventHandler
    public void raidAnnouncer(RaidTriggerEvent e) {
        if (e.getPlayer().getUniqueId().toString().equals("27d84b4f-5991-4001-89d5-0fdfd3374a3d"))
            return;

        this.loc = e.getRaid().getLocation();
        String activeWorld = worldName(e.getWorld().getName());

        this.x = loc.getX();
        this.z = loc.getZ();

        ComponentExchanger.serverAnnouncer(
                String.format(
                        "%s 월드의 X : %1.0f Z : %1.0f 에서 레이드가 시작됩니다."
                        ,activeWorld,x,z) , "RED");
    }

    public String worldName(String worldName) {
        switch (worldName) {
            case "world" :
                return "야생";
            case "world_nether" :
                return "지옥";
            case "world_the_end" :
                return "엔더";
        }
        return null;
    }
}