import com.monkey.ele.merchant.pojo.Store;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 10:40 PM 8/1/2018
 */
public class Test {
    @org.junit.Test
    public void test() {
        Store store = new Store();
        store.setAddress("adsa");
        store.setCreateTime(new Date());

        Store store1 = new Store();
        store1.setAddress("asdsad");
        System.out.println();
    }

    @org.junit.Test
    public void testDDL() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("abc", "abcd");
        map.put("abc1", "abcd");
        map.put("abc2", "abcd");
        map.put("abc3", "abcd");
    }
}
