package web.varlamov.dockerimagedemo;

import java.util.List;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerimagedemoApplication {
	public final static String SERVICE_UUID = getRandomServiceColor();

	private static String getRandomServiceColor() {
		List<String> colors = List.of(
				"#175E54",
				"#279989",
				"#A6B168",
				"#E98300",
				"#F4795B",
				"#FFE781",
				"#C74632",
				"#FEC51D",
				"#DAD7CB",
				"#8F993E"
		);

		Random randomizer = new Random();
		return colors.get(randomizer.nextInt(colors.size()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerimagedemoApplication.class, args);
	}

}
