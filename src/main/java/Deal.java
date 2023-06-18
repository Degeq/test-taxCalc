public abstract class Deal {

    protected String comment;
    protected double credit;
    protected double debit;
    protected String staffName;

    public Deal(String comment, double credit, double debit, String staffName) {
        this.comment = comment;
        this.credit = credit;
        this.debit = debit;
        this.staffName = staffName;
    }

    public double getCredit() {
        return credit;
    }

    public double getDebit() {
        return debit;
    }
}
