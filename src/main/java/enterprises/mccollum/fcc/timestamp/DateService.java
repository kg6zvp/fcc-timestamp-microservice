package enterprises.mccollum.fcc.timestamp;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.enterprise.context.Dependent;

/**
 * @author kg6zvp
 */
@Dependent
public class DateService {
	public static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";
	
	public static void setLocaleAndTime() {
		Locale.setDefault(Locale.ENGLISH);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	}

	public Date getDate(String dateString) throws ParseException {
		try {
			return new Date(Long.parseLong(dateString));
		} catch(NumberFormatException ex) { /* noop, continue */ }
		ISO8601DateFormat df = new ISO8601DateFormat();
		Date parsedDate = df.parse(dateString);
		return parsedDate;
	}

	public DateOutput formatDate(String dateString) throws ParseException {
		return formatDate(getDate(dateString));
	}

	public DateOutput formatDate(Date dt) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return DateOutput.builder()
			.unix(dt.getTime())
			.utc(df.format(dt))
			.build();
	}
}
