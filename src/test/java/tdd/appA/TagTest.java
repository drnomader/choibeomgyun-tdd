package tdd.appA;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration")
public class TagTest {

	@Tag("very-slow")
	@org.junit.jupiter.api.Test
	void verySlow() {
		int result = someVerySlowOp();
		assertEquals(result, 0);
	}

	@Tag("slow")
	@org.junit.jupiter.api.Test
	void slow() {
		int result = someVerySlowOp();
		assertEquals(result, 0);
	}

	private int someVerySlowOp() {
		return 0;
	}

	@Test
	void normal() {
		assertEquals("abc", "abc".substring(0, 3));
	}
}
