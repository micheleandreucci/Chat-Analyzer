package services;

import java.util.Map;

public class OpenFile {

	public Map<String, String> openFile(String fileName) {
		UnzipFile zip = new UnzipFile();
		Map<String, String> file = zip.unzip(fileName);
		return file;
	}

}
