package miku;

import miku.command.Command;
import miku.parser.CommandMikuParser;
import miku.utility.Response;
import miku.utility.Storage;
import miku.utility.TaskList;

/**
 * Executes the program.
 */
public class Run {
    private static CommandMikuParser commandParser = new CommandMikuParser();
    private static Response ui = new Response();
    private static Storage storage = new Storage();
    private static TaskList taskList;

    public String getResponse(String userInput) {
        taskList = new TaskList();
        storage.init(taskList);
        Command cmd = commandParser.parse(userInput);
        assert cmd != null : "The parser should return a command!";
        cmd.execute(taskList, ui, storage);
        assert !ui.getResponse().isEmpty() : "Miku should return an response!";
        return ui.getResponse();

    }

}
