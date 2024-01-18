package maria.anikina.service;

import java.io.File;

public interface Mapper<T> {
	T getFromXMLToObject();

	String createFromObjectJsonAndSaveFile(File file, T object);
}
