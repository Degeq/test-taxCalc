package taxes;

public class FifteenPCProfit extends TaxSystem {

    @Override
    public double calcTax(double income, double costs) {
        if ((income - costs) < 0) {
            return 0;
        }
        return (income-costs)*0.15;
    }
}
