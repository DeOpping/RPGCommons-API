package dev.fabled.rpgcommons.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.fabled.rpgcommons.utils.BrigadierArgumentUtils;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.argument.CustomArgumentType;
import net.minecraft.commands.SharedSuggestionProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("ALL")
public final class PlayerArgument implements CustomArgumentType<Player, String> {

    public static @NotNull Player getPlayer(final @NotNull CommandContext<CommandSourceStack> context, final @NotNull String name) {
        return context.getArgument(name, Player.class);
    }

    @Override
    public @NotNull Player parse(StringReader reader) throws CommandSyntaxException {
        final String string = reader.readUnquotedString();
        final Player player = Bukkit.getPlayer(string);

        if (player == null) {
            throw BrigadierArgumentUtils.commandSyntaxException(string + " is not a valid online player!");
        }

        return player;
    }

    @Override
    public ArgumentType<String> getNativeType() {
        return StringArgumentType.word();
    }

    @Override
    public <S> @NotNull CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return SharedSuggestionProvider.suggest(
                Bukkit.getOnlinePlayers().stream().map(Player::getName).toList(),
                builder
        );
    }

}
