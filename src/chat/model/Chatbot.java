package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
		buildFollowups();
		buildQuestions();
		
		buildMovieList();
		getUsername();
	}
	
	private void buildVerbs()
	{
		verbs [0] = "like";
		verbs [1] = "dislike";
		verbs [2] = "am ambivalent about";
		verbs [3] = "am thinking about";
	}
	
	private void buildTopics()
	{
		topics [0] = "Movies";
		topics [1] = "Animals";
		topics [2] = "Robots";
		topics [3] = "Family";
		topics [4] = "Food";
		topics [5] = "Songs";
		topics [6] = "Riddles";
	}
	/**
	 * Gives question topics to talk about
	 */
	private void buildFollowups()
	{
		followUps [0] = "What is your favorite movie?" + "\n";
		followUps [1] = "What do you need from the store?" + "\n";
		followUps [2] = "Who is in your family?" + "\n";
		followUps [3] = "What is your favorite animal?" + "\n";
		followUps [4] = "Sing me a song?" + "\n";
		
	}

	/**
	 * Gives the movies it knows
	 */
	private void buildMovieList()	
	{
		movieList.add(new Movie("Your favorite movie "));
		movieList.add(new Movie("Star Wars: The Last Jedi "));
		movieList.add(new Movie("Wonder Woman "));
		movieList.add(new Movie("Thor Ragnorark "));
		movieList.add(new Movie("Spiderman "));
		movieList.add(new Movie("Lego Batman Movie "));
		movieList.add(new Movie("Hidden Figures "));
		movieList.add(new Movie("The Beauty And The Beast "));
		movieList.add(new Movie("Pirates Of The Caribbean: Dead Men Tell No Tales "));
	}
	
	/**
	 * Tells about things in a shopping list
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("slug bait");
		
	}
	
	/**
	 * talks about animals
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	/** 
	 * Asks questions
	 */
	private void buildQuestions()
	{
		questions [0] = "What is your name?" + "\n";
		questions [1] = "Which are cuter? Puppies or kittens?" + "\n";
		questions [2] = "Do you like badgers?" + "\n";
		questions [3] = "Am I a robot?" + "\n";
		questions [4] = "How much wood could a woodchuck chuck if a woodchuck could chuck chucked wood?" + "\n";
		questions [5] = "How many pickled peppers did Peter Piper pick?" + "\n";
		questions [6] = "Is this question false?" + "\n";
		questions [7] = "Are you there or are you square?" + "\n";
		questions [8] = "Is Wheatly your friend?" + "\n";
		questions [9] = "Which is heavier? 200 pounds of bricks? Or 200 pounds of feathers?"+ "\n" + "Wouldn't it be feathers?" + "\n" + "Because you have to carry the weight of what you did to those poor birds, right?";
		
	}
	
	/**
	 * Takes the conversation and builds the response
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		//Time stamp
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";

		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * movieList.size());
		if (random % 2 ==0)
		{
			random = (int) (Math.random()* movieList.size());
			response += movieList.get(random).getTitle() + "is a great movie!" + "\n";
		}	
		
		int followup = (int) (Math.random() * 5);
		switch(followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3: 
			response += followUps[1]	+ "\n";
			break;
		case 1:
			response +=followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		return response;
		
	}
	
	/** 
	 * 
	 * Checks to see how long a list is
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		return validLength;
	}
	/**
	 * 
	 * Checks HTML
	 */
	public boolean inputHTMLChecker(String input)
	{
		boolean containsHTML = false;
		if(input==null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if (input.contains("<>") || input.indexOf("< >") > -1)
				{
					containsHTML = false;
				}
		
		//Check singleton
		if (input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
				{
					containsHTML = true;
				}
		
		//checks others
		else if (firstClose > firstOpen)
		{
			// Others
				tagText = input.substring(firstOpen +1, firstClose).toLowerCase();
				secondOpen = input.toLowerCase().indexOf("</" + tagText,firstClose);
		}
		
		
		return containsHTML;
	}
	
	public boolean userNameChecker(String input)
	{
		return true;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return true;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		int otterCount = 0;
		int flooferCount = 0;
		int kittieCount = 0;
		
		for (String cute : getCuteAnimalMemes())
		{
			if (cute.toLowerCase().contains("otter"))
			{
				otterCount += 1;
			}
			if (cute.toUpperCase().contains("FLOOFER"))
			{
				flooferCount += 1;
			}
			if (cute.toLowerCase().indexOf("kittie") > -1)
			{
				kittieCount += 1;
			}
			return true;
			}
		return false;
		}
		
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		int num = 0;
		while (num < 3)
		{
			if (shoppingList.contains("snacks"))
			{
				num+=1;
			}
			if (shoppingList.contains("veggies"))
			{
				num+=1;
			}
			if (shoppingList.contains("protein"))
			{
				num+=1;
			}
			return true;
		}
			if (shoppingList.contains("slug bait"))
			{
				return false;
			}
			
			return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return true;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return true;
	}

	public boolean quitChecker(String exitString)
	{
		if(lengthChecker(exitString) == true)
		{
			if (exitString.equalsIgnoreCase("quit"))
			{
				return true;
			}
		}
		return false;

	}

	public boolean keyboardMashChecker(String sample)
	{
		return true;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
