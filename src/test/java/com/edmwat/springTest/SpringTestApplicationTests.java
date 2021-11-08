package com.edmwat.springTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTestApplicationTests {
	//under test
	Calculator calc = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {
		//given 
		int a = 28;
		int b =30;
		
		//when
		int result = calc.add(a,b);
		//then
		assertThat(result).isEqualTo(57);
	}

}
class Calculator{
	int add(int a, int b) {
		return a + b;
	}
}
