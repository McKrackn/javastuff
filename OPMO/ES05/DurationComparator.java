package MusicLandscape.util.comparators;

import java.util.Comparator;

import MusicLandscape.entities.Track;

public class DurationComparator implements Comparator<Track> {

	@Override
	public int compare(Track o1, Track o2) {
		return o1.getDuration()-o2.getDuration();
	}
	public String toString() {
		return "by duration";
	}

}
