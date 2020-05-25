package MusicLandscape.util.comparators;

import java.util.Comparator;

import MusicLandscape.entities.Track;

public class TitleComparator implements Comparator<Track> {

	@Override
	public int compare(Track o1, Track o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
	public String toString() {
		return "by title";
	}
}
