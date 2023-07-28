/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service;

import org.springframework.http.ResponseEntity;

import vn.honagi.administrative.api.DataResponse;

public interface ErrorHandleService {
	
	ResponseEntity<DataResponse> handle(String apiName, Exception e);
	
}
