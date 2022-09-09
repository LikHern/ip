package duke.commands;

import duke.storage.Storage;
import duke.task.TaskList;

public abstract class Command {
    private boolean isExit = false;

    public boolean isExit() {
        return isExit;
    }

    protected void setIsExitToTrue() {
        isExit = true;
    }

    public abstract void execute(TaskList taskList, Storage storage);
}