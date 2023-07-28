/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.db.postgres;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;
import org.postgresql.util.PGobject;

import vn.honagi.administrative.model.postgres.MstProvince;

@Repository
public interface ProvinceRepository {
	
	List<MstProvince> listAllProvince();
	
	Map<String, PGobject> findProvinceByProvinceCode(@Param("provinceCode") String provinceCode);
	
	List<MstProvince> findProvinceByPhoneCode(@Param("phoneCode") String phoneCode);
	
	List<MstProvince> findProvinceByLicensePlateCode(@Param("licensePlateCode") String licensePlateCode);
	
}
