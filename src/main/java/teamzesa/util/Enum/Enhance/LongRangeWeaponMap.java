package teamzesa.util.Enum.Enhance;

import org.bukkit.Material;

public enum LongRangeWeaponMap implements Weapon {
    TRIDENT(Material.TRIDENT, 9.0, 8.0),
    CROSSBOW(Material.CROSSBOW, 1.0, 8.0),
    BOW(Material.BOW, 1.0, 8.0);

    private final Material material;
    private final double shortRangeDamage;
    private final double longRangeDamage;

    LongRangeWeaponMap(Material material, double shortRangeDamage, double longRangeDamage) {
        this.material = material;
        this.shortRangeDamage = shortRangeDamage;
        this.longRangeDamage = longRangeDamage;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public double getShortRangeDamage() {
        return shortRangeDamage;
    }

    @Override
    public double getLongRangeDamage() {
        return longRangeDamage;
    }
}