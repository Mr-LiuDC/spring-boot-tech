package cn.alittler.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuDeCai
 */
@Slf4j
public class DateUtils {
    public static Date parseDateStr(String dateStr, String pattern) {
        Date resultDate = null;
        try {
            resultDate = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            log.error("日期字符串解析出错：{}，详细错误信息：{}", e.getMessage(), e.getStackTrace());
        }
        return resultDate;
    }
}
