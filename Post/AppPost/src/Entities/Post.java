package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private Date moment;
    private String title;
    private String content;
    private int likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(){

    }

    public Date getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public Post(Date moment, String title, String content, int likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment(Comment c){
        this.comments.add(c);
    }

    public void removeComment(Comment c){
        this.comments.remove(c);
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append(this.title + "\n");
        sb.append(this.title + " Likes - "+ sdf.format(moment)+"\n");
        sb.append(this.content + "\n");
        sb.append("Comments:\n");
        for (Comment c :this.comments){
            sb.append(c+"\n");
        }

        return sb.toString();
    }


}
