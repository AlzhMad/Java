package db;

import jdk.jshell.TypeDeclSnippet;
import models.*;
import models.Character;

import java.sql.*;
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

    public static void addUser(User user){
        try{
            PreparedStatement statement= connection.prepareStatement(""+
                    "insert into users(login, password, fullname)" +
                    "values(?,?,?)");
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFullName());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<News> getNewsList(String ln){
        ArrayList<News> news = new ArrayList<News>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select n.id, c.id cid, c.title, substr(c.content,1,200) content,  l.id lid, l.code, l.name lname, n.post_date, ca.id caid, ca.name caname " +
                    " from news n " +
                    " join news_content c on  n.id = c.news_id " +
                    " left join news_categories ca on n.category_id = ca.id " +
                    " left join languages l on c.language_id = l.id  " +
                    "where ? is null or l.code = ? " +
                    "order by  n.post_date desc");
            statement.setString(1,ln);
            statement.setString(2,ln);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                news.add(new News(resultSet.getLong("id"),
                         new Content( resultSet.getLong("cid"),
                                 resultSet.getString("title"),
                                 resultSet.getString("content"),
                                 new Language(resultSet.getLong("lid"),
                                         resultSet.getString("code"),
                                         resultSet.getString("lname"))),
                                 resultSet.getTimestamp("post_date"),
                        new Category(resultSet.getLong("caid"),
                                resultSet.getString("caname"))));
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
                "insert into news(category_id) " +
                "values (?)", Statement.RETURN_GENERATED_KEYS);
        statement.setLong(1, news.getCategory().getId());

        statement.execute();
            Long newsId= 0L;
        ResultSet resultSet= statement.getGeneratedKeys();
        if(resultSet.next()){
         newsId = resultSet.getLong(1);
        }
        statement.close();

        PreparedStatement statementForContent = connection.prepareStatement("" +
                    "insert into news_content(title,content, language_id, news_id) " +
                    "values (?,?,?,?)");
        statementForContent.setString(1, news.getContent().getTitle());
        statementForContent.setString(2, news.getContent().getContent());
        statementForContent.setLong(3, news.getContent().getLanguage().getId());
        statementForContent.setLong(4, newsId);
        statementForContent.executeUpdate();
        statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static News getNews(Long id){
        News news=null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select n.id, c.id cid, c.title, substr(c.content,1,250) content,  l.id lid, l.code, l.name lname, n.post_date, ca.id caid, ca.name caname " +
                    " from news n " +
                    " join news_content c on  n.id = c.news_id " +
                    " left join news_categories ca on n.category_id = ca.id " +
                    " left join languages l on c.language_id = l.id  " +
                    "where  n.id =?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
               news =new News(resultSet.getLong("id"),
                       new Content( resultSet.getLong("cid"),
                               resultSet.getString("title"),
                               resultSet.getString("content"),
                               new Language(resultSet.getLong("lid"),
                                       resultSet.getString("code"),
                                       resultSet.getString("lname"))),
                       resultSet.getTimestamp("post_date"),
                       new Category(resultSet.getLong("caid"),
                               resultSet.getString("caname")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return news;
    }

    public static ArrayList<Item> geItemsList(){
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from items order by id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(new Item(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItem(Long id){
        Item item=null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from items where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                item = new Item(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    public static ArrayList<Comment> getCommentsList(Long newsId){
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  c.id, c.comment, c.post_date, u.id uid, u.fullname , u.login, c.news_id " +
                    " from comments c join users u on c.user_id = u.id  " +
                    " where c.news_id = ? order by c.post_date desc");
            statement.setLong(1,newsId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comments.add(new Comment(resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getTimestamp("post_date"),
                        new User(resultSet.getLong("uid"),
                                resultSet.getString("login"),null,null,
                                resultSet.getString("fullname")),
                        resultSet.getLong("news_id")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  comments;
    }

    public static void addComment(Comment comment){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "insert into comments(comment, user_id, news_id) " +
                    "values (?,?,?)");
            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getUser().getId());
            statement.setLong(3, comment.getNewsId());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Category> getCategoriesList() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  id, upper(name)  name from news_categories order by  name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getLong("id"),
                        resultSet.getString("name")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public static ArrayList<Language> getLanguagesList() {
        ArrayList<Language> languages = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "select   id, upper(code) code, upper(name) name from languages order by  name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                languages.add(new Language(resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name")));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return languages;
    }

    public static Language getLanguage(Long id){
        Language language = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select * from languages where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                language = new Language(
                        resultSet.getLong("id"),
                        resultSet.getString("code"),
                        resultSet.getString("name")
                );
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return language;
    }

    public static Category getCategory(Long id){
        Category category = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "select  * from news_categories where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                category = new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return category;
    }

    public static void deleteNews(Long id) {

        try {
            PreparedStatement statement1 = connection.prepareStatement("" +
                    "delete from comments where news_id = ?");
            statement1.setLong(1, id);
            statement1.executeUpdate();
            statement1.close();
            PreparedStatement statement2 = connection.prepareStatement("" +
                    "delete from news_content where news_id = ?");
            statement2.setLong(1, id);
            statement2.executeUpdate();
            statement2.close();
            PreparedStatement statement3 = connection.prepareStatement("" +
                    "delete from news where id = ?");
            statement3.setLong(1, id);
            statement3.executeUpdate();
            statement3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
