package enterprises.mccollum.fcc.timestamp;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author kg6zvp
 */
@Startup
@Singleton
public class TimeZoneInitializer {
	@PostConstruct
	public void onInit() {
		DateService.setLocaleAndTime();
	}
}
