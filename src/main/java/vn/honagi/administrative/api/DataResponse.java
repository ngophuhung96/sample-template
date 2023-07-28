/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.api;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
public class DataResponse {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("error_message")
	private String errorMessage;
	
	@JsonProperty("result")
	private Integer result;
	
	@JsonProperty("body")
	private Object body;
	
}
