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

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Entity
@Table(name = "mst_districts")
public class MstDistrict implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("district_id")
	private Integer districtId;
	
	@NotNull
	@JsonProperty("province_id")
	private Integer provinceId;
	
	@Length(max = 3)
	@JsonProperty("district_code")
	private String districtCode;
	
	@NotNull
	@Length(max = 255)
	@JsonProperty("district_name")
	private String districtName;
	
	@JsonProperty("district_level")
	private Byte districtLevel;
	
}
