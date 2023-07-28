/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api.v1.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.honagi.administrative.utils.DistrictLevelEnum;

@Data
public class DistrictResponse implements Serializable {
	
	@JsonProperty("district_code")
	private String districtCode;
	
	@JsonProperty("district_name")
	private String districtName;
	
	@JsonProperty("district_level")
	private DistrictLevelEnum districtLevel;
	
	@JsonProperty("wards")
	private List<WardResponse> wards;
	
	
	public DistrictResponse() {
		this.wards = new ArrayList<>();
	}
}
