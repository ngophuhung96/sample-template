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
@Table(name = "mst_provinces")
public class MstProvince implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("province_id")
	private Integer provinceId;
	
	@NotNull
	@Length(max = 2)
	@JsonProperty("province_code")
	private String provinceCode;
	
	@NotNull
	@Length(max = 3)
	@JsonProperty("province_phone_code")
	private String provincePhoneCode;
	
	@NotNull
	@Length(max = 255)
	@JsonProperty("province_license_plate")
	private String provinceLicensePlate;
	
	@NotNull
	@Length(max = 255)
	@JsonProperty("province_name")
	private String provinceName;
	
	@NotNull
	@JsonProperty("province_level")
	private Byte provinceLevel;
	
}
