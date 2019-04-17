import com.util.LogZ;
import com.util.ZaoUtils;

public class LogTest {
    public static void main(String[] args) {
        LogZ.trace("====== trace");
        LogZ.debug("====== debug");
        LogZ.info("====== info");
        LogZ.warn("====== warn");
        LogZ.error("====== error");
        LogZ.error("你说一下这个是什么情况？？？？？？" + ZaoUtils.getSystemTimeMore(2) );
    }
}