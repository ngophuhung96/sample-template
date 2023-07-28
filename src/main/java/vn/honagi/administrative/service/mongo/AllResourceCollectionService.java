/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.mongo;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.honagi.administrative.api.v2.dto.AllResourceCollectionResponse;
import vn.honagi.administrative.api.v2.dto.LicensePlateCollectionResponse;
import vn.honagi.administrative.api.v2.dto.PhoneCollectionResponse;

public interface AllResourceCollectionService {
	
	List<AllResourceCollectionResponse> listAllResources() throws JsonProcessingException;
	
	List<AllResourceCollectionResponse> listAllProvinces() throws JsonProcessingException;
	
	List<AllResourceCollectionResponse> findProvinceByProvinceCode(String provinceCode) throws JsonProcessingException;
	
	List<LicensePlateCollectionResponse> getLicensePlate() throws JsonProcessingException;
	
	List<LicensePlateCollectionResponse> getByLicensePlateCode(String licensePlateCode) throws JsonProcessingException;
	
	List<PhoneCollectionResponse> getPhones() throws JsonProcessingException;
	
	List<PhoneCollectionResponse> getByPhoneCode(String phoneCode) throws JsonProcessingException;
	
}
