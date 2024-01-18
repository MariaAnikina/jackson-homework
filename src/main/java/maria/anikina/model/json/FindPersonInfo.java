package maria.anikina.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindPersonInfo {
	@JsonProperty("PersonName")
	private PersonName personName;
	@JsonProperty("IdentityCard")
	private IdentityCard identityCard;
	@JsonProperty("PartyID")
	private int partyID;
}
