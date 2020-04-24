package MusicLandscape.entities;

public class TVShow extends Event {
	private String name=null;
	private int viewers=0;

	public TVShow(Event e) {
		super(e);
	}
	public TVShow(TVShow tvs) {
		super(tvs);
		this.name=tvs.name;
		this.viewers=tvs.viewers;
	}
	public TVShow() {
		// TODO Auto-generated constructor stub
	}
	public int getViewers() {
		return viewers;
	}
	public void setViewers(int v) {
		if (v>=0) {
			this.viewers=v;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name != null && name.trim().length() > 0)
		this.name = name;
	}
	public int impact() {
		return (getAttendees()+viewers)*2;
	}
	public String toString() {
		return String.format(
				"%s @ %s on %s\n%s\n(%d attending (%d))",
				getArtist() == null ? "unknown" 
						: getArtist().getName() == null ? "unknown"
								:getArtist().getName(),
				this.name == null ? "unknown" 
						: this.name,
				getDate() == null ? null
						: getDate().toString() == null ? null 
								: getDate().toString(),
				getDescription() == null ? "unknown"
						: getDescription(),
					getAttendees()+viewers, impact());
	}
}
