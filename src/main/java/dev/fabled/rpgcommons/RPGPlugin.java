package dev.fabled.rpgcommons;

import dev.fabled.rpgcommons.configuration.YamlConfig;
import dev.fabled.rpgcommons.logging.PluginLog;
import org.jetbrains.annotations.NotNull;

public interface RPGPlugin {

    @NotNull YamlConfig getConfigYml();
    @NotNull PluginLog getPluginLog();

}
