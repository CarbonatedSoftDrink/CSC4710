public class Transaction {
    protected int id;
    protected String SenderAddress;
    protected String ReceiverAddress;
    protected double PPAmount;
    protected double DollarAmount;

    public Transaction(int id) {
        this.id = id;
    }

    public Transaction(int id, String SenderAddress, String ReceiverAddress, double PPAmount, double DollarAmount) {
        this(SenderAddress, ReceiverAddress, PPAmount, DollarAmount);
        this.id = id;
    }

    public Transaction(String SenderAddress, String ReceiverAddress, double PPAmount, double DollarAmount) {
        this.SenderAddress = SenderAddress;
        this.ReceiverAddress = ReceiverAddress;
        this.PPAmount = PPAmount;
        this.DollarAmount = DollarAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderAddress() {
        return SenderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        SenderAddress = senderAddress;
    }

    public String getReceiverAddress() {
        return ReceiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        ReceiverAddress = receiverAddress;
    }

    public double getPPAmount() {
        return PPAmount;
    }

    public void setPPAmount(double PPAmount) {
        this.PPAmount = PPAmount;
    }

    public double getDollarAmount() {
        return DollarAmount;
    }

    public void setDollarAmount(double dollarAmount) {
        DollarAmount = dollarAmount;
    }
}
