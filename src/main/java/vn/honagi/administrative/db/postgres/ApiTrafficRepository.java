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

import org.springframework.stereotype.Repository;

import vn.honagi.administrative.model.postgres.ApiTraffic;

@Repository
public interface ApiTrafficRepository {
	
	ApiTraffic findByApiName(String apiName);
	
	Long save(ApiTraffic apiTraffic);
	
	Long update(ApiTraffic apiTraffic);
	
	List<ApiTraffic> findAll();
	
}
