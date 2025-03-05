package tdd.appD;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ThrownTest {

	@Test
	void thrownBy() {
		assertThatThrownBy(
				() -> readFile(new File("nofile.txt")))
				.isInstanceOf(IOException.class);
	}

	@Test
	void exceptionOfType() {
		assertThatExceptionOfType(IOException.class)
				.isThrownBy(() -> {
					readFile(new File("nofile.txct"));
				});
	}

	@Test
	void exceptionOfIOException() {
		assertThatIOException()
				.isThrownBy(() -> {
					readFile(new File("nofile.txct"));
				});
	}

	@Test
	void noThrown() {
		assertThatCode(() -> {
			readFile(new File("README.md"));
		}).doesNotThrowAnyException();
	}

	List<String> readFile(File file) throws IOException {
		return Files.readAllLines(Paths.get(file.toURI()));
	}
}
