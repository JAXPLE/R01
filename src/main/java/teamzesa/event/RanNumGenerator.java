package teamzesa.event;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class RanNumGenerator {
    private static final int MAX_RANDOM_TP = 1000;
    private static final int MIN_RANDOM_TP = -1000;


    public static int numGenerator() {
        int range = MAX_RANDOM_TP - MIN_RANDOM_TP + 1;
        return (int) (Math.random() * range) + MIN_RANDOM_TP;
        }

    public static int groundChecker(World world) {
        int maxHigh = world.getMaxHeight() - 1; //320 > Material_VOID_AIR
        int minHigh = world.getMinHeight(); //-64
        int x = numGenerator();
        int z = numGenerator();

        for (int y = maxHigh; y > minHigh; y--) {
        Block block = world.getBlockAt(x, y, z);
        if (block.getType() != Material.AIR)
            return y;
        }
        return 0;
    }
}