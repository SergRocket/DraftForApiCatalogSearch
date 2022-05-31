package APITests;

import RestApiSetup.ParamatersForFeedCreation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.Data;

@Data
public class ResponseBody extends ParamatersForFeedCreation {
    @JsonDeserialize(using = NumberDeserializers.IntegerDeserializer.class)
    public int responseBody;
}
