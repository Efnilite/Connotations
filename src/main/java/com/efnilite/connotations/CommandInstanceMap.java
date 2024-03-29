package com.efnilite.connotations;

import java.lang.reflect.Method;

/**
 * A class for storing commandables and their methods
 *
 * @author Efnilite
 */
public class CommandInstanceMap {

    private Method method;
    private Commandable commandable;

    public CommandInstanceMap(Method method, Commandable commandable) {
        this.method = method;
        this.commandable = commandable;
    }

    public Method getMethod() {
        return method;
    }

    public Commandable getCommandable() {
        return commandable;
    }
}
