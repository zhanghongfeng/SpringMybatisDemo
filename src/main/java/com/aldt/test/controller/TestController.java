package com.aldt.test.controller;

import com.aldt.test.dao.domain.loanCollection.CollectionCase;
import com.aldt.test.dao.domain.loandb.UserCreditRisk;
import com.aldt.test.service.UserCreditService;
import com.aldt.test.service.loanCollecation.CollectionCaseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhf2015 on 2020-10-26.
 */

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private CollectionCaseServer collectionCaseServer;

    @Autowired
    private UserCreditService userCreditService;



    @RequestMapping(value = "/credit/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public String gfdCreditRisk(@PathVariable  Integer userid){
        UserCreditRisk userCreditRisk = userCreditService.getGfdCreditRiskByUserId(userid);
        return userCreditRisk==null ? "该用户["+userid+"]还没有授信信息" : userCreditRisk.toString();
    }

    @RequestMapping(value = "/coll/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public String collectionCaseInfo(@PathVariable  Integer userid){
        CollectionCase collCase = collectionCaseServer.getLastCollCaseByUserId(userid);
        return collCase==null ? "该用户["+userid+"]还没有催收案件" : collCase.toString();
    }
}
