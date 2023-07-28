/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.utils;

import java.time.Duration;

public class Constants {
	
	public static final String API_V1_URL = "/api/v1";
	
	public static final String API_V2_URL = "/api/v2";
	
	public static final String CONDITION_DELIMITER = ",";
	
	public static final String BODY = "body";
	
	public static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5);
	
	public static final String JSON_RESPONSE = "json_agg";
	
	public static final String FIND_ALL_FROM_POSTGRES_DB = "findAllFromPostgresDB";
	
	public static final String FIND_PROVINCE_BY_PROVINCE_PHONE_CODE_FROM_POSTGRES_DB =
			"findProvinceByProvincePhoneCodeFromPostgresDB";
	
	public static final String FIND_PROVINCE_BY_PROVINCE_LICENSE_PLATE_CODE_FROM_POSTGRES_DB =
			"findProvinceByProvinceLicensePlateCodeFromPostgresDB";
	
	public static final String FIND_PROVINCE_BY_PROVINCE_CODE_FROM_POSTGRES_DB =
			"findProvinceByProvinceCodeFromPostgresDB";
	
	public static final String FIND_ALL_FROM_MONGO_DB = "findAllFromMongoDB";
	
	public static final String LIST_ALL_PROVINCE_FROM_MONGO_DB = "listAllProvinceFromMongoDB";
	
	public static final String FIND_PROVINCE_BY_PROVINCE_CODE_FROM_MONGO_DB = "findProvinceByProvinceCodeFromMongoDB";
	
	public static final String FIND_PROVINCE_BY_LICENSE_PLATE_CODE_FROM_MONGO_DB =
			"findProvinceByLicensePlateCodeFromMongoDB";
	
	public static final String FIND_PROVINCE_BY_PROVINCE_PHONE_CODE_FROM_MONGO_DB =
			"findProvinceByProvincePhoneCodeFromMongoDB";
	
}
