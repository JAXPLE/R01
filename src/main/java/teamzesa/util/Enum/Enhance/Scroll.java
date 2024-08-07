package teamzesa.util.Enum.Enhance;

import com.google.common.base.Functions;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import teamzesa.event.Enhance.Interface.ScrollMap;
import teamzesa.exception.Enhance.EnhanceItemSearchException;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Scroll implements ScrollMap {
    DRAGON_EGG(Material.DRAGON_EGG, 0),
    END_CRYSTAL(Material.END_CRYSTAL, 1),
    ENCHANTED_GOLDEN_APPLE(Material.ENCHANTED_GOLDEN_APPLE, 1),
    NETHER_STAR(Material.NETHER_STAR, 1),
    TNT(Material.TNT, 6),
    SCULK_SHRIEKER(Material.SCULK_SHRIEKER, 2),
    SCULK_SENSOR(Material.SCULK_SENSOR, 1),
    CONDUIT(Material.CONDUIT, 1),
    DRAGON_HEAD(Material.DRAGON_HEAD, 1),
    RABBIT_FOOT(Material.RABBIT_FOOT, 2),
    HEART_OF_THE_SEA(Material.HEART_OF_THE_SEA, 3),
    TOTEM_OF_UNDYING(Material.TOTEM_OF_UNDYING, 8),
    ENDER_PEARL(Material.ENDER_PEARL, 16);

    private final Material material;
    private final int discountValue;
    private static final Map<Material, Scroll> CACHED_ITEM = Arrays.stream(values())
                    .collect(Collectors.toMap(scroll -> scroll.material, Functions.identity()));

    Scroll(Material material, int discountValue) {
        this.discountValue = discountValue;
        this.material = material;
    }

    public static Scroll findByItemStack(ItemStack itemStack) throws Exception {
        if (!CACHED_ITEM.containsKey(itemStack.getType()))
            throw new EnhanceItemSearchException("Non Register This Material");
        return CACHED_ITEM.get(itemStack.getType());
    }

    public Material getMaterial() {
        return material;
    }

    public int getDiscountValue() {
        return discountValue;
    }
}
