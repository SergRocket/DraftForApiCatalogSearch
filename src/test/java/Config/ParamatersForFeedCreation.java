package Config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParamatersForFeedCreation {
    private String feedname;
    private Boolean ftpFeed;
    private Boolean runNightly;
    private Boolean saveFeed;
    private Integer threshold;
}
