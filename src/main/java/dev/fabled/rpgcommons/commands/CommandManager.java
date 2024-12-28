package dev.fabled.rpgcommons.commands;

import org.jetbrains.annotations.NotNull;

public interface CommandManager {

    void register(final @NotNull AbstractCommand command);

}
