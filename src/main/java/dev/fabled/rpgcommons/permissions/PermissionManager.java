package dev.fabled.rpgcommons.permissions;

import dev.fabled.rpgcommons.permissions.annotations.Permission;
import org.jetbrains.annotations.NotNull;

public interface PermissionManager {

    /**
     * Registers all permissions from a class<br>
     * A permission is a static {@link String} field that is annotated with {@link Permission}
     * @param clazz The {@link Class} to register permissions from
     */
    void registerPermissions(final @NotNull Class<?> clazz);

}
