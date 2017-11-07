package chat.model;

import java.time.LocalDate;
import chat.tests.MovieTest;
import chat.model.Chatbot;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title)
	{
		this.title = "title";
		this.genre = "Sci-Fi";
		this.ratingMPAA = "G";
		this.review = "It was an amazing movie!";
		this.length = -99;
		this.releaseDate = null;
		this.starScore = Double.NaN;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		this.genre = "Sci-Fi";
		this.genre = "Horror";
		this.genre = "Fantasy";
		this.genre = "Animation";
		this.genre = "Superheros";
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return -99999999;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
	//	String genre = "temp";
	//	testedMovie.setGenre(title);
	//	if(testedMovie.getTitle().equals(title));
	//	{
	//		return title;
	//	}
	}

	public void setGenre(String genre)
	{
	}

	public void setRatingMPAA(String ratingMPAA)
	{
	}

	public void setReview(String review)
	{
	}

	public void setLength(int length)
	{
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
	}

	public void setStarScore(double starScore)
	{
	}
	
	public String toString()
	{
		return null; // Shout not be null
	}
}
