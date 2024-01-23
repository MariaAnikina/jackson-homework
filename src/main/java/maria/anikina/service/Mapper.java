package maria.anikina.service;

import maria.anikina.model.json.FindPersonInfo;
import maria.anikina.model.json.IdentityCard;
import maria.anikina.model.json.PersonInfo;
import maria.anikina.model.json.PersonName;
import maria.anikina.model.xml.ClientInfo;

public class Mapper {
	public static PersonInfo createPersonInfoFromClientInfo(ClientInfo clientInfo) {
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
