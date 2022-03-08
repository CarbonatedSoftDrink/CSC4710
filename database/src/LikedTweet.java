public class LikedTweet {
    protected int id;
    protected String UserID;
    protected int LikedTweetID;

    public LikedTweet() {
    }

    public LikedTweet(int id) {
        this.id = id;
    }

    public LikedTweet (int id, String UserID, int LikedTweetID){
        this(UserID, LikedTweetID);
        this.id = id;
    }

    public LikedTweet(String UserID, int LikedTweetID){
        this.UserID = UserID;
        this.LikedTweetID = LikedTweetID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public int getLikedTweetID() {
        return LikedTweetID;
    }

    public void setLikedTweetID(int likedTweetID) {
        this.LikedTweetID = likedTweetID;
    }
}
