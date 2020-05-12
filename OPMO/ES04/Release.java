package MusicLandscape.entities;

public abstract class Release {


		private Artist artist=new Artist();
		private int year=1900;
		private String title;
		
		public Release() {
		}
		
		public Release(Release orig) {
			this.artist=new Artist(orig.artist);
			this.year=orig.year;
			this.title=orig.title;
		}
		
		public Release(String title, Artist artist, int year) {
			this.title=title;
			this.artist=artist;
			this.year=year;
		}

		public Artist getArtist() {
			return artist;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			if (year<0) 
				return;
			this.year = year;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		public abstract int totalTime();

		@Override
		public String toString() {
			return String.format(
					"%s-%s-%s-%d",
					title == null ? "unknown" : title,
					artist == null ? "unknown"
							: artist.getName() == null ? "unknown" : artist.getName(),
					year == 0 ? "unknown"
							: year,
							totalTime());
		}
}
