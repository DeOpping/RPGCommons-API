package dev.fabled.rpgcommons.configuration;

import org.bukkit.configuration.file.FileConfiguration;

public interface YamlConfig {

    /**
     * @return The currently loaded {@link FileConfiguration}
     */
    FileConfiguration options();

    /**
     * Save the resource to the server<br>Does not replace any file already on the server
     */
    void save();

    /**
     * Save the changes to the {@link FileConfiguration} to the file on the server
     */
    void saveChanges();

    /**
     * Reloads the {@link FileConfiguration} from the file on the server
     */
    void reload();

}
