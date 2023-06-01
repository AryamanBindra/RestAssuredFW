package tekarch.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataUtils {
	public static String readJsonFileAsString(String jsonFilePath) throws IOException {
		
		byte[] contents = Files.readAllBytes(Paths.get(jsonFilePath));
		
		return new String(contents, StandardCharsets.UTF_8);
	}
}
