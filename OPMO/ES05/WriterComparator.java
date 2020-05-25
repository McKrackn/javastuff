package MusicLandscape.util.comparators;

import java.util.Comparator;

import MusicLandscape.entities.Track;

public class WriterComparator implements Comparator<Track> {

	@Override
	public int compare(Track o1, Track o2) {
		return o1.getWriter().compareTo(o2.getWriter());
	}
	
	public String toString() {
		return "by writer";
	}

}
