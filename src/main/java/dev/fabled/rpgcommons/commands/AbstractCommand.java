package dev.fabled.rpgcommons.commands;

import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("UnstableApiUsage")
public abstract class AbstractCommand {

    protected final @NotNull String name;
    protected final @Nullable String description;
    protected final @Nullable List<String> aliases;

    public AbstractCommand(
            final @NotNull String name,
            final @Nullable String description,
            final @NotNull List<String> aliases
    ) {
        this.name = name;
        this.description = description;
        this.aliases = new ArrayList<>(aliases);
    }

    public AbstractCommand(
            final @NotNull String name,
            final @Nullable String description,
            final @NotNull String... aliases
    ) {
        this(name, description, List.of(aliases));
    }

    public abstract @NotNull LiteralCommandNode<CommandSourceStack> node();

    protected static @NotNull Predicate<CommandSourceStack> permissionRequirement(final @NotNull String permission) {
        return commandSourceStack -> {
            if (!(commandSourceStack.getSender() instanceof Player player)) {
                return true;
            }

            return player.hasPermission(permission);
        };
    }

}
