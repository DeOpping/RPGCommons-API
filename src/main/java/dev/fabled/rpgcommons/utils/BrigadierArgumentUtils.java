package dev.fabled.rpgcommons.utils;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.jetbrains.annotations.NotNull;

public final class BrigadierArgumentUtils {

    public static @NotNull CommandSyntaxException commandSyntaxException(final @NotNull String message) {
        return new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherUnknownArgument(), () -> message);
    }

}
