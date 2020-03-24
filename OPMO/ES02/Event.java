package MusicLandscape.entities;

public class Event {
	private Artist artist=new Artist();
	private int attendees=0;
	private MusicLandscape.Date date  = null;
	private String description="";
	private MusicLandscape.Venue venue = null;
	
	public int getAttendees(){
		return attendees;
	}
	public Artist getArtist() {
		return artist;
	}
	public MusicLandscape.Date getDate() {
		if (date==null)return null;
		return new MusicLandscape.Date(date);
	}
	public String getDescription() {
		return description;
	}
	public MusicLandscape.Venue getVenue() {
		return this.venue;
	}
	public void setArtist(Artist artist) {
		if (artist!=null)
		this.artist=artist;
	}  
	public void setAttendees(int attendees) {
		if (attendees>=0)
		this.attendees=attendees;
	}
	public void setDate(MusicLandscape.Date date) {
		if (date!=null)
		this.date=new MusicLandscape.Date(date);
	}  
	public void setDescription(String description) {
		if (description!=null)
		this.description=description;
	}
	public void setVenue(MusicLandscape.Venue venue)  {
		this.venue=venue;
	}
}
