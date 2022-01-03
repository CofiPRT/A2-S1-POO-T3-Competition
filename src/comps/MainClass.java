package comps;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import enums.*;
import factories.*;
import teams.*;

/**
 * Main class of the project, containing the 'main' method.
 * @author Rares
 *
 */
public class MainClass {
	public static Scanner inputStream;
	public static PrintStream outputStream;
	public static PrintStream console;
	
	public static ArrayList<Team> teams;
	public static Competition competition;
	
	/**
	 * Opens a new stream to use as input
	 * @param fileName	The name of the file
	 */
	public static void setInputStream(String fileName) {
		if (inputStream != null) {
			// close the previous stream
			inputStream.close();
		}
		
		try {
			inputStream = new Scanner(new File(fileName));
		}
		catch (Exception exc) {
			restoreIO();
			System.out.println(exc + "Exception in setInput");
		}
	}
	
	/**
	 * Open a new stream to use as output
	 * @param fileName	The name of the file
	 */
	public static void setOutputStream(String fileName) {
		if (outputStream != null) {
			// close the previous stream
			outputStream.close();
		}
		try {
			outputStream = new PrintStream(new File(fileName));
		}
		catch (Exception exc) {
			restoreIO();
			System.out.println(exc + "Exception in setOutput");
		}
	}
	
	/** 
	 * Initializes input and output streams and saves
	 * @param inFileName	File to use as input stream
	 * @param outFileName	File to use as output stream
	 */
	public static void setupIO(String inFileName, String outFileName) {
		setInputStream(inFileName);
		setOutputStream(outFileName);
		
		// backup the console if necessary
		if (console == null) {
			console = System.out;
		}
		
		// set the new output stream
		System.setOut(outputStream);
	}
	
	/**
	 * Closes input and output streams
	 */
	public static void restoreIO() {
		if (inputStream != null) {
			inputStream.close();
		}
		
		if (outputStream != null) {
			outputStream.close();
		}
		
		// restore console if necessary
		if (console != null) {
			System.setOut(console);
		}
	}

	/**
	 * Reads from the current input stream the teams and players, according
	 * to the task
	 */
	public static void registerTeams() {
		teams = new ArrayList<Team>();
		inputStream.useDelimiter("\\s*,\\s*|(\\n)|(\\r\\n)");
			// comma surrounded by 0 or more whitespaces
			// newline
			// carriage return and newline
		
		TeamBuilder teamBuilder = TeamBuilder.getInstance();
		PlayerBuilder playerBuilder = PlayerBuilder.getInstance();
		
		while (inputStream.hasNext()) {
			// read a new team
			Team newTeam = teamBuilder
					.build(TeamType.translate(inputStream.next()))
					.withTeamName(inputStream.next())
					.withGender(Gender.translate(inputStream.next()))
					.withNumberOfPlayers(inputStream.nextInt())
					.finish();
			
			// Scanner clutter
			if (inputStream.hasNextLine()) {
				inputStream.nextLine();
			}
			
			// prepare to read the players
			ArrayList<Player> players = new ArrayList<Player>();
			
			// read the players
			for (int i = 0; i < newTeam.getNumberOfPlayers(); i++) {
				// read individual player
				Player newPlayer = playerBuilder
						.build()
						.withName(inputStream.next())
						.withScore(inputStream.nextInt())
						.finish();
				
				// add the player to the player list
				players.add(newPlayer);
				
				// Scanner clutter
				if (inputStream.hasNextLine()) {
					inputStream.nextLine();
				}
			}
			
			// assign the player list to the team
			newTeam.setPlayers(players);
			
			// register the team to the team list
			teams.add(newTeam);
		}
	}
	
	/**
	 * Writes to the current output stream the teams and players, according
	 * to the task
	 */
	public static void listTeams() {
		for (Team currTeam : teams) {
			// use toString
			System.out.println(currTeam);
		}
	}
	
	public static void registerCompetition() {
		inputStream.useDelimiter("\\s*,\\s*|(\\n)|(\\r\\n)");
		// comma surrounded by 0 or more whitespaces
		// newline
		// carriage return and newline
		
		CompetitionBuilder compBuilder = CompetitionBuilder.getInstance();
		
		competition = compBuilder
				.build()
				.withTeamType(TeamType.translate(inputStream.next()))
				.withGender(Gender.translate(inputStream.next()))
				.finish();
		
		// Scanner clutter
		if (inputStream.hasNextLine()) {
			inputStream.nextLine();
		}
		
		while(inputStream.hasNext()) {
			// search the team by its name
			String teamName = inputStream.next();
			
			// use an iterator so we can remove elements from the list while
			Iterator<Team> teamIterator = teams.iterator();
			
			while (teamIterator.hasNext()) {
				Team currentTeam = teamIterator.next();
				
				if (currentTeam.getTeamName().equals(teamName)) {
					// it has been found, attempt to add it to the competition
					competition.addTeam(currentTeam);
					
					/*
					 *  remove it from the current list so it's impossible to
					 *  add it again (by any reason whatsoever, QA engineers
					 *  are scary)
					 */
					teamIterator.remove();
				}
			}
			
			// Scanner clutter
			if (inputStream.hasNextLine()) {
				inputStream.nextLine();
			}
		}
				
	}
	
	/**
	 * Play the actual competition and print the results
	 */
	public static void playCompetition() {
		competition.playCompetition();
		competition.printRanking();
	}
	
	public static void main(String[] args) {
		if (args[0].equals("inscriere")) {
			setupIO(args[1], args[3]);
			registerTeams();
			listTeams();
			restoreIO();
		}
		
		if (args[0].equals("competitie")) {
			setupIO(args[1], args[3]);
			registerTeams();
			setInputStream(args[2]);
			registerCompetition();
			playCompetition();
			restoreIO();
		}
	}

}
