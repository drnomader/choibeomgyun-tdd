package tdd.chap09.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import tdd.chap07.user.DupIdException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserRegisterIntTest {

	@Autowired
	private UserRegister register;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void 동일ID가_이미_존재하면_익셉션() {
		//given
		jdbcTemplate.update("insert into user values (?,?,?) " +
						"on duplicate key update password = ?, email = ?",
				"cbk", "pw", "cbk@cbk.com", "pw", "cbk@cbk.com");

		//when, then
		assertThrows(DupIdException.class,
				() -> register.register("cbk", "strongpw", "email@email.com"));
	}

	@Test
	void 존재하지_않으면_저장함() {
		//given
		jdbcTemplate.update("delete from user where id = ?", "cbk");

		//when
		register.register("cbk", "strongpw", "email@email.com");

		//then
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ?", "cbk");
		assertEquals("email@email.com", rs.getString("email"));
	}
}
