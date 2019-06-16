package com.efnilite.connotations.example;

import com.efnilite.connotations.Command;
import com.efnilite.connotations.Commandable;
import org.bukkit.command.CommandSender;

/**
 * An example class for commands.
 * <p>
 * Steps to register your own command class:
 * <p>
 * 1 - Create a new Class
 * <p>
 * 2 - Make it implement {@link Commandable}
 * <p>
 * 3 - Create a method that has the {@link Command}
 * <p>
 * Note: the method name is the name of the command!
 * If a method is named 'hello' it will register the command hello.
 * <p>
 * Note: the method must have the args as CommandSender and String[].
 * Variable name does not matter.
 *
 * @author Efnilite
 */
public class ExampleCommands implements Commandable {

    // None of these arguments are required, it is just as an example.
    @Command(
            description = "Does cool stuff!",
            aliases = {"yo"},
            permission = "hello",
            permissionMessage = "No can do!",
            usage = "/hello"
    )
    public void hello(CommandSender sender, String[] args) {
        sender.sendMessage("Hello!");
    }
}