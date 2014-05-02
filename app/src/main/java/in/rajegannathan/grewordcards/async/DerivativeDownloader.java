package in.rajegannathan.grewordcards.async;

import com.wordnik.client.model.Related;

import in.rajegannathan.grewordcards.models.DerivativeDTO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class DerivativeDownloader implements Callable<DerivativeDTO>{

	private static final Logger logger = Logger.getLogger(DerivativeDownloader.class.getName());
	private String word;
    private WordnikDownloader downloader = new WordnikDownloader();
	
	@SuppressWarnings("unused")
	private DerivativeDownloader(){
	}

	public DerivativeDownloader(String word) {
		this.word = word;
	}

	@Override
	public DerivativeDTO call() throws Exception {
        Thread.sleep(150L);
		logger.info("in derivativedownloader's call");
        List<Related> relatedWords = downloader.getDerivative(word);
        StringBuilder relatedWordsString = new StringBuilder();
        for(Related rel: relatedWords){
            relatedWordsString.append(rel.getRelationshipType());
            for(String relWord: rel.getWords()){
                relatedWordsString.append(relWord + "\r\n");
            }
            relatedWordsString.append("\r\n\r\n");
        }
        DerivativeDTO derivativeDTO = new DerivativeDTO(relatedWordsString.toString());
		Thread.sleep(300L);
		logger.info("returngin from derivativedownloader");
		return derivativeDTO;
	}

}
