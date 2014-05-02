package in.rajegannathan.grewordcards.async;

import com.wordnik.client.model.Definition;

import in.rajegannathan.grewordcards.models.MeaningDTO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class MeaningDownloader implements Callable<MeaningDTO>{
	
	private static final Logger logger = Logger.getLogger(MeaningDownloader.class.getName());
	private String word;
	private WordnikDownloader downloader = new WordnikDownloader();

    private static final int NUM_MEANINGS = 3;
	
	@SuppressWarnings("unused")
	private MeaningDownloader(){}

	public MeaningDownloader(String word) {
		this.word = word;
	}

	@Override
	public MeaningDTO call() throws Exception {
		logger.info("in MeaningDownloader.  About to sleep for 300 milliseconds");
        List<Definition> meanings = downloader.getMeaning(this.word, NUM_MEANINGS);
        StringBuilder meaning = new StringBuilder();
        for(Definition defn: meanings){
            logger.info(defn.getText());
            meaning.append(defn.getText()).append("\r\n\r\n");
        }
        MeaningDTO meaningDTO = new MeaningDTO(meaning.toString());
 		logger.info("returning from meaningDownloader");
		return meaningDTO;
	}

}
