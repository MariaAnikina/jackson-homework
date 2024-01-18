package maria.anikina.model.json;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonInfo {
	@JsonProperty("FindPersonInfo")
	private FindPersonInfo findPersonInfo;
}
