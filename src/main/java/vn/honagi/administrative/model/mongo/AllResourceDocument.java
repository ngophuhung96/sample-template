/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.model.mongo;

import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Document(collection = "all_resources")
public class AllResourceDocument {
	
	@Id
	@JsonIgnore
	private ObjectId id;
	
	@JsonProperty("province_code")
	@Field(name = "province_code")
	private String provinceCode;
	
	@JsonProperty("province_name")
	@Field(name = "province_name")
	private String provinceName;
	
	@JsonProperty("province_phone_code")
	@Field(name = "province_phone_code")
	private String provincePhoneCode;
	
	@JsonProperty("province_license_plate")
	@Field(name = "province_license_plate")
	private String provinceLicensePlate;
	
	@JsonProperty("province_level")
	@Field(name = "province_level")
	private Object provinceLevel;
	
	@JsonProperty("districts")
	@Field(name = "districts")
	private List<Map<String, Object>> districts;
	
}
