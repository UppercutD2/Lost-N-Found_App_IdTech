package Lost_and_Found_App.Util;

import java.time.format.DateTimeFormatter;

public class LocalUtil {

    private static Long itemId=0L;
    private static Long reportId=0L;

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

    public static void timeoutTestMethod()
    {
        for(int i=0;i<2;i++)
        {
            if(i==1)
            {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException ex)
                {
                    System.out.println("Nice and sweet.");
                }
            }
            System.out.println(i);
        }
    }

}
