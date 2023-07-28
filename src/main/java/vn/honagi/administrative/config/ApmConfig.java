/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import co.elastic.apm.attach.ElasticApmAttacher;

@Component
public class ApmConfig {
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@Value("${elastic.apm.enabled}")
	private Boolean isApmEnable;
	
	@Value("${elastic.apm.server-url}")
	private String apmServerUrl;
	
	@Value("${elastic.apm.environment}")
	private String apmEnvironment;
	
	@Value("${elastic.apm.application-packages}")
	private String apmPackage;
	
	@Value("${elastic.apm.log-level}")
	private String apmLogLevel;
	
	private static final String SERVER_URL_KEY = "server_url";
	
	private static final String SERVICE_NAME_KEY = "service_name";
	
	private static final String ENVIRONMENT_KEY = "environment";
	
	private static final String APPLICATION_PACKAGES_KEY = "application_packages";
	
	private static final String LOG_LEVEL_KEY = "log_level";
	
	
	@Bean
	public void inItApmProperties() {
		if (this.isApmEnable != null && !this.isApmEnable) {
			return;
		}
		
		Map<String, String> apmProperties = new HashMap<>(5);
		apmProperties.put(SERVER_URL_KEY, this.apmServerUrl);
		apmProperties.put(SERVICE_NAME_KEY, this.serviceName);
		apmProperties.put(ENVIRONMENT_KEY, apmEnvironment);
		apmProperties.put(APPLICATION_PACKAGES_KEY, apmPackage);
		apmProperties.put(LOG_LEVEL_KEY, apmLogLevel);
		
		ElasticApmAttacher.attach(apmProperties);
	}
	
}
