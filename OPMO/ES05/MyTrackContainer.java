package MusicLandscape.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.ListIterator;


import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class MyTrackContainer {
	private java.util.List<Track> selection=new ArrayList<Track>();
	private java.util.Set<Track> tracks=new HashSet<Track>(); //nur mit HashKuti, sonst nur shit im Kuti - but y??
	
	public MyTrackContainer(){
	}
	
	public MyTrackContainer(Track[] t) {
		for (int i = 0; i < t.length; i++) {
			tracks.add(t[i]);
		}
		selection.addAll(tracks);
	}
	
	public MyTrackContainer(Iterable<Track> t) {
		//v1, funktioniert, but y?? pain in the kutilein
//		tracks.addAll((Collection<? extends Track>) t);
//		selection.addAll((Collection<? extends Track>) t);
		
		//v2, funktioniert auch und ist lesbar
		for (Track track : t) {
			tracks.add(track);
		}
		selection.addAll(tracks);
		}

	public void sort(java.util.Comparator<Track> theComp, boolean asc) {
		if (asc==false) Collections.sort(selection, theComp.reversed());
		else Collections.sort(selection, theComp);
	}
	
	public int filter(MyMatcher<Track> matcher) {
		int count=0;
		ListIterator<Track> lit=selection.listIterator();
		while (lit.hasNext()){
			if (!matcher.matches(lit.next())) {
				lit.remove();
				count++;
			}
		}
			return count;
	}
	
	public void reset() {
		selection.clear();
		selection.addAll(tracks);
	}
	
	public int remove() {
		int removed=selection.size();
		tracks.removeAll(selection);
		selection.clear();
		selection.addAll(tracks);
		return removed;
	}
	
	public int addAll(Track[] t) {
		int pre=tracks.size();
		tracks.addAll(Arrays.asList(t));
		return tracks.size()-pre;
	}
	
	public int size() {
		return tracks.size();
	}
	
	public Track[] selection() {
//		v1, primakuti
		return selection.toArray(new Track[selection.size()]);
		
//		v2, klassisch
//		int count=0;
//		if (selection == null) return null;
//		Track t[]=new Track[selection.size()];
//		for (Track track : selection) {
//			t[count++]=track;
//		}
//		return t;
	}
	
	public boolean add(Track t) {
		if (t==null) return false;
		return tracks.add(t);
	}
	
	

}
