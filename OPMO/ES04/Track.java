package MusicLandscape.entities;

import java.util.Scanner;

import MusicLandscape.util.ConsoleScanable;

public class Track implements ConsoleScanable

{
	private String title = null;
	private int duration = 0;
	private Artist writer = new Artist();
	private Artist performer = new Artist();
	private int year=1900;
	
	public Track() {
	}
	public Track(String title) {
		this();
		this.title=title;
	}
	public Track(Track t) {
		setTitle(t.title);
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
		if (title==null) return;
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
						: writer.getName() == null ? "unknown" : writer.getName(),
				performer == null ? "unknown"
						: performer.getName() == null ? "unknown" : performer.getName(),
						duration / 60, duration % 60);
	}

	public String toString() {
		return String.format(
				"%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
				title == null ? "unknown" : title,
				writer == null ? "unknown"
						: writer.getName() == null ? "unknown" : writer.getName(),
				performer == null ? "unknown"
						: performer.getName() == null ? "unknown" : performer.getName(),
						duration / 60, duration % 60);
	}
	@Override

	public boolean scan() {
		Scanner sc = new Scanner(System.in);
		boolean fieldChanged = false, objectChanged = false;
		String input;
		do {
			System.out.printf("current title: %s\n", this.title);
			System.out.printf("enter new title (leave empty to keep):");
			input = sc.nextLine();
			if (input.length() == 0) { 
				fieldChanged = false;
				break;
			}
			
			fieldChanged = true;
			break;
		} while (true);
		if (fieldChanged) {
			setTitle(input);
		}
		objectChanged = objectChanged || fieldChanged;
		fieldChanged = false; 
		int tmpDuration = this.getDuration();
		do {
			System.out.printf("current duration: %d\n", this.getDuration());
			System.out.printf("enter new duration (leave empty to keep):");
			input = sc.nextLine();
			if (input.length() == 0) { 
				fieldChanged = false;
				break;
			}
			tmpDuration = Integer.parseInt(input);

			if (tmpDuration > 0) {
				fieldChanged = true;
				break;
			}
		} while (true);
		if (fieldChanged) {
			this.setDuration(tmpDuration);
		}
		objectChanged = objectChanged || fieldChanged;
		fieldChanged = false; 
		sc.close();

		return objectChanged;

	}

	

	

	

	

	

	


}
