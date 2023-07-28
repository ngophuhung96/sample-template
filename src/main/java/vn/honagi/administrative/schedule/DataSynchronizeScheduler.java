/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.schedule;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.honagi.administrative.db.mongo.ApiTrafficCollectionRepository;
import vn.honagi.administrative.db.postgres.ApiTrafficRepository;
import vn.honagi.administrative.model.mongo.ApiTrafficDocument;
import vn.honagi.administrative.model.postgres.ApiTraffic;

@Slf4j
@AllArgsConstructor
@Service
public class DataSynchronizeScheduler {
	
	private final ApiTrafficCollectionRepository mongo;
	
	private final ApiTrafficRepository postgres;
	
	private final ObjectMapper mapper;
	
	
	@Scheduled(cron = "${vn.honagi.administrative.data.synchonization.cronjob}")
	public void execute() {
		try {
			log.info("----- Start Synchronizing Data -----");
			List<ApiTraffic> apiTrafficList = postgres.findAll();
			String result = mapper.writeValueAsString(apiTrafficList);
			
			List<ApiTrafficDocument> apiTrafficDocumentList = mapper.readValue(result, new TypeReference<>() {
			});
			
			mongo.deleteAll();
			mongo.saveAll(apiTrafficDocumentList);
		} catch (JsonProcessingException e) {
			log.error("Synchronize Failed: " + e.getMessage());
		}
	}
}
