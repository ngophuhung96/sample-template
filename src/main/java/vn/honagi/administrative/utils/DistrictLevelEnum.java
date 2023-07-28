/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DistrictLevelEnum {
	
	@JsonProperty("Quận")
	DISTRICT("0"),
	
	@JsonProperty("Huyện")
	TOWN("1"),
	
	@JsonProperty("Thành phố")
	CITY("2"),
	
	@JsonProperty("Thị xã")
	VILLAGE("3");
	
	
	private final String value;
	
	
	public String getValue() {
		return this.value;
	}
	
	public Byte getByteValue() {
		return Integer.valueOf(this.value).byteValue();
	}
	
	private DistrictLevelEnum(String value) {
		this.value = value;
	}
	
}
