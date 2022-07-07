package Config;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsArrayOfInt extends TypeSafeMatcher <ArrayList<List<String>>> {

    @Override
    protected boolean matchesSafely(ArrayList<List<String>> item) {
        boolean a = true;
        for(int i = 0 ; i <= item.size() -1; i++) {
            try {
                Integer.parseInt(String.valueOf(item));
                return a;
            } catch (NumberFormatException e) {
                a = false;
            }
        }
      return a;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is array of ints");
    }

    public static Matcher<ArrayList<List<String>>> isArrayOfInts(){
        return new IsArrayOfInt();
    }

}
