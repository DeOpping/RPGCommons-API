package dev.fabled.rpgcommons.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public enum MiniColor {

    CHAT,
    INVENTORY(
            StandardTags.color(),
            StandardTags.gradient(),
            StandardTags.rainbow(),
            StandardTags.font(),
            StandardTags.translatable(),
            StandardTags.reset(),
            StandardTags.decorations()
    ),
    CONSOLE(
            StandardTags.color()
    );

    private final @NotNull MiniMessage miniMessage;

    MiniColor(final @NotNull MiniMessage miniMessage) {
        this.miniMessage = miniMessage;
    }

    MiniColor(final @NotNull TagResolver... tagResolvers) {
        this(MiniMessage.builder()
                .tags(TagResolver.builder().resolvers(tagResolvers).build())
                .build()
        );
    }

    MiniColor() {
        this(MiniMessage.miniMessage());
    }

    /**
     * Deserializes a {@link String} into a {@link Component}
     * @param input The {@link String} to deserialize
     * @return The deserialized {@link Component}
     */
    public @NotNull Component deserialize(final @NotNull String input) {
        if (this == INVENTORY) {
            return miniMessage.deserialize(input).decoration(TextDecoration.ITALIC, false);
        }

        return miniMessage.deserialize(input);
    }

    /**
     * Deserializes a {@link String} {@link List} into a {@link Component} {@link List}
     * @param input The {@link String} {@link List} to deserialize
     * @return The deserialized {@link Component} {@link List}
     */
    public @NotNull List<Component> deserialize(final @NotNull List<String> input) {
        final List<Component> components = new ArrayList<>();
        input.forEach(string -> components.add(deserialize(string)));
        return components;
    }

    /**
     * Serializes a {@link Component} into a {@link String}
     * @param component The {@link Component} to serialize
     * @return The serialized {@link String}
     */
    public @NotNull String serialize(final @NotNull Component component) {
        return miniMessage.serialize(component);
    }

    /**
     * Serializes a list of components to a list of strings
     * @param components The {@link Component} {@link List} to serialize
     * @return The serialized {@link String} {@link List}
     */
    public @NotNull List<String> serialize(final @NotNull List<Component> components) {
        final List<String> list = new ArrayList<>();
        components.forEach(component -> list.add(miniMessage.serialize(component)));
        return list;
    }

    /**
     * Strips all MiniMessage tags from the given string
     * @param input The {@link String} to strip the tags from
     * @return The {@link String} with all tags stripped
     */
    public @NotNull String stripTags(final @NotNull String input) {
        return miniMessage.stripTags(input);
    }

    /**
     * Strips all MiniMessage tags from the given list of strings
     * @param input The {@link String} {@link List} to strip the tags from
     * @return A {@link String} {@link List} with the tags stripped
     */
    public @NotNull List<String> stripTags(final @NotNull List<String> input) {
        final List<String> stripped = new ArrayList<>();
        input.forEach(string -> stripped.add(miniMessage.stripTags(string)));
        return stripped;
    }

}
