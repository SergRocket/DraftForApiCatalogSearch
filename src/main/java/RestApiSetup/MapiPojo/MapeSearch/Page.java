package RestApiSetup.MapiPojo.MapeSearch;

public class Page{
	private int number;
	private int size;
	private int totalPages;
	private int totalElements;

	public int getNumber(){
		return number;
	}

	public int getSize(){
		return size;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public int getTotalElements(){
		return totalElements;
	}
}
