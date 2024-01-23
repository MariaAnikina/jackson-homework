package maria.anikina.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import maria.anikina.model.json.PersonInfo;
import maria.anikina.model.xml.ClientInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@AllArgsConstructor
public class SerializerImpl implements Serializer<ClientInfo> {

	private ObjectMapper objectMapper;
	private XmlMapper xmlMapper;

	@Override
	public ClientInfo getFromXMLToObject() {
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
		PersonInfo personInfo = Mapper.createPersonInfoFromClientInfo(clientInfo);
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
}
