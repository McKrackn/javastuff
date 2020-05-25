package MusicLandscape.util.matcher;
import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class TitleMatcher extends MyMatcher<Track> {
	
	private String pattern;

	public TitleMatcher(String pat) {
		this.pattern=pat;
	}

	@Override
	public boolean matches(Track t) {
		if (t.getTitle().startsWith(pattern)){
			return true;
		}
		return false;
	}

	@Override
	public void setPattern(String pat) {
		if (pat==null) return;
		this.pattern=pat;		
	}

	@Override
	public String getPattern() {
		return pattern;
	}
	
	@Override
	public String toString() {
		return String.format("title starts with (%s)",getPattern());
	}

}
