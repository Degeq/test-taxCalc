import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import taxes.FifteenPCProfit;

import java.util.Arrays;
import java.util.stream.Stream;

public class FifteenPCProfit_Test {

    private Company company;

    @BeforeEach
    public void creation() {
        company = new Company("ООО Ромашка", new FifteenPCProfit());
    }

    @ParameterizedTest
    @MethodSource("argumentsFor15PCP")
    public void payTaxes15PCProfit(double[] budget, double expected) {

        //act
        for(double i : budget) {
            company.shiftMoney(i);
        }
        double result = company.payTaxes();

        //assert
        Assertions.assertEquals(expected, result);

    }

    public static Stream<Arguments> argumentsFor15PCP() {
        return Stream.of(
                Arguments.of(new double[]{144.432, 42354, 156, -80}, 6386.1648),
                Arguments.of(new double[]{-144.432, -42354, -156, 80}, 0)
        );
    }
}
