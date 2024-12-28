package dev.fabled.rpgcommons;

import dev.fabled.rpgcommons.commands.CommandManager;
import dev.fabled.rpgcommons.configuration.YamlConfig;
import dev.fabled.rpgcommons.locale.LocaleManager;
import dev.fabled.rpgcommons.logging.PluginLog;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RPGCommonsAPI {

    /**
     * Get RPGCommon's instance of its API
     * @return The {@link RPGCommonsAPI} or <code>null</code> if the plugin is not on the server
     */
    static @Nullable RPGCommonsAPI getAPI() {
        final Plugin plugin = Bukkit.getPluginManager().getPlugin("RPGCommons");
        if (plugin instanceof RPGCommonsAPI api) {
            return api;
        }

        return null;
    }

    /**
     * Creates a config.yml for your plugin
     * @param plugin Your main class that extends {@link RPGPlugin}
     * @return {@link YamlConfig}
     */
    @NotNull YamlConfig createConfigYml(final @NotNull RPGPlugin plugin);

    /**
     * Creates a {@link PluginLog} for your plugin
     * @param plugin Your main class that extends {@link RPGPlugin}
     * @return {@link PluginLog}
     */
    @NotNull PluginLog createPluginLog(final @NotNull RPGPlugin plugin);

    /**
     * Creates a {@link LocaleManager} for your plugin
     * @param plugin Your main class that extends {@link RPGPlugin}
     * @return {@link LocaleManager}
     */
    @NotNull LocaleManager createLocaleManager(final @NotNull RPGPlugin plugin);

    /**
     * Creates a {@link CommandManager} for your plugin
     * @param plugin Your main class that extends {@link RPGPlugin}
     * @return {@link CommandManager}
     */
    @NotNull CommandManager createCommandManager(final @NotNull RPGPlugin plugin);

    /**
     * Creates a new {@link YamlConfig} from your resources or from the server
     * @param plugin Your main class that extends {@link RPGPlugin}
     * @param path The {@link String} path to the file starting in your plugin's directory
     * @return {@link YamlConfig}
     */
    YamlConfig createConfig(final @NotNull RPGPlugin plugin, final @NotNull String path);

}
