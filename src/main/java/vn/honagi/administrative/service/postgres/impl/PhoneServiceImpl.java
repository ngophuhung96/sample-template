/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.postgres.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

import vn.honagi.administrative.api.v1.dto.PhoneResponse;
import vn.honagi.administrative.db.postgres.ProvinceRepository;
import vn.honagi.administrative.model.postgres.MstProvince;
import vn.honagi.administrative.service.postgres.PhoneService;
import vn.honagi.administrative.utils.CommonUtils;
import vn.honagi.administrative.utils.Constants;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	@Resource(name = "apiv1WebClient")
	private WebClient webClient;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<PhoneResponse> getPhones() throws JsonProcessingException {
		var getProvinceResponse = webClient
			.get()
			.uri("/province")
			.retrieve()
			.bodyToMono(Map.class)
			.block(Constants.REQUEST_TIMEOUT);
		
		if (getProvinceResponse != null) {
			String result = mapper.writeValueAsString(getProvinceResponse.get(Constants.BODY));
			return mapper.readValue(result, new TypeReference<>() {
			});
		}
		
		return Collections.emptyList();
	}
	
	@Cacheable(cacheNames = Constants.FIND_PROVINCE_BY_PROVINCE_PHONE_CODE_FROM_POSTGRES_DB)
	@Override
	public List<PhoneResponse> getByPhoneCode(String phoneCode) throws JsonProcessingException {
		Preconditions.checkNotNull(phoneCode, "phoneCode must not be null");
		if (CommonUtils.parseStringToInt(phoneCode) == null) {
			return null;
		}
		
		List<MstProvince> mstProvinceList = provinceRepository.findProvinceByPhoneCode(phoneCode);
		String result = mapper.writeValueAsString(mstProvinceList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
}
