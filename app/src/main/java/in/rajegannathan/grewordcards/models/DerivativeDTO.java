package in.rajegannathan.grewordcards.models;

public class DerivativeDTO {

    private final String relatedWords;

    public DerivativeDTO(String relatedWords) {
        this.relatedWords = relatedWords;
    }

    public String getDisplayText() {
		return relatedWords;
	}

}
