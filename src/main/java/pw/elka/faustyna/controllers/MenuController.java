package pw.elka.faustyna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pw.elka.faustyna.MenuConfig;
import pw.elka.faustyna.services.MenuService;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class MenuController {
	
	@Autowired
	MenuConfig menuConfig;
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/menu")
	public ResponseEntity<Object> getMenu() {
		return ResponseEntity.ok(menuConfig.getConfig());
	}
	
	@GetMapping("/news")
	public ResponseEntity<Object> getNews() {
		return ResponseEntity.ok(menuService.getNews());
	}
	
	@GetMapping("/page/{pageId}")
	public ResponseEntity<Object> getPage(@PathVariable String pageId) {
		return ResponseEntity.ok(menuService.getPage(pageId));
	}

}
