package main;

import view.PrintResults;
import model.Board;

public class MonopolySimulator {

	/*
	 * CHALLENGE PICKED LOCATED AT: http://rubyquiz.strd6.com/quizzes/188-monopoly-walker
	 */
	
	/*
	 * CHANGE THE VARIABLES BELOW TO CHANGE THE PARAMETERS OF THE SIMULATION
	 * A CHANGE TO TEST BRANCHING
	 */	
	
	//Set number of rounds (in a round, each player takes their turn exactly once)
	private final static int numberOfRounds = 10000000;
	
	//Set number of players (Monopoly is a 2-8 player game)
	private final static int numberOfPlayers = 2;
	
	//Set percent chance of a player deciding to pay his way out of jail on a given turn
	//Enter an integer between 0 and 100 inclusive
	private final static int percent = 80;
	
	//Display the top X number of properties according to their relative frequencies
	private final static int x = 10;
	
	public static void main(String[] args) {
		Board board = new Board(numberOfRounds, numberOfPlayers, percent);
		PrintResults pr = new PrintResults(board, x);
		pr.print();
	}
	
	/*
	 * NOTE ON ACCURACY OF SIMULATION:
	 * -I probed around online and looked at what results others have got from running this
	 * type of simulation. I would say that my results are definitely similar.
	 */
	
	/*
	 * NOTES ON MY ASSUMPTIONS:
	 * -Landing on the space "Go To Jail" counts as landing on the space, and it increments the
	 * counter accordingly. The results from some simulations I looked at considered it impossible
	 * to actually land on the "Go to Jail" space.
	 * -A player visiting jail and a player in jail are on the same space.
	 * -Advance to nearest railroad/utility cards only allow player to move forward.
	 * -Get out of jail free cards have an incredibly small impact on player movement; they
	 * also depend on other factors not required for this simulation (e.g. a player can buy
	 * another player's get out of jail free card). Hence, the get out of jail free card is
	 * not factored into this simulation.
	 * -If a player gets stuck in jail for another turn, this counts as the player occupying
	 * the space for another turn and hence increments the counter for the jail space.
	 * -I assumed that depending on the players playing, they would be more or less likely
	 * to pay their way out of jail. Hence, this is a parameter that can be set. Also, note that
	 * this parameter has a very large effect on the relative frequency of the jail space.
	 * -I assumed you would be more interested in me spending the few hours of my time for this
	 * coding challenge on coding the simulation. Hence, I did not devote my time to designing
	 * a stupid-proof and elegant UI system for entering the four required parameters to run
	 * the simulation! 
	 */
}
