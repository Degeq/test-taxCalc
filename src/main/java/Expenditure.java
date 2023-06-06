public class Expenditure extends Deal {

    public Expenditure(String comment, double credit, String staffName) {
        super(comment, credit, 0, staffName);
        System.out.println("Покупка товара " + staffName + " на сумму: " + credit + " рублей" );
    }

}
