package duke.commands;

import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;

import java.util.ListIterator;

public class ListCommand extends Command {
    public void execute(TaskList taskList, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        ListIterator<Task> listIterator = taskList.getListIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex() + 1 + "." + listIterator.next());
        }
    }
}
