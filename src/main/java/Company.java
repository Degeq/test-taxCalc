import taxes.TaxSystem;

public class Company {
    protected String title;
    protected double income = 0;
    protected double costs = 0;
    protected TaxSystem taxMode;

    public Company(String title, TaxSystem taxMode) {
        this.title = title;
        this.taxMode = taxMode;
    }

    public void shiftMoney(double amount) {
        if (amount >= 0) {
            income = income + amount;
        } else {
            costs = costs + Math.abs(amount);
        }
    }

    public void setTaxMode (TaxSystem taxMode) {
        this.taxMode = taxMode;
    }

    public Double getCosts() {
        return costs;
    }

    public Double payTaxes() {
        double taxSize = taxMode.calcTax(income, costs);
        if (taxSize > 0) {
            System.out.println("Компания " + title + " уплатила налог в размере: " + taxSize);
        } else {
            System.out.println("Компания " + title + " уплатила налог в размере: 0");
        }
        income = 0;
        costs = 0;

        return taxSize;
    }

    public void applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            income = income + deal.getDebit();
            costs = costs + deal.getCredit();
        }
    }

    public Double getIncome() {
        return income;
    }


}

