package duke.storage;

import duke.task.TaskList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private final File dataFile;

    public Storage(String filePath) {
        dataFile = new File(filePath);
    }

    /**
     * Encode the task list and store in specified file path.
     *
     * @param taskList Task list to be saved.
     */
    public void save(TaskList taskList) {
        try {
            FileEncoder.encodeFile(dataFile, taskList);
        } catch (IOException ioe) {
            System.err.println("Warning! Errors encountered when writing to file. "
                    + "Your data might not be saved.");
        }
    }

    /**
     * Decode the file at specified file path and save the decoded tasks in a new task list, if such file exists.
     * Else, create a new empty file at specified file path.
     *
     * @return Task list containing decoded tasks.
     */
    public TaskList load() {
        TaskList taskList = new TaskList(new ArrayList<>());
        try {
            if (dataFile.createNewFile()) {
                System.out.println("Creating a new file...");
            }
            return FileDecoder.decodeFile(dataFile, taskList);
        } catch (IllegalStateException | IOException e) {
            System.err.println("Warning! Errors encountered when reading from file. "
                    + "The rest of the data is discarded.");
        }
        return taskList;
    }
}
