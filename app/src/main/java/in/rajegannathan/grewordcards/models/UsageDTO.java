package in.rajegannathan.grewordcards.models;

public class UsageDTO {

    private final String exampleString;

    public UsageDTO(String exampleString) {
        this.exampleString = exampleString;
    }

    public String getDisplayText() {
		return exampleString;
	}

}
