package db;

import models.News;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DBManager {
    private static ArrayList<News> news = new ArrayList<>();
    private static long id = 4l;

    static{
        news.add(new News(1l, "Winchesters stopped Apocalypse","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","Carver Edlund", "Winchesters"));
        news.add(new News(2l, "All Hell Break Lose","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","Crowley", "Demons"));
        news.add(new News(3l, "Castiel raised Dean from Perdition","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","Carver Edlund", "Angels"));

    }

    public static ArrayList<News> getNews(String category){
        if(category!=null){
            ArrayList<News>  filtered = news.stream().filter(n->n.getCategory().equalsIgnoreCase(category)).collect(Collectors.toCollection(ArrayList::new));
            return  filtered;
        }
        return news;
    }

}
