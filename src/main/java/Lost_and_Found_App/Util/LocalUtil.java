package Lost_and_Found_App.Util;

import java.time.format.DateTimeFormatter;

public class LocalUtil {

    private static Long itemId;
    private static Long reportId;

    public static DateTimeFormatter getFormatter()
    {
        return DateTimeFormatter.ofPattern("YYYY-MM-DD / HH:mm:ss");
    }


    public static Long assignItemId()
    {
        return ++itemId;
    }
    public static Long assignReportId()
    {
        return ++reportId;
    }

}
