package units;

import java.util.ArrayList;

public interface IntGame {
    void step(ArrayList<Unit>myTeam, ArrayList<Unit>oppTeam);
    String getInfo();
}
