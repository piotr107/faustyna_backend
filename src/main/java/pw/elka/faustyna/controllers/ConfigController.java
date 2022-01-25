package pw.elka.faustyna.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pw.elka.faustyna.MenuConfig;
import pw.elka.faustyna.services.ConfigService;

@RestController
@RequestMapping(value = "/conf", produces = "application/json")
public class ConfigController {

	@Autowired
	MenuConfig menuConfig;

	@Autowired
	ConfigService configService;

	@GetMapping("/get")
	public ResponseEntity<Object> getConfig() {
		return ResponseEntity.ok(menuConfig.getConfig());
	}

	@PostMapping(value = "/update", consumes = "application/json")
	public ResponseEntity<Object> updateConfig(@RequestBody String config) throws IOException {
		menuConfig.setConfig(config);
		configService.updateConfig(config);
		return ResponseEntity.ok(menuConfig.getConfig());
	}

}
