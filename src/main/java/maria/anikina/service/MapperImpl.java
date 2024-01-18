package maria.anikina.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import maria.anikina.model.json.FindPersonInfo;
import maria.anikina.model.json.IdentityCard;
import maria.anikina.model.json.PersonInfo;
import maria.anikina.model.json.PersonName;
import maria.anikina.model.xml.ClientFindInfo;
import maria.anikina.model.xml.ClientInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@AllArgsConstructor
public class MapperImpl implements Mapper<ClientInfo> {

	private ObjectMapper objectMapper;
	private XmlMapper xmlMapper;

	@Override
	public ClientInfo getFromXMLToObject( ) {
		ClientInfo clientInfo;
		try {
			String readContent = new String(Files.readAllBytes(Paths.get("ClientInfo.xml")));
			clientInfo = xmlMapper.readValue(readContent, ClientInfo.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return clientInfo;
	}

	@Override
	public String createFromObjectJsonAndSaveFile(File file, ClientInfo clientInfo) {
		PersonInfo personInfo = createPersonInfoFromClientInfo(clientInfo);
		String personInfoJson;
		try {
			objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
			objectMapper.writeValue(file, personInfo);
			personInfoJson = objectMapper.writeValueAsString(personInfo);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return personInfoJson;
	}

	public PersonInfo createPersonInfoFromClientInfo(ClientInfo clientInfo) {
		int partyId = clientInfo.getClientFindInfo().getPartyId();
		IdentityCard identityCard = IdentityCard.builder()
				.idType(clientInfo.getClientFindInfo().getDul().getDocumentType())
				.idNum(clientInfo.getClientFindInfo().getDul().getNumber())
				.idSeries(clientInfo.getClientFindInfo().getDul().getSeries())
				.build();
		PersonName personName = PersonName.builder()
				.firstName(clientInfo.getClientFindInfo().getDul().getFirstName())
				.lastName(clientInfo.getClientFindInfo().getDul().getLastName())
				.middleName(clientInfo.getClientFindInfo().getDul().getSecondName())
				.build();
		FindPersonInfo findPersonInfo = FindPersonInfo.builder()
				.personName(personName)
				.identityCard(identityCard)
				.partyID(partyId)
				.build();
		return PersonInfo.builder()
				.findPersonInfo(findPersonInfo)
				.build();
	}

}
