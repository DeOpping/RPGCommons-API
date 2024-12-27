package dev.fabled.rpgcommons.locale;

import dev.fabled.rpgcommons.locale.annotations.MessageKey;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface LocaleManager {

    /**
     * Reloads the locale manager
     */
    void onReload();

    /**
     * Register all message keys from a class<br>
     * A message key is a static {@link String} field that is annotated with {@link MessageKey}
     * @param clazz The {@link Class} to register the keys from
     */
    void registerMessageKeys(final @NotNull Class<?> clazz);

    /**
     * Send a message to a player
     * @param player The {@link Player} to send the message to
     * @param messageKey The {@link String} key to the message
     */
    void sendMessage(final @NotNull Player player, final @NotNull String messageKey);

}
