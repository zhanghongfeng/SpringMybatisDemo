package demo.test;

import com.aldt.test.SpringMybatisApplication;
import com.aldt.test.dao.domain.loandb.UserCreditRisk;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhf2015 on 2020-10-23.
 */
//@SpringBootTest
@RunWith(SpringRunner.class)
@Import(SpringMybatisApplication.class)
public class BaseTest {

    @Test
    public void testDemo(){


        System.out.println("test");

    }
}
