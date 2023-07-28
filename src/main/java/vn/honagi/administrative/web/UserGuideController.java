/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import vn.honagi.administrative.service.ApiTrafficService;

@Slf4j
@Controller
public class UserGuideController {
	
	@Value("${vn.honagi.administrative.user.guide.path}")
	private String videoPath;
	
	@Autowired
	private ApiTrafficService apiTrafficService;
	
	@Autowired
	private ResourceHandler handler;
	
	
	@GetMapping(value = "/guide", produces = "video/mp4")
	public void playUserGuide(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			File video = new File(videoPath);
			
			// Update traffic
			apiTrafficService.updateTraffic("GET /guide");
			
			request.setAttribute(ResourceHandler.ATTRIBUTE_FILE, video);
			handler.handleRequest(request, response);
		} catch (Exception e) {
			log.error("GET /guide: " + e.getMessage());
		}
	}
	
	
	@Component
	static final class ResourceHandler extends ResourceHttpRequestHandler {
		
		private static final String ATTRIBUTE_FILE = ResourceHandler.class.getName() + ".file";
		
		
		@Override
		protected Resource getResource(HttpServletRequest request) {
			
			final File file = (File) request.getAttribute(ATTRIBUTE_FILE);
			return new FileSystemResource(file);
		}
	}
	
}
