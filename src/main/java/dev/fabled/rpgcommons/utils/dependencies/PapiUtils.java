package dev.fabled.rpgcommons.utils.dependencies;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class PapiUtils {

    public static boolean hasPlaceholderAPI() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    public static @NotNull String parse(final @Nullable Player player, final @NotNull String input) {
        if (player == null || !hasPlaceholderAPI()) {
            return input;
        }

        return PlaceholderAPI.setPlaceholders(player, input);
    }

    public static @NotNull List<String> parse(final @Nullable Player player, final @NotNull List<String> input) {
        if (player == null || !hasPlaceholderAPI()) {
            return input;
        }

        return PlaceholderAPI.setPlaceholders(player, input);
    }

}
