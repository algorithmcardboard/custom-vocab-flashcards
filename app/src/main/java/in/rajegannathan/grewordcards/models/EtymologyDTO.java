package in.rajegannathan.grewordcards.models;

public class EtymologyDTO {

    private final String etymologyText;

    public EtymologyDTO(String etymologyText) {
        this.etymologyText = etymologyText;
    }

    public String getDisplayText() {
		return etymologyText;
	}

}
