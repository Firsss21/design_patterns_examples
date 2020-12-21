package structuralPatterns.proxyExample;

import java.util.HashMap;

public interface ThirdPartyYouTubeClassLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
