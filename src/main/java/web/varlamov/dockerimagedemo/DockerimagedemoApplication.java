package web.varlamov.dockerimagedemo;

import java.util.List;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerimagedemoApplication {
	public final static String SERVICE_UUID = getRandomServiceColor();

	private static String getRandomServiceColor() {
		List<String> surname = List.of(
				"cameron",
				"ritchie",
				"tarantino",
				"coen",
				"scorsese"
		);

		List<String> names = List.of(
				"\uD83E\uDD2C",
				"\uD83E\uDD10",
				"\uD83E\uDD13",
				"\uD83D\uDE0E",
				"\uD83E\uDD76"
		);

		Random randomizer = new Random();
		return names.get(randomizer.nextInt(surname.size())) + " " + surname.get(randomizer.nextInt(names.size()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerimagedemoApplication.class, args);
	}

}
