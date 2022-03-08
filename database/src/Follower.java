public class Follower {
    protected int id;
    protected String UserID;
    protected String FollowingUserID;

    public Follower() {
    }

    public Follower(int id) {
        this.id = id;
    }

    public Follower (int id, String UserID, String FollowingUserID){
        this(UserID, FollowingUserID);
        this.id = id;
    }

    public Follower (String UserID, String FollowingUserID){
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
        this.UserID = userID;
    }

    public String getFollowingUserID() {
        return FollowingUserID;
    }

    public void setFollowingUserID(String followingUserID) {
        this.FollowingUserID = followingUserID;
    }
}
