package dev.fabled.rpgcommons.permissions.annotations;

import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    @NotNull String description() default "";
    @NotNull PermissionDefault permissionDefault() default PermissionDefault.OP;
    @NotNull String[] children() default {""};

}

