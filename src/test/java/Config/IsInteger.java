package Config;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsInteger extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        try {
            Integer.parseInt(String.valueOf(item));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is int");
    }

    public static Matcher<String> isInt(){
        return new IsInteger();
    }
}
