package teamzesa;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import teamzesa.dataValue.ColorList;

public class ComponentExchanger {

    public static @NotNull Component createLinkComponent(String text, String url, @NotNull ColorList color) {
        TextComponent.Builder component = Component.text()
                .content(text)
                .color(color.getTextColor())
                .clickEvent(ClickEvent.openUrl(url));
        return component.build();
    }

    public static void serverAnnouncer(String string, @NotNull ColorList color) {
        Component component = Component.text(string)
                .color(color.getTextColor());
        Bukkit.broadcast(component);
    }

    public static void playerAnnouncer(@NotNull Player player, String string, @NotNull ColorList color) {
        Component component = Component.text(string)
                .color(color.getTextColor());
        player.sendMessage(component);
    }

    public static void playerAnnouncer(@NotNull Player player, String string) {
        player.sendMessage(Component.text(string));
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull Component componentSet(String string) {
        return Component.text(string);
    }

    public static @NotNull Component componentSet(String string, @NotNull ColorList color) {
        return Component.text(string)
                .color(color.getTextColor());
    }
}
