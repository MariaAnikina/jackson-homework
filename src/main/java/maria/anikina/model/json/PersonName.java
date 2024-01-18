package maria.anikina.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonName {
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("MiddleName")
	private String middleName;
}
