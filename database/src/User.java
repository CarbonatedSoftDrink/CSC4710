import java.io.Serializable;

public class User implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String birthday;
    private Integer streetnumber;
    private String street;
    private String city;
    private String state;
    private Integer zipcode;
    private Integer ppsbalance;
    private Double bankbalance;
    private Integer ppaddress;
    
    public User(int id, String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
    	this(UserID, Password, FirstName, LastName, Age, PPAddress, PPWallet, DollarWallet);
    	this.id = id;
    }
    
    public User(String UserID, String Password, String FirstName, String LastName, int Age, int PPAddress, int PPWallet, double DollarWallet) {
    	this.username = UserID;
    	this.password = Password;
    	this.firstname = FirstName;
    	this.lastname = LastName;
    	this.age = Age;
    	this.ppaddress = PPAddress;
    	this.ppsbalance = PPWallet;
    	this.bankbalance = DollarWallet;
    }
    
    public User(int id, String username, String password, String firstname, String lastname, String birthday, int streetnumber, String street, String city, String state, int zipcode, int ppsbalance, double bankbalance, int ppsaddress) {
    	this.id = id;
    	this.username = username;
    	this.password = password;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.birthday = birthday;
    	this.streetnumber = streetnumber;
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zipcode = zipcode;
    	this.ppsbalance = ppsbalance;
    	this.bankbalance = bankbalance;
    	this.ppaddress = ppaddress;
    }
    
    public User(String username, String password, String firstname, String lastname, String birthday, int ppaddress) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.birthday = birthday;
		this.ppaddress = ppaddress;
		this.ppsbalance = 0;
		this.bankbalance = 1000.0;
	}

	public Integer getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(Integer streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getPpsbalance() {
		return ppsbalance;
	}

	public void setPpsbalance(Integer ppsbalance) {
		this.ppsbalance = ppsbalance;
	}

	public double getBankbalance() {
		return bankbalance;
	}

	public void setBankbalance(double bankbalance) {
		this.bankbalance = bankbalance;
	}

	public Integer getPpaddress() {
		return ppaddress;
	}

	public void setPpaddress(Integer ppaddress) {
		this.ppaddress = ppaddress;
	}
	
	public int getAge() {
		return ppaddress;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}