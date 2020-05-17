package MusicLandscape.entities;

public class MusicVideo extends Release {
	private Track track;
	
	public MusicVideo() {
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	@Override
	public int totalTime() {
		if (track==null) return 0;
		return track.getDuration();
	}

	@Override
	public String toString() {
		if (super.toString()==null) return null;
		return super.toString() + "-(Video)";
	}

}
