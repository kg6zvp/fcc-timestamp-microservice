package enterprises.mccollum.fcc.timestamp;

import java.text.ParseException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author smccollum
 */
@RunWith(JUnit4.class)
public class DateServiceTest {
	DateService ds = new DateService();
	
	@BeforeClass
	public static void before() {
		DateService.setLocaleAndTime(); //perform initialization as the container would
	}

	@Test
	public void testParseDateOnly() throws ParseException {
		assertEquals("Parse epoch", 1451001600000L, ds.getDate("1451001600000").getTime());
		assertEquals("Parse date only string", 1451001600000L, ds.getDate("2015-12-25").getTime());
		assertEquals("Parse date only string to string", "Fri, 25 Dec 2015 00:00:00 GMT", ds.formatDate("2015-12-25").getUtc());
	}

	@Test
	public void testParseAndTimeString() throws ParseException {
		assertEquals("Parse epoch", 1450137600000L, ds.getDate("1450137600000").getTime());
		assertEquals("Parse epoch string to string", "Tue, 15 Dec 2015 00:00:00 GMT", ds.formatDate("1450137600000").getUtc());
	}
}
