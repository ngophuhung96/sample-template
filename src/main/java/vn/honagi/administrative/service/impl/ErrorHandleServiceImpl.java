/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.exception.ExceptionUtils;

import vn.honagi.administrative.api.DataResponse;
import vn.honagi.administrative.db.mongo.ErrorLogCollectionRepository;
import vn.honagi.administrative.model.mongo.ErrorLogDocument;
import vn.honagi.administrative.service.ErrorHandleService;

@Slf4j
@AllArgsConstructor
@Service
public class ErrorHandleServiceImpl implements ErrorHandleService {
	
	private final ErrorLogCollectionRepository logCollectionRepository;
	
	private static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
	
	@Override
	public ResponseEntity<DataResponse> handle(String apiName, Exception e) {
		log.info(String.format("----- Handling error for %s -----", apiName));
		
		String errorLog = ExceptionUtils.getStackTrace(e);
		log.error(String.format("----- Stack Trace: %s -----", errorLog));
		Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
		String timestamp = new SimpleDateFormat(DATE_TIME_FORMAT).format(currentTimestamp);
		
		try {
			logCollectionRepository.save(ErrorLogDocument.builder()
				.timestamp(timestamp)
				.apiName(apiName)
				.errorLog(errorLog)
				.build());
		} catch (Exception ex) {
			log.error("Error occurred with MongoDB connection: " + ex.getMessage());
		}
		
		return new ResponseEntity<>(DataResponse.builder()
			.status(HttpStatus.INTERNAL_SERVER_ERROR.name())
			.errorMessage("An error occurred.")
			.build(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
