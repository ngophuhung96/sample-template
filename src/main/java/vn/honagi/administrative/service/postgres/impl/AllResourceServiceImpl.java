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

import vn.honagi.administrative.api.v1.dto.ProvinceResponse;
import vn.honagi.administrative.api.v1.dto.WardResponse;
import vn.honagi.administrative.db.postgres.AllResourceRepository;
import vn.honagi.administrative.service.postgres.AllResourceService;
import vn.honagi.administrative.utils.Constants;

@AllArgsConstructor
@Service
public class AllResourceServiceImpl implements AllResourceService {
	
	private final AllResourceRepository allResourceRepository;
	
	private final ObjectMapper mapper;
	
	
	@Cacheable(cacheNames = Constants.FIND_ALL_FROM_POSTGRES_DB)
	@Override
	public List<ProvinceResponse> listAllResource() throws JsonProcessingException {
		Map<String, PGobject> response = allResourceRepository.listAllResource();
		PGobject object = response.get(Constants.JSON_RESPONSE);
		List<ProvinceResponse> responseList = mapper.readValue(object.getValue(), new TypeReference<>() {
		});
		responseList.forEach(provinceResponse -> provinceResponse.getDistricts()
			.forEach(districtResponse -> districtResponse.getWards().forEach(WardResponse::setVillages)));
		return responseList;
	}
	
}
