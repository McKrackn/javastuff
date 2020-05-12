package MusicLandscape.util.comparators;

import MusicLandscape.entities.Event;

public class MyEventAttendeesComparator extends MyEventComparator {
	@Override
	public int compare(Event t1, Event t2) {
		if (t1==null&&t2==null)
			return 0;
		if (t1==null)
			return -1;
		if (t2==null)
			return 1;
		return t1.getAttendees()-t2.getAttendees();
	}
}
