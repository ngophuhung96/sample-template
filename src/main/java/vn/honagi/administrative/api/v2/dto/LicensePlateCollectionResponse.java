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

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.honagi.administrative.utils.ProvinceLevelEnum;

@Data
public class LicensePlateCollectionResponse implements Serializable {
	
	@JsonProperty("province_code")
	private String provinceCode;
	
	@JsonProperty("province_name")
	private String provinceName;
	
	@JsonProperty("province_license_plate")
	private String provinceLicensePlate;
	
	@JsonProperty("province_level")
	private ProvinceLevelEnum provinceLevel;
}
