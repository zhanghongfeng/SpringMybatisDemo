package demo.test;

import com.aldt.test.SpringMybatisApplication;
import com.aldt.test.dao.domain.loandb.UserCreditRisk;
import com.aldt.test.service.UserCreditService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhf2015 on 2020-10-23.
 */
public class UserCreditServiceTest extends BaseTest{
    @Autowired
    private UserCreditService userCreditService;



    @Test
    public void getGfdCreditRiskByUserId_Test(){
        UserCreditRisk userCreditRisk = userCreditService.getGfdCreditRiskByUserId(2003103048);

        System.out.println(userCreditRisk.getCredit_date());

    }
}
