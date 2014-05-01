package in.rajegannathan.grewordcards.async;

import com.wordnik.client.api.WordApi;
import com.wordnik.client.common.ApiException;
import com.wordnik.client.model.Definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class WordnikDownloader {
	private static final String API_KEY = "apiKey";
	private WordApi wordApi;
	private static Properties props;
	private static final Logger logger = Logger.getLogger(WordnikDownloader.class.getName());
	
//	static{
//		props = new Properties();
//		try {
//			FileInputStream fn = new FileInputStream("local.properties");
//			props.load(fn);
//		} catch (FileNotFoundException e) {
//			logger.info("no file found");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.info("unable to read file");
//		}
//	}

	public WordnikDownloader(){
		wordApi = new WordApi();
		wordApi.addHeader("api_key", "f202890d818b6b25a3b0e000a700f2032187316965dabaeaf");
	}
	
	public List<Definition> getMeaning(String word, int count){
		List<Definition> definitions = null;
		String partOfSpeech = null;
		String sourceDictionaries = null;
		Integer limit = null;
		String includeRelated = null;
		String useCanonical = null;
		String includeTags = null;
		try {
			definitions = wordApi.getDefinitions(word, partOfSpeech, sourceDictionaries, limit, includeRelated, useCanonical, includeTags);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		if(definitions == null){
			definitions = new ArrayList<Definition>();
		}
		return definitions;
	}
}
