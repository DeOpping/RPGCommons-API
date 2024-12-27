package dev.fabled.rpgcommons;

import dev.fabled.rpgcommons.configuration.YamlConfig;
import dev.fabled.rpgcommons.locale.LocaleManager;
import dev.fabled.rpgcommons.logging.PluginLog;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public abstract class RPGPlugin extends JavaPlugin {

    /**
     * A method to call to easily reload your plugin<br>
     * Does nothing by default, override it in your main class!
     */
    public void onReload() {

    }

    /**
     * Returns RPGCommon's instance of its API
     * @return {@link RPGCommonsAPI}
     */
    public abstract @NotNull RPGCommonsAPI getAPI();

    /**
     * Returns your plugin's config.yml
     * @return {@link YamlConfig}
     */
    public abstract @NotNull YamlConfig getConfigYml();

    /**
     * Returns your plugin's instance of the {@link PluginLog}
     * @return {@link PluginLog}
     */
    public abstract @NotNull PluginLog getPluginLog();

    /**
     * Returns your plugin's instance of the {@link LocaleManager}
     * @return {@link LocaleManager}
     */
    public abstract @NotNull LocaleManager getLocaleManager();

}
