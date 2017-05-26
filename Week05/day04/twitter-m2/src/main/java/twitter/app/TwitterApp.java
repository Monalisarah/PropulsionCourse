package twitter.app;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter.domain.Tweet;
import twitter.domain.User;
import twitter.service.TweetService;
import twitter.service.UserServiceTest;

public class TwitterApp {
	public static final Logger logger = LogManager.getLogger(TwitterApp.class);
	
	private static TweetService myTweetService = new TweetService();
	private static UserServiceTest myUserService = new UserServiceTest();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			Operation operation = getOperationFromUser();
			logger.info("operation {}", operation);
			
			switch (operation) {
			case NEW_USER: {
				createNewUser();
				break;
			}
			case DELETE_USER: {
				deleteUser();
				break;
			}
			case FIND_ALL_USERS: {
				findAllUsers();
				break;
			}
			case FIND_USER_BY_ID: {
				findUserById();
				break;
			}
			case FIND_USER_BY_USERNAME: {
				findUserByUsername();
				break;
			}
			case CREATE_NEW_TWEET_FOR_USER: {
				createNewTweetForUser();
				break;
			}
			case DELETE_TWEET: {

				break;
			}
			case FIND_ALL_TWEETS: {
				findAllTweets();
				break;
			}
			case FIND_TWEET_BY_ID: {
				findTweetById();
				break;
			}

			case FIND_ALL_TWEETS_BY_USER_ID: {
				findAllTweetsByUserId();
				break;
			}
			case FIND_ALL_TWEETS_BY_USERNAME: {
				findAllTweetsByUsername();

				break;
			}
			case EXIT: {
				banner("Exiting... 👋");
				System.exit(0);
			}

			default:
				System.err.printf("Unsupported operation: %s%n%n", operation.ordinal());
				break;
			}
		}
	}

	private static void printUser(User user) {
		System.out.println("\tID:      " + user.getId());
		System.out.println("\tFirst Name:      " + user.getFullName());
		System.out.println("\tEmail:       " + user.getEmailAdress());
		System.out.println("------------------------------");

	}
	
	private static void printTweet(Tweet tweet) {
		System.out.println("\tID:      " + tweet.getId());
		System.out.println("\tAuthor:      " + tweet.getAuthor().getUserName());
		System.out.println("\tTweet:       " + tweet.getText());
		System.out.println("------------------------------");

	}

	private static void createNewUser() {
		banner("Create New User");
		prompt("Enter your full name");
		String fullName = scanner.nextLine();
		prompt("Enter your Email Adress");
		String emailAdress = scanner.nextLine();
		prompt("Enter your user name");
		String userName = scanner.nextLine();
		prompt("Enter your password");
		String password = scanner.nextLine();
		User user = new User(fullName, emailAdress, userName, password);
		myUserService.registerNewUser(user);
	}

	private static void deleteUser() {
		banner("Delete User");
		prompt("enter user Id");
		String ID = scanner.nextLine();
		myUserService.deleteUser(ID);
	}

	private static void findAllUsers() {
		banner("Find all users");

		System.out.println();
		List<User> users = myUserService.findAllUsers();
		if (users.isEmpty()) {
			System.out.println("No users.");
		} else {
			users.forEach(TwitterApp::printUser);
		}
	}

	private static void findUserById() {
		banner("Finding user by ID");
		prompt("enter user Id");
		String ID = scanner.nextLine();
		System.out.println();
		User user = myUserService.findUserById(ID);
		if (user == null) {
			System.err.println("Could not find customer with ID: " + ID);
		} else {
			printUser(user);
		}

	}

	private static void findUserByUsername() {
		banner("Finding user by Username");
		prompt("enter username");
		String username = scanner.nextLine();
		User user = myUserService.findUserByUsername(username);
		if (user == null) {
			System.err.println("Could not find customer with username: " + username);
		} else {
			printUser(user);
		}
	}

	private static void createNewTweetForUser() {
		banner("Creating new Tweet for User");
		prompt("enter your username");
		String username = scanner.nextLine();

		prompt("enter your tweet");
		String text = scanner.nextLine();

		User author = myUserService.findUserByUsername(username);
		Tweet tweet = new Tweet(text, author);
		myTweetService.saveTweet(tweet);
	}
	
	private static void deleteTweet() {
        banner("Delete tweet");

        prompt("Tweet-ID");
        String tweetId = scanner.nextLine();

        myTweetService.deleteTweet(tweetId);

        // We assume the customer got deleted, but we don’t
        // actually know if the operation succeeded.
        // For example, if there is no such customer, the
        // BankService doesn’t inform us of that. :disappointed:
        System.out.println("Deleted tweet with ID: " + tweetId);
    }
	
	private static void findAllTweets() {
		banner("Find all Tweets");

		System.out.println();
		List<Tweet> tweets = myTweetService.findAllTweets();
		if (tweets.isEmpty()) {
			System.out.println("No tweets.");
		} else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}
	
	private static void findTweetById() {
		banner("Finding Tweet by ID");
		prompt("enter Tweet Id");
		String ID = scanner.nextLine();
		System.out.println();
		Tweet tweet = myTweetService.findTweet(ID);
		if (tweet == null) {
			System.err.println("Could not find tweet with ID: " + ID);
		} else {
			printTweet(tweet);
		}
	}
	
	private static void findAllTweetsByUserId() {
		banner("Finding Tweets by user ID");
		prompt("enter User Id");
		String ID = scanner.nextLine();
		System.out.println();
		User user = myUserService.findUserById(ID);
		if (user == null) {
			System.err.println("Could not find user with ID: " + ID);
		} else {
			List<Tweet> tweets = myTweetService.findAllTweetsByUserId(ID);
			if (tweets.isEmpty()) {
				System.out.println("No tweets.");
			} else {
				tweets.forEach(TwitterApp::printTweet);
			}
			
		}
	}
	
	private static void findAllTweetsByUsername(){
		banner("Finding Tweets by username");
		prompt("enter Username");
		String username = scanner.nextLine();
		System.out.println();
		User user = myUserService.findUserByUsername(username);
		if (user == null) {
			System.err.println("Could not find user with username: " + username);
		} else {
			List<Tweet> tweets = myTweetService.findAllTweetsByUsername(username);
			if (tweets.isEmpty()) {
				System.out.println("No tweets.");
			} else {
				tweets.forEach(TwitterApp::printTweet);
			}
			
		}
	}
	
	
	

	private static Operation getOperationFromUser() {
		banner("Menu");

		while (true) {
			printMenu();
			prompt("Operation");
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				scanner.nextLine();
				Operation operation = Operation.fromOrdinal(input);
				if (operation == null) {
					System.err.println("Invalid operation: " + input);
				} else {
					return operation;
				}
			} else {
				if (scanner.hasNextLine()) {
					System.err.println("Invalid operation: " + scanner.nextLine());
				}
			}
		}
	}

	private static void printMenu() {
		System.out.println();
		for (Operation current : Operation.values()) {
			
			System.out.println(current);
		}
	}

	private static void prompt(String label) {
		System.out.printf("%nEnter %s: ", label);
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
