package DataSource;

import Pictures.Pictures;
import java.util.HashMap;

public class PictureDS {

    static HashMap<String, Pictures> pictureToNameMap;

    static {
        pictureToNameMap = new HashMap<String, Pictures>();
    }

    public HashMap<String, Pictures> getPictureToNameMap() {
        return pictureToNameMap;
    }

    public void setPictureToNameMap(HashMap<String, Pictures> pictureToNameMap) {
        PictureDS.pictureToNameMap = pictureToNameMap;
    }
}
