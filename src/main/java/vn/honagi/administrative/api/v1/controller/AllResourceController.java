/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api.v1.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.honagi.administrative.api.DataResponse;
import vn.honagi.administrative.api.v1.dto.ProvinceResponse;
import vn.honagi.administrative.service.ApiTrafficService;
import vn.honagi.administrative.service.ErrorHandleService;
import vn.honagi.administrative.service.postgres.AllResourceService;
import vn.honagi.administrative.utils.Constants;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(Constants.API_V1_URL)
public class AllResourceController {
	
	private final AllResourceService service;
	
	private final ApiTrafficService apiTrafficService;
	
	private final ErrorHandleService errorHandleService;
	
	
	@GetMapping(value = "/all", produces = "application/json;charset=UTF-8")
	public ResponseEntity<DataResponse> getAllResource() {
		try {
			List<ProvinceResponse> responseList = service.listAllResource();
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /api/v1/all");
			
			return ResponseEntity.ok(DataResponse.builder()
				.status(HttpStatus.OK.name())
				.result(responseList.size())
				.body(responseList)
				.build());
		} catch (Exception e) {
			log.error("GET /api/v1/all: " + e.getMessage());
			return errorHandleService.handle("GET /api/v1/all", e);
		}
	}
}
