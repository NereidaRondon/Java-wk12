import java.util.Random;
import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	@VisibleForTesting
	int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			int sum = a + b;
			System.out.printf("Add %d + %d = %d \n", a, b, sum);
			return (sum);
		} 
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	
	}
	
	int getRandomInt() {
		  Random random = new Random();
		  int num = random.nextInt(10) + 1;
		  return num;

	}
	@VisibleForTesting
	int randomNumberSquared() {
		int randomNum = getRandomInt();
		System.out.println(randomNum);
		int square = randomNum * randomNum;
		System.out.println(randomNum + " squared " + " = " + square);
		return square;
	}

}
