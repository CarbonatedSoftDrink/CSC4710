public class LikedTweet {
    protected int id;
    protected String UserID;
    protected String FollowingUserID;

    public LikedTweet() {
    }

    public LikedTweet(int id) {
        this.id = id;
    }

    public LikedTweet (int id, String UserID, String FollowingUserID){
        this(UserID, FollowingUserID);
        this.id = id;
    }

    public LikedTweet(String UserID, String FollowingUserID){
        this.UserID = UserID;
        this.FollowingUserID = FollowingUserID;
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
        UserID = userID;
    }

    public String getFollowingUserID() {
        return FollowingUserID;
    }

    public void setFollowingUserID(String followingUserID) {
        FollowingUserID = followingUserID;
    }
}
