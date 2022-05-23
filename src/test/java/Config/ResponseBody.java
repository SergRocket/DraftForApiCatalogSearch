package Config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResponseBody extends ParamatersForFeedCreation {
    @JsonDeserialize(using = NumberDeserializers.IntegerDeserializer.class)
    public int responseBody;
}
