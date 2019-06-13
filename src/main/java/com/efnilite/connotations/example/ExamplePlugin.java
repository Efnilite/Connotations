package com.efnilite.connotations.example;

import com.efnilite.connotations.CommandFactory;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * An example plugin class using Connotations.
 *
 * @see ExampleCommands
 */
public class ExamplePlugin extends JavaPlugin {

    private static CommandFactory factory;

    @Override
    public void onEnable() {
        factory = new CommandFactory(this);
        factory.registerClass(new ExampleCommands());
    }

    public static CommandFactory getFactory() {
        return factory;
    }
}
