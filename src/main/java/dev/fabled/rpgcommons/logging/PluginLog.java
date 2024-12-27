package dev.fabled.rpgcommons.logging;

import dev.fabled.rpgcommons.utils.ThrowableUtils;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public interface PluginLog {

    void onReload();



    void info(final boolean debug, final @NotNull List<String> message);

    default void info(final boolean debug, final @NotNull String... message) {
        info(debug, List.of(message));
    }

    default void info(final @NotNull List<String> message) {
        info(false, message);
    }

    default void info(final @NotNull String... message) {
        info(List.of(message));
    }



    void success(final boolean debug, final @NotNull List<String> message);

    default void success(final boolean debug, final @NotNull String... message) {
        success(debug, List.of(message));
    }

    default void success(final @NotNull List<String> message) {
        success(false, message);
    }

    default void success(final @NotNull String... message) {
        success(List.of(message));
    }



    void warn(final boolean debug, final @NotNull List<String> message);

    default void warn(final boolean debug, final @NotNull String... message) {
        warn(debug, List.of(message));
    }

    default void warn(final @NotNull List<String> message) {
        warn(false, message);
    }

    default void warn(final @NotNull String... message) {
        warn(List.of(message));
    }



    void error(final boolean debug, final @NotNull List<String> message);

    default void error(final boolean debug, final @NotNull String... message) {
        error(debug, List.of(message));
    }

    default void error(final @NotNull List<String> message) {
        error(false, message);
    }

    default void error(final @NotNull String... message) {
        error(List.of(message));
    }



    default void stacktrace(final @NotNull Throwable throwable, final boolean debug) {
        error(debug, ThrowableUtils.getStacktrace(throwable));
    }

    default void stacktrace(final @NotNull Throwable throwable) {
        stacktrace(throwable, false);
    }



    void divider(final @NotNull PluginLogLevel level, final boolean debug);

    default void divider(final @NotNull PluginLogLevel level) {
        divider(level, false);
    }

    default void divider(final boolean debug) {
        divider(PluginLogLevel.INFO, debug);
    }

    default void divider() {
        divider(PluginLogLevel.INFO, false);
    }



    void blank(final boolean debug);

    default void blank() {
        blank(false);
    }

}
