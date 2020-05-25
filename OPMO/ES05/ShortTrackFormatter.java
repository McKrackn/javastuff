package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class ShortTrackFormatter implements MyFormatter<Track> {

	@Override
	public String header() {
		return "Title      (min:sec)";
	}

	@Override
	public String format(Track t) {
		return String.format("%-10.10s (%02d:%02d)", t.getTitle(), t.getDuration()/60, t.getDuration() % 60);
	}

	@Override
	public String topSeparator() {
		return "--------------------";
	}

	@Override
	public String toString() {
		return "short format [Title (min:sec)]";
	}
}
