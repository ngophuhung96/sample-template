/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.model.mongo;

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
@Document(collection = "api_traffic")
public class ApiTrafficDocument {
	
	@Id
	@JsonIgnore
	private ObjectId id;
	
	@JsonProperty("api_name")
	@Field(name = "api_name")
	private String apiName;
	
	@JsonProperty("total_use")
	@Field(name = "total_use")
	private Integer totalUse;
	
}
