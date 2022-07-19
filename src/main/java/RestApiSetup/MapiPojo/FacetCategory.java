package RestApiSetup.MapiPojo;

public class FacetCategory {
    public String cat_id;
    public String cat_name;
    public String crumb;
    public String tree_path;
    public String count;
    public String prent;

    public FacetCategory(String cat_id, String cat_name, String crumb, String tree_path, String count, String prent) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.crumb = crumb;
        this.tree_path = tree_path;
        this.count = count;
        this.prent = prent;
    }

    public String getCat_id() {
        return cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public String getCrumb() {
        return crumb;
    }

    public String getTree_path() {
        return tree_path;
    }

    public String getCount() {
        return count;
    }

    public String getPrent() {
        return prent;
    }
}
