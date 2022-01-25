package pw.elka.faustyna.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ConfigService {

	public void updateConfig(String config) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/piotr/GitHub/faustyna_backend/src/main/resources/menu.json"));
		writer.write(config);

		writer.close();
	}

}
