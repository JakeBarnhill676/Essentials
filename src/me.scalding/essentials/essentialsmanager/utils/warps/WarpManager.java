package essentials.essentialsmanager.utils.warps;

import essentials.Essentials;

/**
 * Created by Jake on 8/3/2016.
 */
public class WarpManager {

    public boolean containsId(int id) {
        for(Warp warp : Essentials.getInstance().warps) {
            if(warp.getId()==id) return true;
        }
        return false;
    }
}
