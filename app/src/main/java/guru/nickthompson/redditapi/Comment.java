package guru.nickthompson.redditapi;

import java.util.List;

/**
 * Created by nick on 9/29/17.
 */

public class Comment extends Votable, Created {

    String author;
    String body;
    Boolean likes;
    String linkAuthor;
    String linkID;
    String linkTitle;
    String linkURL;
    String parentID;
    List<Thing> replies;
    int score;
    boolean scoreHidden;
    String subreddit;
    String subredditID;


}
