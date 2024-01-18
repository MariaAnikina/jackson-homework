package maria.anikina.model.xml;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JacksonXmlRootElement(namespace = "clientFindInfo")
public class ClientFindInfo implements Serializable {
	private Dul dul;
	private int partyId;

	@Override
	public String toString() {
		return "ClientFindInfo{" +
				"dul=" + dul +
				", partyId=" + partyId +
				'}';
	}
}
