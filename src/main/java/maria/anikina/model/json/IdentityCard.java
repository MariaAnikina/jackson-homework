package maria.anikina.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityCard {
	@JsonProperty("IdType")
	private int idType;
	@JsonProperty("IdSeries")
	private int idSeries;
	@JsonProperty("IdNum")
	private int idNum;
}
