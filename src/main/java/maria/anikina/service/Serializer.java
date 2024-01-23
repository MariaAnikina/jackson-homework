package maria.anikina.service;

import java.io.File;

public interface Serializer<T> {
	T getFromXMLToObject();

	String createFromObjectJsonAndSaveFile(File file, T object);
}
