/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api.v2.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.honagi.administrative.api.DataResponse;
import vn.honagi.administrative.api.v2.dto.LicensePlateCollectionResponse;
import vn.honagi.administrative.service.ApiTrafficService;
import vn.honagi.administrative.service.ErrorHandleService;
import vn.honagi.administrative.service.mongo.AllResourceCollectionService;
import vn.honagi.administrative.utils.Constants;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(Constants.API_V2_URL)
public class LicensePlateCollectionController {
	
	private final AllResourceCollectionService service;
	
	private final ApiTrafficService apiTrafficService;
	
	private final ErrorHandleService errorHandleService;
	
	
	@GetMapping(value = "/license-plate", produces = "application/json;charset=UTF-8")
	public ResponseEntity<DataResponse> getLicensePlate() {
		try {
			List<LicensePlateCollectionResponse> licensePlateResponseList = service.getLicensePlate();
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /api/v2/license-plate");
			
			return ResponseEntity.ok(DataResponse.builder()
				.status(HttpStatus.OK.name())
				.result(licensePlateResponseList.size())
				.body(licensePlateResponseList)
				.build());
		} catch (Exception e) {
			log.error("GET /api/v2/license-plate: " + e.getMessage());
			return errorHandleService.handle("GET /api/v2/license-plate", e);
		}
	}
	
	@GetMapping(value = "/license-plate/{license_plate_code}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<DataResponse> getByLicensePlateCode(
			@PathVariable("license_plate_code") String licensePlateCode) {
		try {
			List<LicensePlateCollectionResponse> licensePlateResponseList =
					service.getByLicensePlateCode(licensePlateCode);
			
			if (licensePlateResponseList == null) {
				return new ResponseEntity<>(DataResponse.builder()
					.status(HttpStatus.BAD_REQUEST.name())
					.errorMessage("licensePlateCode must be a number")
					.build(), HttpStatus.BAD_REQUEST);
			}
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /api/v2/license-plate/{license_plate_code}");
			
			return ResponseEntity.ok(DataResponse.builder()
				.status(HttpStatus.OK.name())
				.result(licensePlateResponseList.size())
				.body(licensePlateResponseList)
				.build());
		} catch (Exception e) {
			log.error("GET /api/v2/license-plate/{license_plate_code}: " + e.getMessage());
			return errorHandleService.handle("GET /api/v2/license-plate/{license_plate_code}", e);
		}
	}
}
