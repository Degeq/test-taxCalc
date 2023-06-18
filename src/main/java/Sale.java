public class Sale extends Deal {

    public Sale(String comment, double debit, String staffName) {
        super(comment, 0, debit, staffName);
        System.out.println("Продажа товара " + staffName + " на сумму: " + debit + " рублей" );
    }
}
