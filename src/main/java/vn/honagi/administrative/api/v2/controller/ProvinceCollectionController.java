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
import vn.honagi.administrative.api.v2.dto.AllResourceCollectionResponse;
import vn.honagi.administrative.service.ApiTrafficService;
import vn.honagi.administrative.service.ErrorHandleService;
import vn.honagi.administrative.service.mongo.AllResourceCollectionService;
import vn.honagi.administrative.utils.Constants;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(Constants.API_V2_URL)
public class ProvinceCollectionController {
	
	private final AllResourceCollectionService service;
	
	private final ApiTrafficService apiTrafficService;
	
	private final ErrorHandleService errorHandleService;
	
	
	@GetMapping(value = "/province", produces = "application/json;charset=UTF-8")
	public ResponseEntity<DataResponse> getProvinces() {
		try {
			List<AllResourceCollectionResponse> mstProvinceList = service.listAllProvinces();
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /api/v2/province");
			
			return ResponseEntity.ok(DataResponse.builder()
				.status(HttpStatus.OK.name())
				.result(mstProvinceList.size())
				.body(mstProvinceList)
				.build());
		} catch (Exception e) {
			log.error("GET /api/v2/province: " + e.getMessage());
			return errorHandleService.handle("GET /api/v2/province", e);
		}
	}
	
	@GetMapping(value = "/province/{province_code}", produces = "application/json;charset=UTF-8")
	public ResponseEntity<DataResponse> getProvinceByProvinceCode(@PathVariable("province_code") String provinceCode) {
		try {
			List<AllResourceCollectionResponse> mstProvinceList =
					service.findProvinceByProvinceCode(provinceCode);
			
			if (mstProvinceList == null) {
				return new ResponseEntity<>(DataResponse.builder()
					.status(HttpStatus.BAD_REQUEST.name())
					.errorMessage("provinceCode must be a number")
					.build(), HttpStatus.BAD_REQUEST);
			}
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /api/v2/province/{province_code}");
			
			return ResponseEntity.ok(DataResponse.builder()
				.status(HttpStatus.OK.name())
				.result(mstProvinceList.size())
				.body(mstProvinceList)
				.build());
		} catch (Exception e) {
			log.error("GET /api/v2/province/{province_code}: " + e.getMessage());
			return errorHandleService.handle("GET /api/v2/province/{province_code}", e);
		}
	}
}
