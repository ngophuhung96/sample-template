/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.postgres;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.honagi.administrative.api.v1.dto.ProvinceResponse;

public interface ProvinceService {
	
	List<ProvinceResponse> getProvinces() throws JsonProcessingException;
	
	List<ProvinceResponse> getProvinceByProvinceCode(String provinceCode) throws JsonProcessingException;
	
}
