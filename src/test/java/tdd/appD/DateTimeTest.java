package tdd.appD;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DateTimeTest {

	@Test
	void ignoring() {
		LocalDateTime time = LocalDateTime.of(2019, 7, 31, 19, 30, 31, 123);

		Assertions.assertThat(time).isEqualToIgnoringNanos(
				LocalDateTime.of(2019, 7, 31, 19, 30, 31, 456)
		);
		Assertions.assertThat(time).isEqualToIgnoringSeconds(
				LocalDateTime.of(2019, 7, 31, 19, 30, 39)
		);
		Assertions.assertThat(time).isEqualToIgnoringMinutes(
				LocalDateTime.of(2019, 7, 31, 19, 10)
		);
		Assertions.assertThat(time).isEqualToIgnoringHours(
				LocalDateTime.of(2019, 7, 31, 15, 10)
		);
	}
}
