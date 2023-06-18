package taxes;

public class SixPCIncome extends TaxSystem{

    @Override
    public double calcTax(double income, double costs) {
        return income*0.06;
    }
}
