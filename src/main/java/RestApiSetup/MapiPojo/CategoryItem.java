package RestApiSetup.MapiPojo;

public class CategoryItem{
	private String treePath;
	private String parent;
	private String crumb;
	private String catName;
	private String catId;
	private int count;

	public String getTreePath(){
		return treePath;
	}

	public String getParent(){
		return parent;
	}

	public String getCrumb(){
		return crumb;
	}

	public String getCatName(){
		return catName;
	}

	public String getCatId(){
		return catId;
	}

	public int getCount(){
		return count;
	}
}
