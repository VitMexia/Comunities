public class SetElement {

    public SetElement parent;
    public String twitterUser;
    public String retwitter;
    public int set;
    public int rank;
    public int size;

    public SetElement(String twitterUser){

        this.twitterUser = twitterUser;
        parent = this;
        rank = 0;
        size = 1;
    }

    public SetElement(String twitterUser, String retwiter){

        this.retwitter = retwiter;
        this.twitterUser = twitterUser;
        parent = this;
        rank = 0;
        size = 1;


    }
}
