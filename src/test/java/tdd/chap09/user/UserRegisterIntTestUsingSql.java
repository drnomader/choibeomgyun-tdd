package tdd.chap09.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.jdbc.Sql;
import tdd.chap07.user.DupIdException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Sql("classpath:init-data.sql")
public class UserRegisterIntTestUsingSql {

	@Autowired
	private UserRegister register;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void 동일ID가_이미_존재하면_익셉션() {
		//when, then
		assertThrows(DupIdException.class,
				() -> register.register("cbk", "strongpw", "email@email.com"));
	}

	@Test
	void 존재하지_않으면_저장함() {
		//when
		register.register("cbk2", "strongpw", "email@email.com");

		//then
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ?", "cbk2");
		rs.next();
		assertEquals("email@email.com", rs.getString("email"));
	}
}
