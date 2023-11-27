import Practice.Geometry.Geometry;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import Practice.Geometry.Geometry.Vertex;
import Practice.Geometry.Faces.*;
import Practice.Geometry.Vertices.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
/*  under investigation why pToInject doesn't initialize properly
    @InjectMocks
    private Polygon polygon = new Polygon();
    @Mock
    private Position pToInject = new Position(1.2f,4.5f,-6.7f);
    @BeforeEach
    public void prep(){
        MockitoAnnotations.openMocks(this);
    }
    */
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,15","2,4,6,12","1,1",""})
    public void IntArgs(String nums){
        if(nums.isEmpty()) {
            assertEquals(0, 0);
            return;
        }
        var numStrings = nums.split(",");
        int acc=0;
        for(var d : Arrays.stream(numStrings)
                .limit(numStrings.length-1)
                .map(digit->Integer.parseInt(digit))
                .toArray()
        )
            acc+=((Integer)d).intValue();
        int expected = Integer.parseInt(
                numStrings[numStrings.length-1]
        );
        assertEquals(expected,acc);
    }
}
