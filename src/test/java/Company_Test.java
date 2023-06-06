import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.MethodSource;
import taxes.FifteenPCProfit;

import java.util.Arrays;
import java.util.stream.Stream;

public class Company_Test {

    private Company company;

    @BeforeEach
    public void creationBeforeEach() {
        company = new Company("ООО Ромашка", null);
    }


    @ParameterizedTest
    @MethodSource("argumentsForShiftMoneyIncomeTest")
    public void shiftMoneyIncomeTest(double[] moneySums, double expected) {

        //act
        for (double i : moneySums) {
            company.shiftMoney(i);
        }

        double result = company.getIncome();

        //assert
        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> argumentsForShiftMoneyIncomeTest() {
        return Stream.of(
                Arguments.of(new double[]{144.432, 42354, 156, -80}, 42654.432),
                Arguments.of(new double[]{-144.432, -42354, -156, 80}, 80)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsForShiftMoneyCostsTest")
    public void shiftMoneyCostsTest(double[] moneySums, double expected) {

        //act
        for (double i : moneySums) {
            company.shiftMoney(i);
        }

        double result = company.getCosts();

        //assert
        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> argumentsForShiftMoneyCostsTest() {
        return Stream.of(
                Arguments.of(new double[]{144.432, 42354, 156, -80}, 80),
                Arguments.of(new double[]{-144.432, -42354, -156, 80}, 42654.432)
        );
    }

    @Test
    public void payTaxes15PCWithZeroProfit() {
        //arrange
        company.setTaxMode(new FifteenPCProfit());
        Arrays.stream(new double[]{-144.432, -42354, -156, 80}).forEach((x) -> company.shiftMoney(x));
        double expected = 0;

        //act
        double result = company.payTaxes();

        //assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void payTaxes15PCWithProfit() {
        //arrange
        company.setTaxMode(new FifteenPCProfit());
        Arrays.stream(new double[]{144.432, 42354, 156, -80}).forEach((x) -> company.shiftMoney(x));
        double expected = 6386.1648;

        //act
        double result = company.payTaxes();

        //assert
        Assertions.assertEquals(expected, result);

    }

}
