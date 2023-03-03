import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


//@ExtendWith(MockitoExtension.class)
class TestDemoTest {
	//instance variable
	private  TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		//Create testDemo object
		testDemo = new TestDemo();
		
	}

	@ParameterizedTest
	// package # source method
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		// Given: two numbers a and b
		// When: the two numbers are added
		
		if(!expectException) {
			// If: an exception IS NOT expected
			// Then: the numbers are added
			
			//assertThat (class . method (parameters)) . isEqualto (expected parameter)
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			
		} else {
			// If: an exception IS expected
			// Then: the correct exception is thrown
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}

	}
    static Stream<Arguments> argumentsForAddPositive() {
    	return Stream.of(
    			//arguments ( a , b , expected value, expected result)
    			arguments(8, 4, 12, false),
    			arguments(-1 ,-5, -6, true),
    			arguments(-1, 2, 1, true),
    			arguments(0, 3, 3, true),
    			arguments(0, 0, 0, true)
    	);
    }
        
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// for spy, I'm telling it which method to test
		TestDemo mockDemo = spy(testDemo);
		// replace getRandomInt with 5 for mock demo 
		doReturn(5).when(mockDemo).getRandomInt();
		// get the result from mock randomNumberSquared and save it as a variable
		int fiveSquared = mockDemo.randomNumberSquared();
		//make certain that the result is equal to the expected value
		assertThat(fiveSquared).isEqualTo(25);
	}
	    
}
