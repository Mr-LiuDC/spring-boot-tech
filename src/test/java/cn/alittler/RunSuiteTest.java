package cn.alittler;

import cn.alittler.utils.DateUtilsTest;
import cn.alittler.web.rest.RunRestTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 运行所有测试用例
 *
 * @author LiuDeCai
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({RunRestTest.class, SpringBootTechApplicationTest.class, DateUtilsTest.class})
public class RunSuiteTest { }
