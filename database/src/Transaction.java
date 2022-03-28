import java.sql.Timestamp;

public class Transaction {
    protected int id;
    protected String fromuser;
    protected String touser;
    protected double ppsamt;
    protected double dollaramt;
    protected Timestamp when;
    protected String transtype;
    protected Double price;

    public Transaction(int id) {
        this.id = id;
    }

    public Transaction(int id, String fromuser, String touser, double ppsamt, double dollaramt, Timestamp when, String transtype, Double price) {
        this(fromuser, touser, ppsamt, dollaramt, when, transtype, dollaramt);
        this.id = id;
    }

    public Transaction(String fromuser, String touser, double ppsamt, double dollaramt, Timestamp when, String transtype, Double price) {
        this.fromuser = fromuser;
        this.touser = touser;
        this.ppsamt = ppsamt;
        this.dollaramt = dollaramt;
        this.when = when;
        this.transtype = transtype;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromuser() {
        return fromuser;
    }

    public void setFromuser(String fromuser) {
    	this.fromuser = fromuser;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
    	this.touser = touser;
    }

    public double getPpsamt() {
        return ppsamt;
    }

    public void setPpsamt(double ppsamt) {
        this.ppsamt = ppsamt;
    }

    public double getDollaramt() {
        return dollaramt;
    }

    public void setDollaramt(double dollaramt) {
    	this.dollaramt = dollaramt;
    }
    
    public Timestamp getWhen() {
    	return when;
    }
    
    public void setWhen(Timestamp when) {
    	this.when = when;
    }
    
    public String getTranstype() {
    	return transtype;
    }
    
    public void setTranstype(String transtype) {
    	this.transtype = transtype;
    }
    
    public Double getPrice() {
    	return price;
    }
    
    public void setPrice(Double price) {
    	this.price = price;
    }
}
