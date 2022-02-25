

public class User {
    protected int id;
    protected String UserID;
    protected String FirstName;
    protected String LastName;
    protected int Age;
    protected int PPAddress;
    protected int PPWallet;
    protected int DollarWallet;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String UserID, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, int DollarWallet) {
        this(UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
        this.id = id;
    }
    
    public User(int id, String UserID, String FirstName, String LastName, int Age, int PPAddress) {
        this(UserID, FirstName, LastName, Age, PPAddress);
        this.id = id;
    }

    public User(String UserID, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, int DollarWallet) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.PPAddress = PPAddress;
        this.PPWallet = PPWallet;
        this.DollarWallet = DollarWallet;
    }
    
    public User(String UserID, String FirstName, String LastName, int Age, int PPAddress) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.PPAddress = PPAddress;
        this.PPWallet = 0;
        this.DollarWallet = 0;
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

    public void setUserID(String name) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPPAddress() {
        return PPAddress;
    }

    public void setPPAddress(int PPAddress) {
        this.PPAddress = PPAddress;
    }

    public int getPPWallet() {
        return PPWallet;
    }

    public void setPPWallet(int PPWallet) {
        this.PPWallet = PPWallet;
    }

    public int getDollarWallet() {
        return DollarWallet;
    }

    public void setDollarWallet(int dollarWallet) {
        DollarWallet = dollarWallet;
    }
}