package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class Event {
	private Artist artist=new Artist();
	private int attendees=0;
	private Date date  = null;
	private String description="";
	private Venue venue = null;
	
	//constructors:
	public Event(Event e) {
		this.artist = new Artist(e.artist);
		this.attendees = e.attendees;
		this.date = new Date(e.date);
		this.description = e.description;
		this.venue = new Venue(e.venue);
	}
	
	public Event() {
	}

	//getters:
	public int getAttendees(){
		return attendees;
	}
	public Artist getArtist() {
		return artist;
	}
	public Date getDate() {
		if (date==null)return null;
		return new Date(date);
	}
	public String getDescription() {
		return description;
	}
	public Venue getVenue() {
		return this.venue;
	}
	public int impact() {
		return this.attendees*2;
	}
	
	//setters:
	public void setArtist(Artist artist) {
		if (artist!=null)
		this.artist=artist;
	}  
	public void setAttendees(int attendees) {
		if (attendees>=0)
		this.attendees=attendees;
	}
	public void setDate(Date date) {
		if (date!=null)
		this.date=new Date(date);
	}  
	public void setDescription(String description) {
		if (description!=null)
		this.description=description;
	}
	public void setVenue(Venue venue)  {
		this.venue=venue;
	}
	
	//other:
	public String toString() {

		return String.format(
				"%s @ %s on %s\n%s\n(%d attending (%d))",
				artist == null ? "unknown" 
						: artist.getName() == null ? "unknown"
								:artist.getName(),
				venue == null ? "unknown"
						: venue.getName() == null ? "unknown" 
								: venue.getName(),
				date == null ? null
						: date.toString() == null ? null 
								: date.toString(),
				description == null ? "unknown"
						: description,
				attendees, impact());
	}
}
