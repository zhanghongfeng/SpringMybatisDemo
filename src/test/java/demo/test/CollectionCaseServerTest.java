package demo.test;

import com.aldt.test.dao.domain.loanCollection.CollectionCase;
import com.aldt.test.dao.domain.loandb.UserCreditRisk;
import com.aldt.test.service.UserCreditService;
import com.aldt.test.service.loanCollecation.CollectionCaseServer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhf2015 on 2020-10-23.
 */
public class CollectionCaseServerTest extends BaseTest {

    @Autowired
    private CollectionCaseServer collectionCaseServer;



    @Test
    public void getCollCaseById_Test(){
        CollectionCase collectionCase = collectionCaseServer.getCollCaseById(170);

        System.out.println(collectionCase.getUserName() + " : " + collectionCase.getCaseAmount());

    }
}
