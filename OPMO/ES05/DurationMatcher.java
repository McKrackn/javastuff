package MusicLandscape.util.matcher;
import java.util.Scanner;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class DurationMatcher extends MyMatcher<Track> {
	
	private int lower;
	private int upper=Integer.MAX_VALUE;
	
	public DurationMatcher() {
	}

	public DurationMatcher(String pat) {
		Scanner sc=new Scanner(pat);
		this.lower=sc.nextInt();
		this.upper=sc.nextInt();
		sc.close();	}


	@Override
	public boolean matches(Track t) {
		if 
			(t.getDuration()>=lower && t.getDuration()<=upper){
				return true;
			}
		return false;
		}
	
	@Override
	public void setPattern(String pat) {
		if (pat.matches("[^0-9]+$")) return;
		Scanner sc=new Scanner(pat);
		this.lower=sc.nextInt();
		this.upper=sc.nextInt();
		if (lower>upper) {
			upper=Integer.MAX_VALUE;
		}
		sc.close();
	}

	@Override
	public String getPattern() {
		return String.format("%d %d", lower, upper);
	}

	@Override
	public String toString() {
		return String.format("duration in range (%s)",getPattern());
	}

}
