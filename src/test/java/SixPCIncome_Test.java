import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import taxes.FifteenPCProfit;
import taxes.SixPCIncome;

import java.util.stream.Stream;

public class SixPCIncome_Test {
    private Company company;

    @BeforeEach
    public void creation() {
        company = new Company("ООО Ромашка", new SixPCIncome());
    }

    @ParameterizedTest
    @MethodSource("argumentsFor6PCI")
    public void payTaxes6PCIncome(double[] budget, double expected) {

        //act
        for(double i : budget) {
            company.shiftMoney(i);
        }
        double result = company.payTaxes();

        //assert
        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> argumentsFor6PCI() {
        return Stream.of(
                Arguments.of(new double[]{144.432, 42354, 156, -80}, 2559.26592),
                Arguments.of(new double[]{-144.432, -42354, -156, 80}, 4.8)
        );
    }
}
