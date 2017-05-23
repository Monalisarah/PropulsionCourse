package twitter.app;



enum Operation {

	NEW_USER("Create a new user"),
	DELETE_USER("Delete a user"),
	FIND_ALL_USERS("Find all users"),
	FIND_USER_BY_ID("Find user by ID"),
	FIND_USER_BY_USERNAME("Find user by username"),
	CREATE_NEW_TWEET_FOR_USER("Create new tweet for user"),
	DELETE_TWEET("Delete a tweet"),
	FIND_ALL_TWEETS("Find all tweets"),
	FIND_TWEET_BY_ID("Find tweet by ID"),
	FIND_ALL_TWEETS_BY_USER_ID("Find all tweets by user ID"),
	FIND_ALL_TWEETS_BY_USERNAME("Find all tweets by username"),
	EXIT("Exiting Tweet App");
	
	private final String displayText;

	private Operation(String displayText) {
		this.displayText = displayText;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", ordinal(), this.displayText);
	}
	
	static Operation fromOrdinal(int ordinal) {
		for (Operation operation : values()) {
			if (operation.ordinal() == ordinal) {
				return operation;
			}
		}
		return null;
	}
	
	
}
