public class Tweet {
    protected int id;
    protected String TweeterID;
    protected String Content;
    protected int ParentTweetID;

    public Tweet() {
    }

    public Tweet(int id) {
        this.id = id;
    }

    public Tweet (int id, String TweeterID, String Content, int ParentTweetID){
        this(TweeterID, Content, ParentTweetID);
        this.id = id;
    }

    public Tweet (String TweeterID, String Content, int ParentTweetID){
        this.TweeterID = TweeterID;
        this.Content = Content;
        this.ParentTweetID = ParentTweetID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTweeterID() {
        return TweeterID;
    }

    public void setTweeterID(String tweeterID) {
        TweeterID = tweeterID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getParentTweetID() {
        return ParentTweetID;
    }

    public void setParentTweetID(int parentTweetID) {
        ParentTweetID = parentTweetID;
    }
}
