package Config;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsString extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String item) {
        try {
            String.valueOf(item);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is string");
    }

    public static Matcher<String> isString(){
        return new IsString();
    }
}
