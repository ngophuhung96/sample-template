/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api.v2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AllResourceCollectionResponse implements Serializable {
	
	@JsonProperty("province_code")
	private String provinceCode;
	
	@JsonProperty("province_name")
	private String provinceName;
	
	@JsonProperty("province_phone_code")
	private String provincePhoneCode;
	
	@JsonProperty("province_license_plate")
	private String provinceLicensePlate;
	
	@JsonProperty("province_level")
	private Object provinceLevel;
	
	@JsonProperty("districts")
	private List<Map<String, Object>> districts;
	
	
	public AllResourceCollectionResponse() {
		this.districts = new ArrayList<>();
	}
	
}
