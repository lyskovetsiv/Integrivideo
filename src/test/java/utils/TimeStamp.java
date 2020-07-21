package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

    public static String getTimeStamp() {
        return new SimpleDateFormat("MM/dd/yyyy, HH:mm").format(new Date());
    }
}
