package RestApiSetup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page{
	private int number;
	private String size;
	private int totalPages;
	private int totalElements;

	public Page(){
		super();
	}

	public int getNumber(){
		return number;
	}

	public String getSize(){
		return size;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public int getTotalElements(){
		return totalElements;
	}
}
