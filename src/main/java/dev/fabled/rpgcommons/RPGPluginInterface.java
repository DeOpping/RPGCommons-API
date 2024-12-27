package dev.fabled.rpgcommons;

import dev.fabled.rpgcommons.configuration.YamlConfig;
import dev.fabled.rpgcommons.logging.PluginLog;

sealed interface RPGPluginInterface permits RPGPlugin {

    default void onReload() {}

    void reloadConfig();
    void reloadPluginLog();

    YamlConfig getConfigYml();
    PluginLog getPluginLog();

}
