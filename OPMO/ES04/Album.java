package MusicLandscape.entities;

public class Album extends Release {
	
	private class TrackListItem {
		Album.TrackListItem next;
		Track track;
		
		TrackListItem(Track t){
			track=new Track(t);
		}
	}

	private Album.TrackListItem trackListHead;

	public Album() {
	}

	public Album(Album orig) {
		super(orig);
		this.trackListHead=orig.trackListHead;
	}

	public Album(String title, Artist artist, int year) {
		super(title, artist, year);
	}
	
	public boolean addTrack(Track t) {
		if (t==null) return false;
		TrackListItem newTrackList=new TrackListItem(t);
		
		if (trackListHead==null) {
			trackListHead=newTrackList;
			return true;
		}
		
		TrackListItem cur;
		for (cur=trackListHead;cur.next!=null;cur=cur.next) {}
		cur.next=newTrackList;
		return true;		
	}
	
	//Code von Shagha:
	public Track removeTrack(int n) {
		if (trackListHead == null)
			return null;

		int cnt = 0;
		Track tmp = new Track();
		TrackListItem lastTrack = trackListHead;
		for (TrackListItem t = trackListHead; t != null; t = t.next) {
			if (n == cnt) {
				tmp = t.track;
				if (trackListHead == t) {
					trackListHead = t.next;
					t.next = null;
					return tmp;
				}
				lastTrack.next = t.next;
				return tmp;
			}
			lastTrack = t;
			cnt++;
		}

		return null;
	}
	
//	originalcode:	
//	public Track removeTrack(int n) {
//		
//		
//		
//		if (trackListHead==null) return null;
//		if (n==0) {
//			TrackListItem tmp=trackListHead.next;
//			TrackListItem old=trackListHead;
//			trackListHead.next=null;
//			trackListHead=tmp;
//
////			trackListHead=trackListHead.next;
////			old.next=null;
//			return old.track;
//		} else {
//		
//		for (TrackListItem cur=trackListHead;cur!=null;cur=cur.next) {
//			n--;
//			if (n==0) {
//				Track toRet=cur.next.track;
//				cur.next=cur.next.next;
//				return toRet;
//			}
//		}
//		}
//		return null;
//	}
	
	public int nrTracks() {
		int cnt=0;
		if (trackListHead==null) return 0;
		TrackListItem cur;
		for (cur=trackListHead;cur!=null;cur=cur.next) {
			cnt++;
		}
		return cnt;
	}

	public Track[] getTracks() {
		Track[] a = new Track[nrTracks()];
		int i = 0;
		for (TrackListItem cur = trackListHead; cur != null; cur = cur.next) {
			if (cur.track!=null)
				a[i++] = cur.track;
		}
		return a;
	}
	
	@Override	
	public int totalTime() {
		int i = 0;
		for (TrackListItem cur = trackListHead; cur != null; cur = cur.next) {
			i=i+cur.track.getDuration();
		}
		return i;
	}

	@Override
	public String toString() {
		String albumTracks="";
		
		for (TrackListItem cur = trackListHead; cur != null; cur = cur.next) {

			albumTracks=albumTracks+"["+cur.track.getTitle()+"]["+cur.track.getTitle()+"]\n";
		}
		
		return super.toString() +"\n["
				+ albumTracks
				+ "] "+nrTracks();
	}
}
