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
@Table(name = "mst_wards")
public class MstWard implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ward_id")
	private Integer wardId;
	
	@NotNull
	@JsonProperty("district_id")
	private Integer districtId;
	
	@Length(max = 5)
	@JsonProperty("ward_code")
	private String wardCode;
	
	@NotNull
	@Length(max = 255)
	@JsonProperty("ward_name")
	private String wardName;
	
	@JsonProperty("ward_level")
	private Byte wardLevel;
	
}
