import Lost_and_Found_App.Util.LocalUtil;
import org.junit.Test;

public class TimeOutTest {


    @Test(timeout=2500)
    public void shouldNotExceedTwoSecondsExcecution()
    {
        LocalUtil.timeoutTestMethod();
    }
}
