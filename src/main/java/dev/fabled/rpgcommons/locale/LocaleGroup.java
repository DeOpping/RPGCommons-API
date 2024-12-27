package dev.fabled.rpgcommons.locale;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class LocaleGroup {

    private final @NotNull String group;
    private final @NotNull Map<String, List<String>> messages;

    public LocaleGroup(final @NotNull String group) {
        this.group = group;
        messages = new HashMap<>();
    }

    public @NotNull List<String> getMessage(final @NotNull String messageKey) {
        return new ArrayList<>(messages.getOrDefault(messageKey, Collections.emptyList()));
    }

}
