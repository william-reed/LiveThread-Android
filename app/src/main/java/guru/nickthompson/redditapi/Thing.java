package guru.nickthompson.redditapi;

/**
 * Created by nick on 9/29/17.
 */

public abstract class Thing {
    protected final String id;
    protected final String name;


    public Thing() {
        this.id = null;
        this.name = null;
    }
}
