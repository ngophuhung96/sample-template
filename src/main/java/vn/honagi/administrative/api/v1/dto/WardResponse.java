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
import java.util.stream.Collectors;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.honagi.administrative.utils.WardLevelEnum;

@Data
public class WardResponse implements Serializable {
	
	@JsonProperty("ward_code")
	private String wardCode;
	
	@JsonProperty("ward_name")
	private String wardName;
	
	@JsonProperty("ward_level")
	private WardLevelEnum wardLevel;
	
	@JsonProperty("villages")
	private List<String> villages;
	
	@JsonProperty(value = "villages_temp", access = JsonProperty.Access.WRITE_ONLY)
	private List<VillageResponse> villagesTemp;
	
	
	public WardResponse() {
		this.villages = new ArrayList<>();
	}
	
	public void setVillages() {
		this.villages = this.villagesTemp.stream()
			.map(VillageResponse::getVillageName)
			.collect(Collectors.toList());
	}
}
