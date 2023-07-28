/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.impl;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import vn.honagi.administrative.db.postgres.ApiTrafficRepository;
import vn.honagi.administrative.model.postgres.ApiTraffic;
import vn.honagi.administrative.service.ApiTrafficService;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class ApiTrafficServiceImpl implements ApiTrafficService {
	
	private final ApiTrafficRepository apiTrafficRepository;
	
	private static final Integer INCREASE_BY_ONE = 1;
	
	
	@Override
	public Long updateTraffic(String apiName) {
		Preconditions.checkNotNull(apiName, "api_name must not be null");
		log.info("Update Traffic For: " + apiName);
		
		ApiTraffic apiTraffic = apiTrafficRepository.findByApiName(apiName);
		if (apiTraffic == null) {
			apiTraffic = ApiTraffic.builder()
				.apiName(apiName)
				.totalUse(INCREASE_BY_ONE)
				.build();
			return apiTrafficRepository.save(apiTraffic);
		} else {
			apiTraffic.setTotalUse(apiTraffic.getTotalUse() + INCREASE_BY_ONE);
			return apiTrafficRepository.update(apiTraffic);
		}
	}
	
}
