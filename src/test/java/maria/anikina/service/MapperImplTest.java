package maria.anikina.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import maria.anikina.model.xml.ClientFindInfo;
import maria.anikina.model.xml.ClientInfo;
import maria.anikina.model.xml.Dul;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class MapperImplTest {
	private Serializer<ClientInfo> mapper;
	private ClientInfo clientInfoClone;

	@BeforeEach
	void init() {
		mapper = new SerializerImpl(new ObjectMapper(), new XmlMapper());
		clientInfoClone = new ClientInfo(new ClientFindInfo(
				new Dul(99, "firstName", "lastName", "secondName",
						645354, 6200), 32));
	}

	@Test
	void getFromXMLToObject_whenCorrectWork_thenReturnClientInfo() {
		ClientInfo clientInfoClone = new ClientInfo(new ClientFindInfo(
				new Dul(99, "firstName", "lastName", "secondName",
						645354, 6200), 32));
		ClientInfo clientInfo = mapper.getFromXMLToObject();

		assertAll(
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getFirstName(),
						clientInfo.getClientFindInfo().getDul().getFirstName()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getLastName(),
						clientInfo.getClientFindInfo().getDul().getLastName()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getSecondName(),
						clientInfo.getClientFindInfo().getDul().getSecondName()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getSeries(),
						clientInfo.getClientFindInfo().getDul().getSeries()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getNumber(),
						clientInfo.getClientFindInfo().getDul().getNumber()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getDul().getDocumentType(),
						clientInfo.getClientFindInfo().getDul().getDocumentType()),
				() -> assertEquals(clientInfoClone.getClientFindInfo().getPartyId(),
						clientInfo.getClientFindInfo().getPartyId())
		);
	}

	@Test
	void createFromObjectJsonAndSaveFile__whenCorrectWork_thenReturnPersonInfoJson() {
		File file = new File("PersonInfo.json");
		String personInfoJson = mapper.createFromObjectJsonAndSaveFile(file, clientInfoClone);

		assertEquals(personInfoJson, "{\"PersonInfo\":{\"FindPersonInfo\":{\"PersonName\":{\"LastName\":\"lastName\"," +
				"\"FirstName\":\"firstName\",\"MiddleName\":\"secondName\"},\"IdentityCard\":{\"IdType\":99,\"IdSeries\"" +
				":6200,\"IdNum\":645354},\"PartyID\":32}}}");
		assertTrue(file.exists());
	}
}