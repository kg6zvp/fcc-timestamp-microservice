package enterprises.mccollum.fcc.timestamp;

import java.text.ParseException;
import java.util.Date;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author kg6zvp
 */
@Path("/timestamp")
@Produces(MediaType.APPLICATION_JSON)
public class TimestampEndpoint {
	@Inject
	DateService dateService;

	@GET
	public DateOutput getCurrentDate() {
		return dateService.formatDate(new Date());
	}

	@GET
	@Path("/{fmt_str}")
	public Response getDate(@PathParam("fmt_str") String inputDateStr) {
		try {
			return Response.ok(dateService.formatDate(inputDateStr)).build();
		} catch (ParseException ex) {
			return Response.serverError()
				.entity(Json.createObjectBuilder()
					.add("error", "Invalid Date").build().toString())
				.build();
		}
	}
}
