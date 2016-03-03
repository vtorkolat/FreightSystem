package com.frightsystem.command.impl;

import com.frightsystem.command.impl.impl.*;
import com.frightsystem.exceptions.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory  {

    private static final String COMMAND_NOT_FOUND_MESSAGE = "Command %s not found";
    private static Map<String, Command> commands = new HashMap<>();

    {commands.put("lending", new LendingPageCommand());
     commands.put("login", new LoginPageCommand());
     commands.put("registration", new RegistrationPageCommand());
     commands.put("edit", new EditProfilePageCommand());
     commands.put("addcargo", new AddCargoCommand());
     commands.put("addvehicle", new AddVehicleCommand());
     commands.put("autorize", new AuthorizeCommand()) ;

    }

    private CommandFactory() {}

    public static Command getCommandByName(String commandName) {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }
        throw new CommandNotFoundException(String.format(COMMAND_NOT_FOUND_MESSAGE, commandName));
    }


}
