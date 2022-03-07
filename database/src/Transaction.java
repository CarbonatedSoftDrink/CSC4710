public class Transaction {
    protected int id;
    protected int SenderAddress;
    protected int ReceiverAddress;
    protected double PPAmount;
    protected double DollarAmount;

    public Transaction(int id) {
        this.id = id;
    }

    public Transaction(int id, int SenderAddress, int ReceiverAddress, double PPAmount, double DollarAmount) {
        this(SenderAddress, ReceiverAddress, PPAmount, DollarAmount);
        this.id = id;
    }

    public Transaction(int SenderAddress, int ReceiverAddress, double PPAmount, double DollarAmount) {
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

    public int getSenderAddress() {
        return SenderAddress;
    }

    public void setSenderAddress(int senderAddress) {
        SenderAddress = senderAddress;
    }

    public int getReceiverAddress() {
        return ReceiverAddress;
    }

    public void setReceiverAddress(int receiverAddress) {
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
