package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		Class<RichSoilLand> myClass = RichSoilLand.class;
		while (!"HARVEST".equals(line)){
			if("all".equals(line)){
				Arrays.stream(myClass.getDeclaredFields()).
						forEach(field -> System.out.println(String.format("%s %s %s"
								,Modifier.toString(field.getModifiers())
								,field.getType().getSimpleName()
								,field.getName())));

			}else {
				String finalLine = line;
				Arrays.stream(myClass.getDeclaredFields()).filter(field -> Modifier.toString(field.getModifiers()).equals(finalLine))
						.forEach(field -> System.out.println(String.format("%s %s %s"
						,Modifier.toString(field.getModifiers())
						,field.getType().getSimpleName()
						,field.getName())));
			}

			line = scanner.nextLine();
		}
	}
}
