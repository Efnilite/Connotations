package com.efnilite.connotations;

import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * A class for writing currently existing commands to files.
 *
 * @author Efnilite
 */
public class CommandWriter {

    private Plugin plugin;
    private CommandFactory factory;

    public CommandWriter(Plugin plugin, CommandFactory factory) {
        this.plugin = plugin;
        this.factory = factory;
    }

    /**
     * A way to write all currently existing commands (registered with the {@link CommandFactory}
     * to a yaml file.
     *
     * @param   file
     *          The location of the yaml file.
     *
     * @throws  IOException
     *          When something goes wrong with saving the yaml file.
     */
    public void writeAll(String file) throws IOException {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(file));
        for (String name : factory.getRegisteredCommands()) {
            Command command = factory.getMap().getCommand(name);
            if (command != null) {
                config.set("commands." + name + ".description", command.getDescription());
                config.set("commands." + name + ".aliases", command.getAliases());
                config.set("commands." + name + ".permission", command.getPermission());
                config.set("commands." + name + ".permission-message", command.getPermissionMessage());
                config.set("commands." + name + ".usage", command.getUsage());
            }
        }
        config.save(file);
    }


    /**
     * A way to write all currently existing commands into a file (registered with the {@link CommandFactory})
     * from a specific {@link Commandable} instance.
     *
     * @param   commandable
     *          The commandable instance.
     *
     * @param   file
     *          The location of the yaml file.
     *
     * @throws  IOException
     *          When something goes wrong with saving the yaml file.
     */
    public void write(Commandable commandable, String file) throws IOException {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(file));
        HashMap<String, CommandInstanceMap> methods = factory.getMethods();
        for (String name : factory.getRegisteredCommands()) {
            if (methods.get(name).getCommandable() == commandable) {
                Command command = factory.getMap().getCommand(name);
                if (command != null) {
                    config.set("commands." + name + ".description", command.getDescription());
                    config.set("commands." + name + ".aliases", command.getAliases());
                    config.set("commands." + name + ".permission", command.getPermission());
                    config.set("commands." + name + ".permission-message", command.getPermissionMessage());
                    config.set("commands." + name + ".usage", command.getUsage());
                }
            }
        }
        config.save(file);
    }
}
