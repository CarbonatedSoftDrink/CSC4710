

public class User {
    protected int id;
    protected String UserID;
    protected String Password;
    protected String FirstName;
    protected String LastName;
    protected int Age;
    protected int PPAddress;
    protected int PPWallet;
    protected double DollarWallet;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String UserID, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
        this(UserID, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
        this.id = id;
    }
    
    public User(int id, String UserID, String FirstName, String LastName, int Age, int PPAddress) {
        this(UserID, FirstName, LastName, Age, PPAddress);
        this.id = id;
    }
    
    public User(int id, String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress) {
        this(UserID, Password, FirstName, LastName, Age, PPAddress);
        this.id = id;
    }
    
    public User(int id, String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
    	this(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
    	this.id = id;
    }
    
    public User(String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
    	this.UserID = UserID;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.PPAddress = PPAddress;
        this.PPWallet = PPWallet;
        this.DollarWallet = DollarWallet;
    }
    
    public User(String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress) {
        this.UserID = UserID;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.PPAddress = PPAddress;
        this.PPWallet = 0;
        this.DollarWallet = 1000;
    }

    public User(String UserID, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
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
        this.DollarWallet = 1000;
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

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    public String getPassword() {
    	return Password;
    }
    
    public void setPassword(String Password) {
    	this.Password = Password;
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

    public double getPPWallet() {
        return PPWallet;
    }

    public void setPPWallet(int PPWallet) {
        this.PPWallet = PPWallet;
    }

    public double getDollarWallet() {
        return DollarWallet;
    }

    public void setDollarWallet(int dollarWallet) {
        DollarWallet = dollarWallet;
    }
}