package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
	public class OptionsMap {
	@JsonProperty("PHOTO_BOOK_SIZE")
	public String pHOTO_BOOK_SIZE;
	@JsonProperty("PHOTO_BOOK_COVER")
	public String pHOTO_BOOK_COVER;
	@JsonProperty("PHOTO_BOOK_PAGE_OPTIONS")
	public String pHOTO_BOOK_PAGE_OPTIONS;

		public OptionsMap(String pHOTO_BOOK_SIZE, String pHOTO_BOOK_COVER, String pHOTO_BOOK_PAGE_OPTIONS) {
			this.pHOTO_BOOK_SIZE = pHOTO_BOOK_SIZE;
			this.pHOTO_BOOK_COVER = pHOTO_BOOK_COVER;
			this.pHOTO_BOOK_PAGE_OPTIONS = pHOTO_BOOK_PAGE_OPTIONS;
		}

		public OptionsMap() {
			super();
		}

		public String getpHOTO_BOOK_SIZE() {
			return pHOTO_BOOK_SIZE;
		}

		public String getpHOTO_BOOK_COVER() {
			return pHOTO_BOOK_COVER;
		}

		public String getpHOTO_BOOK_PAGE_OPTIONS() {
			return pHOTO_BOOK_PAGE_OPTIONS;
		}
	}