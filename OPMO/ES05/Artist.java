package MusicLandscape.entities;

public class Artist implements Comparable<Artist>

{
	private String name;
	
	public Artist() {
		name="unknown";
	}
	public Artist(Artist a) {
		name = a.name;
	}
	public Artist (String name) {
		//if (name != null && name.trim().length() > 0)
			this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.trim().length() > 0)
			this.name = name;
	}
	
	public String toString() {
		if (this.name != null)
			return this.name;
		return "unknown";
	}
	
	@Override
	public int compareTo(Artist o) {
		return this.getName().compareTo(o.getName());
	}
}
