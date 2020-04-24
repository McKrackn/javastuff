package MusicLandscape.entities;

import java.util.Arrays;

public class Concert extends Event {
	private int nextIdx=0;
	private Track[] setList=new Track[0];

	public Concert() {
	}

	public boolean addTrack(Track t) {
		if (t == null) return false;
		ensureCapacity(nextIdx);
		setList[nextIdx] = t;
		nextIdx++;
		return true;
		}
	private void ensureCapacity(int length) {
		if (setList.length==length) {
			setList=Arrays.copyOf(setList, length+1);
		}
	}
	public Track[] getSetList() {
		Track[] copySetList=new Track[nextIdx];
		for (int i=0;i<nextIdx;i++) {
			copySetList[i]=new Track(setList[i]);
		}
		return copySetList;
	}
	public void setSetList(Track[] tracks) {
		if (tracks==null) return;
		nextIdx=0;
		setList=new Track[tracks.length];
		for (int i=0;i<tracks.length;i++) {
			if (tracks[i]!=null)
				setList[nextIdx++]=new Track(tracks[i]);
		}
	}
	public void resetSetList() {
		setList=new Track[0];
		nextIdx=0;
	}
	public int nrTracks() {
		return nextIdx;
	}
	public int duration() {
		int duration=0;
		for (int i=0;i<nextIdx;i++) {
			if (setList[i].getDuration() > 0)
				duration=duration+setList[i].getDuration();
		}
		return duration;
	}
	public int impact() {
		return getAttendees()*((duration()/60/30)+1);
	}
	public String toString() {
		return String.format("%s\n%d tracks played, total duration %02d:%02d.", super.toString(), nrTracks(), duration()/3600, (duration()/60)%60) ;
	}
}
