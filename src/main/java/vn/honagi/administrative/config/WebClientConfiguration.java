/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
	
	@Value("${vn.honagi.administrative.api.v1.context}")
	private String ap1V1Context;
	
	@Value("${vn.honagi.administrative.api.v2.context}")
	private String ap1V2Context;
	
	
	@Bean(name = "apiv1WebClient")
	public WebClient createApiV1WebClient() {
		return WebClient.create(ap1V1Context);
	}
	
	@Bean(name = "apiv2WebClient")
	public WebClient createApiV2WebClient() {
		return WebClient.create(ap1V2Context);
	}
	
}
