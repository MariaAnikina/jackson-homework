package maria.anikina.model.xml;

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
//@JacksonXmlRootElement(localName = "dul")
public class Dul  implements Serializable {
	private int documentType;
	private String firstName;
	private String lastName;
	private String secondName;
	private int number;
	private int series;

	@Override
	public String toString() {
		return "Dul{" +
				"documentType=" + documentType +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", secondName='" + secondName + '\'' +
				", number=" + number +
				", series=" + series +
				'}';
	}
}
