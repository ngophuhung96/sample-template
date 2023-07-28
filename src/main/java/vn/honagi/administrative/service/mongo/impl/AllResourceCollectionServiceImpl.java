/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.mongo.impl;

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

import vn.honagi.administrative.api.v2.dto.AllResourceCollectionResponse;
import vn.honagi.administrative.api.v2.dto.LicensePlateCollectionResponse;
import vn.honagi.administrative.api.v2.dto.PhoneCollectionResponse;
import vn.honagi.administrative.db.mongo.AllResourceCollectionRepository;
import vn.honagi.administrative.model.mongo.AllResourceDocument;
import vn.honagi.administrative.service.mongo.AllResourceCollectionService;
import vn.honagi.administrative.utils.CommonUtils;
import vn.honagi.administrative.utils.Constants;

@Service
public class AllResourceCollectionServiceImpl implements AllResourceCollectionService {
	
	@Resource(name = "apiv2WebClient")
	private WebClient webClient;
	
	@Autowired
	private AllResourceCollectionRepository allResourceRepository;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Cacheable(cacheNames = Constants.FIND_ALL_FROM_MONGO_DB)
	@Override
	public List<AllResourceCollectionResponse> listAllResources() throws JsonProcessingException {
		List<AllResourceDocument> allResourceEntityList = allResourceRepository.findAll();
		String result = mapper.writeValueAsString(allResourceEntityList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
	@Cacheable(cacheNames = Constants.LIST_ALL_PROVINCE_FROM_MONGO_DB)
	@Override
	public List<AllResourceCollectionResponse> listAllProvinces() throws JsonProcessingException {
		List<AllResourceDocument> allResourceEntityList = allResourceRepository.listAllProvinces();
		String result = mapper.writeValueAsString(allResourceEntityList);
		List<AllResourceCollectionResponse> responseList = mapper.readValue(result, new TypeReference<>() {
		});
		responseList.forEach(response -> response.setDistricts(Collections.emptyList()));
		return responseList;
	}
	
	@Cacheable(cacheNames = Constants.FIND_PROVINCE_BY_PROVINCE_CODE_FROM_MONGO_DB)
	@Override
	public List<AllResourceCollectionResponse> findProvinceByProvinceCode(String provinceCode)
			throws JsonProcessingException {
		Preconditions.checkNotNull(provinceCode, "provinceCode must not be null");
		if (CommonUtils.parseStringToInt(provinceCode) == null) {
			return null;
		}
		
		List<AllResourceDocument> allResourceEntityList =
				allResourceRepository.findProvinceByProvinceCode(provinceCode);
		String result = mapper.writeValueAsString(allResourceEntityList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
	@Override
	public List<LicensePlateCollectionResponse> getLicensePlate() throws JsonProcessingException {
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
	
	@Cacheable(cacheNames = Constants.FIND_PROVINCE_BY_LICENSE_PLATE_CODE_FROM_MONGO_DB)
	@Override
	public List<LicensePlateCollectionResponse> getByLicensePlateCode(String licensePlateCode)
			throws JsonProcessingException {
		Preconditions.checkNotNull(licensePlateCode, "licensePlateCode must not be null");
		if (CommonUtils.parseStringToInt(licensePlateCode) == null) {
			return null;
		}
		
		List<AllResourceDocument> mstProvinceList =
				allResourceRepository.findProvinceByLicensePlateCode(licensePlateCode);
		String result = mapper.writeValueAsString(mstProvinceList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
	@Override
	public List<PhoneCollectionResponse> getPhones() throws JsonProcessingException {
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
	
	@Cacheable(cacheNames = Constants.FIND_PROVINCE_BY_PROVINCE_PHONE_CODE_FROM_MONGO_DB)
	@Override
	public List<PhoneCollectionResponse> getByPhoneCode(String phoneCode) throws JsonProcessingException {
		Preconditions.checkNotNull(phoneCode, "phoneCode must not be null");
		if (CommonUtils.parseStringToInt(phoneCode) == null) {
			return null;
		}
		
		List<AllResourceDocument> mstProvinceList = allResourceRepository.findProvinceByPhoneCode(phoneCode);
		String result = mapper.writeValueAsString(mstProvinceList);
		return mapper.readValue(result, new TypeReference<>() {
		});
	}
	
}
