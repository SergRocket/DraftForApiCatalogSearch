package Config;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsDouble extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        try {
            Double.parseDouble(String.valueOf(item));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is double");
    }

    public static Matcher<String> isDouble(){
        return new IsDouble();
    }
}
