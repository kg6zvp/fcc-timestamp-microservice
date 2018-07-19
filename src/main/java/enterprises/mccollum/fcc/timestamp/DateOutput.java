package enterprises.mccollum.fcc.timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kg6zvp
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DateOutput {
	@Getter @Setter long unix;

	@Getter @Setter String utc;
}
