package MusicLandscape.entities;

public class Artist

{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.trim().length() > 0)
			this.name = name;
	}
}
