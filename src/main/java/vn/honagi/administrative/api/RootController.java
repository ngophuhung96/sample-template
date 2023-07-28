/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import vn.honagi.administrative.service.ApiTrafficService;

@Slf4j
@AllArgsConstructor
@RestController
public class RootController {
	
	private final ApiTrafficService apiTrafficService;
	
	
	@ApiIgnore
	@GetMapping(value = {
		"/",
		"/api",
		"/api/v1",
		"/api/v2"
	}, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> index() {
		// Update traffic
		apiTrafficService.updateTraffic("GET /");
		return ResponseEntity.ok("{\"status\": \"operational\"}");
	}
	
}
