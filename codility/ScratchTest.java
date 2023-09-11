import java.util.stream.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class ScratchTest {
    @ParameterizedTest
    @MethodSource("ints")
    public void Task1(int[] maxGuestsPerRoom, int expected){
        assertEquals(expected,
                Scratch.minRoomsNeeded(maxGuestsPerRoom));
    }
    static Stream<Arguments> ints(){
        return Stream.of(
                Arguments.of( new int[]{1,1,1,1,1},5),
                Arguments.of(new int[]{2,1,4},2),
                Arguments.of(new int[]{2,7,2,9,8},2),
                Arguments.of(new int[]{7,3,1,1,4,5,4,9},4)
        );
    }
    @ParameterizedTest
    @MethodSource("ints2")

    public void Task2(int[] A, int expected){
        assertEquals(expected,Scratch.arrangeBasketballs(A));
    }
    static Stream<Arguments> ints2(){
        return Stream.of(
                Arguments.of( new int[]{6,4,1,7,10},2),
                Arguments.of(new int[]{1,3,6},1),
                Arguments.of(new int[]{17,21,22,30},2)
        );
    }

    @ParameterizedTest
    @MethodSource("strings")
    public void Task3(String input, int expected){
        assertEquals(
                expected,
                Scratch.countLowerBeforeUpper(input)
        );
    }
    private static Stream<Arguments> strings(){
        return Stream.of(
                Arguments.of("aaAbcCABBc",2),
                Arguments.of("xyzXYZabcABC",6),
                Arguments.of("ABCabcAefG",0)
        );
    }
}
