import java.util.ArrayList;
import java.util.List;

public class SongsPlaylist {

    public static List<String> solution(String[] songs, String[] animations) {
        List<String> result = new ArrayList<>();

        for (String song : songs) {
            String[] songInfo = song.split(":");
            int songLength = Integer.parseInt(songInfo[1]);

            for (String animation : animations) {
                String[] animationInfo = animation.split(":");
                String animationName = animationInfo[0];
                int animationLength = Integer.parseInt(animationInfo[1]);

                if (songLength % animationLength == 0) {
                    int repeatCount = songLength / animationLength;
                    result.add(animationName + ":" + repeatCount);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] songs = {"notion:360", "voyage:185", "sample:180"};
        String[] animations = {"circles:360", "squares:180", "lines:37"};

        List<String> result = solution(songs, animations);


        for (String line : result) {
            System.out.println(line);
        }
    }
}
