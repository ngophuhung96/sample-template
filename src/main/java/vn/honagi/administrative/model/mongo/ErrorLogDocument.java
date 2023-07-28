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

import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "error_logs")
public class ErrorLogDocument {
	
	@Id
	@JsonIgnore
	private ObjectId id;
	
	@JsonProperty("timestamp")
	@Field(name = "timestamp")
	private String timestamp;
	
	@JsonProperty("api_name")
	@Field(name = "api_name")
	private String apiName;
	
	@JsonProperty("error_log")
	@Field(name = "error_log")
	private String errorLog;
	
}
