package in.rajegannathan.grewordcards.async;

import in.rajegannathan.grewordcards.models.EtymologyDTO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class EtymologyDownloader implements Callable<EtymologyDTO>{

	private static final Logger logger = Logger.getLogger(EtymologyDownloader.class.getName());
	private String word;
    private WordnikDownloader downloader = new WordnikDownloader();
	
	@SuppressWarnings("unused")
	private EtymologyDownloader(){
	}

	public EtymologyDownloader(String word) {
		this.word = word;
	}

	@Override
	public EtymologyDTO call() throws Exception {
        Thread.sleep(100L);
		logger.info("in Etymologydownloaader's call method");
        List<String> etymologies = downloader.getEtymology(word);
        StringBuilder etymologyText = new StringBuilder();
        for(String ety: etymologies){
            etymologyText.append(ety).append("\r\n\r\n");
        }
        EtymologyDTO etymologyDTO = new EtymologyDTO(etymologyText.toString());
		Thread.sleep(300L);
		logger.info("returning from etymologydownloader");
		return etymologyDTO;
	}

}
