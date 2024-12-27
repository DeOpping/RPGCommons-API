package dev.fabled.rpgcommons.logging;

import org.jetbrains.annotations.NotNull;

public enum PluginLogLevel {

    INFO,
    SUCCESS("<green>"),
    WARNING("<yellow>"),
    ERROR("<red>");

    final @NotNull String color;

    PluginLogLevel(final @NotNull String color) {
        this.color = color;
    }

    PluginLogLevel() {
        this("");
    }

}
