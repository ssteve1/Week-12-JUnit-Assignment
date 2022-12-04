package my.unit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {
    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("my.unit.test.TestDemoTest#argumentsForAddPositive")
    void asserThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException  ){

       // Given: Two positive integers

        if(!expectException){
            // When: the integers are added
            // Then: the expected value is return
            assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
        }else{
            // When: the integers are added
            // Then: the expected value is return
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }
    static Stream<Arguments> argumentsForAddPositive(){
        // formatter:off
        return Stream.of(
                arguments(2,4,6,false)

        );
        // formatter:on

    }

    @Test
    void assertThatNumberSquaredIsCorrect(){
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }

}