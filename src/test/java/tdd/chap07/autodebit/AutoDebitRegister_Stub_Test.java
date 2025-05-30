package tdd.chap07.autodebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tdd.chap07.autodebit.CardValidity.INVALID;
import static tdd.chap07.autodebit.CardValidity.VALID;

public class AutoDebitRegister_Stub_Test {

	private AutoDebitRegister register;
	private StubCardNumberValidator stubValidator;
	private StubAutoDebitInfoRepository stubRepository;

	@BeforeEach
	void setUp() {
		stubValidator = new StubCardNumberValidator();
		stubRepository = new StubAutoDebitInfoRepository();
		register = new AutoDebitRegister(stubValidator, stubRepository);
	}

	@Test
	void invalidCard() {
		stubValidator.setInvalidNo("111122223333");

		AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
		RegisterResult result = this.register.register(req);

		assertEquals(INVALID, result.getValidity());
	}

	@Test
	void theftCard() {
		stubValidator.setTheftNo("1234567890123456");

		AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
		RegisterResult result = this.register.register(req);

		assertEquals(CardValidity.THEFT, result.getValidity());
	}

	@Test
	void validCard() {
		AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
		RegisterResult result = this.register.register(req);
		assertEquals(VALID, result.getValidity());
	}
}
