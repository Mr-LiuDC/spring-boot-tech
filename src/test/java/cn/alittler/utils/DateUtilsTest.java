package cn.alittler.utils;

import org.junit.Test;

import java.util.Date;

/**
 * 测试时间转换工具类
 *
 * @author LiuDeCai
 */
public class DateUtilsTest {

    @Test
    public void testParseDateStr() {
        Date date = DateUtils.parseDateStr("20180912122515", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }

}