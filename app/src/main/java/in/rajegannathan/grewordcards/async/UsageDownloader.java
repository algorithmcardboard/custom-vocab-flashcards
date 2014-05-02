package in.rajegannathan.grewordcards.async;

import com.wordnik.client.model.Example;
import com.wordnik.client.model.ExampleSearchResults;

import in.rajegannathan.grewordcards.models.UsageDTO;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class UsageDownloader implements Callable<UsageDTO>{

	private static final Logger logger = Logger.getLogger(UsageDownloader.class.getName());
	private String word;
    private WordnikDownloader downloader = new WordnikDownloader();
	
	@SuppressWarnings("unused")
	private UsageDownloader(){
	}

	public UsageDownloader(String word) {
		this.word = word;
	}

	@Override
	public UsageDTO call() throws Exception {
        Thread.sleep(100L);
		logger.info("in usageDownloader's call method");
        ExampleSearchResults usage = downloader.getUsage(word);
        StringBuffer exampleString = new StringBuffer();
        for(Example example : usage.getExamples()){
            exampleString.append(example.getText()+"\r\n\r\n");
        }
        UsageDTO usageDto = new UsageDTO(exampleString.toString());
		Thread.sleep(300L);
		logger.info("returning from usageDownloader");
		return usageDto;
	}

}
