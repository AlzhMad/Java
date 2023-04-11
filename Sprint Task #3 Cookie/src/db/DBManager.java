package db;

import models.Character;
import models.News;
import models.Species;
import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javaee?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Character> getCharactersList() {
        ArrayList<Character> characters = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  c.id,  c.name, c.surname,s.id species_id, s.code species_code, s.name species_name, c.occupation " +
                    "from characters c, species s where  c.species_id = s.id order by  id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                characters.add(new Character(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("occupation"),
                        new Species(resultSet.getLong("species_id"),
                                resultSet.getString("species_code"),
                                resultSet.getString("species_name"))

                        )
                );
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characters;
    }

    public static void addCharacter(Character character) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into characters(name, surname, species_id, occupation) " +
                    "values (?,?,?,?)");
            statement.setString(1, character.getName());
            statement.setString(2, character.getSurname());
            statement.setLong(3, character.getSpecies().getId());
            statement.setString(4, character.getOccupation());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Character getCharacter(Long id) {
        Character character = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select c.id, c.name, c.surname, s.id species_id,s.code species_code, s.name species_name, c.occupation " +
                    "from characters c, species s where c.species_id =s.id  and  c.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                character = new Character(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("occupation"),
                        new Species(resultSet.getLong("species_id"),
                                resultSet.getString("species_code"),
                                resultSet.getString("species_name"))
                );
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return character;
    }

    public static void editCharacter(Character character) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "update characters set name =? ,surname =? ,species_id =? ,occupation = ? where id = ?");
            statement.setString(1, character.getName());
            statement.setString(2, character.getSurname());
            statement.setLong(3, character.getSpecies().getId());
            statement.setString(4, character.getOccupation());
            statement.setLong(5, character.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteCharacter(Long id) {

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "delete from characters where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Species> getSpeciesList() {
        ArrayList<Species> species = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from species order by  name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                species.add(new Species(resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return species;
    }

    public static void addSpecies(Species species) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into species(code, name) " +
                    "values (?,?)");

            statement.setString(1, species.getCode());
            statement.setString(2, species.getName());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Species getSpecies(Long id) {
        Species species = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from species where id =?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                species = new Species(
                        resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name")
                );
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return species;
    }

    public static User getUserByEmail(String email){
        User user = null;
        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "select * from users where upper(login) =upper(?)");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("fullname")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<News> getNewsList(String ln){
        ArrayList<News> news = new ArrayList<News>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from news where ? is null or language = ? order by  post_date desc");
            statement.setString(1,ln);
            statement.setString(2,ln);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                news.add(new News(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("language"),
                        resultSet.getTimestamp("post_date")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }

    public static void addNews(News news){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                "insert into news(title, content, language) " +
                "values (?,?,?)");
        statement.setString(1, news.getTitle());
        statement.setString(2, news.getContent());
        statement.setString(3, news.getLanguage());
        statement.executeUpdate();
        statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static News getNews(Long id){
        News news=null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from news where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                news = new News(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("language"),
                        resultSet.getTimestamp("post_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }
}
