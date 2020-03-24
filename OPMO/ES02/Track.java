package MusicLandscape.entities;

public class Track

{
	private String title = null;
	private int duration = 0;
	private Artist writer = new Artist();
	private Artist performer = new Artist();
	private int year;
	
	public Track() {
		this.writer.setName("0");
	}
	public Track(String title) {
		this();
		this.title=title;
	}
	public Track(Track t) {
		this.title=t.title;
		this.duration=t.duration;
		this.writer=new Artist(t.writer);
		this.performer=new Artist(t.performer);
		this.year=t.year;
	}
	
	public int getYear() {
		return year;
	}

	
	public void setYear(int year) {
		if (year > 1899 && year < 3000)
			this.year = year;
	}

	
	public int getDuration() {
		return duration;
	}

	
	public void setDuration(int duration) {
		if (duration < 0)
			return;
		this.duration = duration;
	}

	
	public String getTitle() {
		if (title == null)
			return "unknown title";
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public Artist getWriter() {
		return writer;
	}

	
	public void setWriter(Artist writer) {
		if (writer == null)
			return;
		this.writer = writer;
	}

	
	public Artist getPerformer() {
		return performer;
	}

	
	public void setPerformer(Artist performer) {
		if (performer == null) {
			return;
		}

		this.performer = performer;
	}

	public boolean writerIsKnown() {
		if (writer == null)
			return false;
		return writer.getName() != null;
	}

	
	public String getString() {
		return String.format(
				"%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
				title == null ? "unknown" : title,
				writer == null ? "unknown"
						: writer.getName() == null ? "unknown" : writer
								.getName(),
				performer == null ? "unknown"
						: performer.getName() == null ? "unknown" : performer
								.getName(), duration / 60, duration % 60);
	}

	

	

	

	

	

	


}
