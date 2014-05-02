package in.rajegannathan.grewordcards.async;

import com.wordnik.client.api.WordApi;
import com.wordnik.client.common.ApiException;
import com.wordnik.client.model.Definition;
import com.wordnik.client.model.ExampleSearchResults;
import com.wordnik.client.model.Related;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class WordnikDownloader {
	private WordApi wordApi;
	private static final Logger logger = Logger.getLogger(WordnikDownloader.class.getName());

	public WordnikDownloader(){
		wordApi = new WordApi();
		wordApi.getInvoker().addDefaultHeader("api_key", "f202890d818b6b25a3b0e000a700f2032187316965dabaeaf");
	}
	
	public List<Definition> getMeaning(String word, int count){
		List<Definition> definitions = null;
		String partOfSpeech = null;
		String sourceDictionaries = null;
		int limit = count;
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

    public List<String> getEtymology(String word) {
        List<String> etymologies = null;
        try {
            etymologies = wordApi.getEtymologies(word, null);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        if(etymologies == null){
            etymologies = new ArrayList<String>();
        }
        return etymologies;
    }

    public List<Related> getDerivative(String word){
        int limitPerRelationshipType = 3;
        String relationshipTypes = null;
        String useCanonical = null;
        List<Related> relatedWords = null;
        try {
            relatedWords = wordApi.getRelatedWords(word, relationshipTypes, useCanonical, limitPerRelationshipType);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        if(relatedWords == null){
            relatedWords = new ArrayList<Related>();
        }
        return relatedWords;
    }

    public ExampleSearchResults getUsage(String word) {
        ExampleSearchResults examples = null;
        String includeDuplicates = "false";
        String useCanonical = null;
        int limit = 3;
        int skip = 0;
        try {
            examples = wordApi.getExamples(word, includeDuplicates, useCanonical, skip, limit);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        if(examples == null){
            examples = new ExampleSearchResults();
        }
        return examples;
    }
}
