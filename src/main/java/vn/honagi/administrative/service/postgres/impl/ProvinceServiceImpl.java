/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.postgres.impl;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.postgresql.util.PGobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

import vn.honagi.administrative.api.v1.dto.ProvinceResponse;
import vn.honagi.administrative.api.v1.dto.WardResponse;
import vn.honagi.administrative.db.postgres.ProvinceRepository;
import vn.honagi.administrative.model.postgres.MstProvince;
import vn.honagi.administrative.service.postgres.ProvinceService;
import vn.honagi.administrative.utils.CommonUtils;
import vn.honagi.administrative.utils.Constants;

@AllArgsConstructor
@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	private final ProvinceRepository provinceRepository;
	
	private final ObjectMapper mapper;
	
	
	@Override
	public List<ProvinceResponse> getProvinces() throws JsonProcessingException {
		List<MstProvince> mstProvinceList = provinceRepository.listAllProvince();
		String result = mapper.writeValueAsString(mstProvinceList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
	@Cacheable(cacheNames = Constants.FIND_PROVINCE_BY_PROVINCE_CODE_FROM_POSTGRES_DB)
	@Override
	public List<ProvinceResponse> getProvinceByProvinceCode(String provinceCode)
			throws JsonProcessingException {
		
		Preconditions.checkNotNull(provinceCode, "provinceCode must not be null");
		if (CommonUtils.parseStringToInt(provinceCode) == null) {
			return null;
		}
		
		// Get province by province_code
		Map<String, PGobject> response = provinceRepository.findProvinceByProvinceCode(provinceCode);
		PGobject object = response.get(Constants.JSON_RESPONSE);
		List<ProvinceResponse> responseList = mapper.readValue(object.getValue(), new TypeReference<>() {
		});
		responseList.forEach(provinceResponse -> provinceResponse.getDistricts()
			.forEach(districtResponse -> districtResponse.getWards().forEach(WardResponse::setVillages)));
		return responseList;
	}
	
}
