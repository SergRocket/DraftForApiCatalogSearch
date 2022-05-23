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
    private String feedName;
    private boolean ftpFeed;
    private boolean runNightly;
    private boolean saveFeed;
    private int threshold;
}
