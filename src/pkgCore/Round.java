package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();
	int Score = 0;
	private int rollCount = 0;
	
	public Round() {
		
		Roll roll = new Roll();
		ComeOutScore = roll.getScore();

		if (ComeOutScore == 2 || ComeOutScore == 3 ||
				ComeOutScore == 12) {
			
			this.eGameResult = eGameResult.CRAPS;
			rollCount = 1;
		
		}
		
		else if ( ComeOutScore == 7 || ComeOutScore == 11) {
			
			this.eGameResult = eGameResult.NATURAL; 
			rollCount = 1;
		}
		
		else {
			while (ComeOutScore != Score || ComeOutScore != 7){
				
				Roll newRoll = new Roll();
				Score = newRoll.getScore();
				rollCount++;
			}
			
		}

		// TODO: value the eGameResult after the round is complete
		if(ComeOutScore==7) {
			this.eGameResult = eGameResult.SEVEN_OUT;
		}
		else if (ComeOutScore==Score) {
			this.eGameResult = eGameResult.POINT;
		}
	}

	public int RollCount() {
		// Return the roll count
		return rollCount;
	}

}
