/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.model.postgres;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_traffic")
public class ApiTraffic implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;
	
	@NotNull
	@Length(max = 255)
	@JsonProperty("api_name")
	private String apiName;
	
	@NotNull
	@JsonProperty("total_use")
	private Integer totalUse;
	
}
