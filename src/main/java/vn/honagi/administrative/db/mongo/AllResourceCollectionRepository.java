/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.db.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import vn.honagi.administrative.model.mongo.AllResourceDocument;

@Repository
public interface AllResourceCollectionRepository extends MongoRepository<AllResourceDocument, String> {
	
	@Query(value = "{}", fields = "{\"province_code\": 1," +
			"\"province_name\": 1," +
			"\"province_phone_code\": 1," +
			"\"province_license_plate\": 1," +
			"\"province_level\": 1}")
	List<AllResourceDocument> listAllProvinces();
	
	@Query(value = "{\"province_code\": ?0}")
	List<AllResourceDocument> findProvinceByProvinceCode(String provinceCode);
	
	@Query(value = "{\"province_license_plate\": /.*?0.*/}", fields = "{\"province_code\": 1," +
			"\"province_name\": 1," +
			"\"province_license_plate\": 1," +
			"\"province_level\": 1}")
	List<AllResourceDocument> findProvinceByLicensePlateCode(String licensePlateCode);
	
	@Query(value = "{\"province_phone_code\": ?0}", fields = "{\"province_code\": 1," +
			"\"province_name\": 1," +
			"\"province_phone_code\": 1," +
			"\"province_level\": 1}")
	List<AllResourceDocument> findProvinceByPhoneCode(String phoneCode);
	
}
