package db;

import models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class DBManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static long id = 4l;

    static{
        tasks.add(new Task(1l, "Kill YelowEyed Demon","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","2023-01-01", false));
        tasks.add(new Task(2l, "Find Colt","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","2023-01-01", false));
        tasks.add(new Task(3l, "Find Vampire Nest","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","2023-01-01", false));
    }

    public static ArrayList<Task> getTasks(){
        return tasks;
    }

    public static void addTask(Task t){
        t.setId(id);
        tasks.add(t);
        id++;
    }

    public static Task getTask(Long id){
        for(Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return  null;
    }

    public static void deleteTask(Long id) {

        Task t = tasks.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);

        int indexToDelete = tasks.indexOf(t);
        tasks.remove(indexToDelete);

    }
}
