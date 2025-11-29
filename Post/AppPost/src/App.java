import Entities.Comment;
import Entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Comment c1,c2,c3,c4;

        c1 = new Comment("Have a nice trip");
        c2 = new Comment("Wow that´s awesome!");

        c3 = new Comment("Good night");
        c4 = new Comment("May the Force be with you");

        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand", "I´m going to visit this wonderful country!", 12);
        p1.addComment(c1);
        p1.addComment(c2);

        Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomoroow", 5);
        p2.addComment(c3);
        p2.addComment(c4);

    }
}