package pw.elka.faustyna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MenuConfig {

	private String config;

	public MenuConfig() throws IOException {
		Class clazz = MenuConfig.class;
		InputStream inputStream = clazz.getResourceAsStream("/menu.json");
		config = readFromInputStream(inputStream);
		System.out.println(config);
	}

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

}
