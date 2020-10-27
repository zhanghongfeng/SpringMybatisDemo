package com.aldt.test.service;

import com.aldt.test.dao.domain.loandb.UserCreditRisk;
import com.aldt.test.dao.domain.loandb.UserCreditRiskCriteria;
import com.aldt.test.dao.mapper.loandb.UserCreditRiskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhf2015 on 2020-10-23.
 */
@Service
public class UserCreditService {
    private static final Logger logger = LoggerFactory.getLogger(UserCreditService.class);
    @Autowired
    private UserCreditRiskMapper userCreditRiskMapper;

//    @Transactional("transactionManagerLoandb")
//    public void addGfdCreditRisk(UserCreditRisk userCreditRisk) {
//        checkNotNull(userCreditRisk);
//        checkState(Strings.isNullOrEmpty(userCreditRisk.getProductCode())
//                        || AppEnum.GFD.getProducts().stream().anyMatch(productEnum -> productEnum.getCode().equals(userCreditRisk.getProductCode())),
//                "授信数据不是GFD的产品");
//
//        UserCreditRisk source = getGfdCreditRiskByUserIdAndProductCode(userCreditRisk.getUserId(), userCreditRisk.getProductCode());
//        doAddCreditRisk(userCreditRisk, source);
//    }



    public UserCreditRisk getGfdCreditRiskByUserIdAndProductCode(int userId, String productCode) {
        UserCreditRiskCriteria userCreditRiskCriteria = new UserCreditRiskCriteria();
        userCreditRiskCriteria.createCriteria().andUserIdEqualTo(userId)
                .andProductCodeEqualTo(productCode);

        List<UserCreditRisk> userCreditRiskList = userCreditRiskMapper.selectByExample(userCreditRiskCriteria);
        if (null == userCreditRiskList || 0 == userCreditRiskList.size()) {
            return null;
        }
        return userCreditRiskList.get(0);
    }


    public UserCreditRisk getGfdCreditRiskByUserId(Integer userId) {
        UserCreditRiskCriteria creditRiskCriteria = new UserCreditRiskCriteria();
        creditRiskCriteria.createCriteria().andUserIdEqualTo(userId);
        creditRiskCriteria.setOrderByClause("LastUpdateDate desc limit 1");
        List<UserCreditRisk> userCreditRiskList = userCreditRiskMapper.selectByExample(creditRiskCriteria);
        if (null == userCreditRiskList || 0 == userCreditRiskList.size()) {
            return null;
        }
        return userCreditRiskList.get(0);
    }

    public void updateCreditRiskRecordByUserId(Integer userId,Byte manualAuditResult) {
        UserCreditRiskCriteria creditRiskCriteria = new UserCreditRiskCriteria();
        creditRiskCriteria.createCriteria().andUserIdEqualTo(userId);
        UserCreditRisk riskUpdate = new UserCreditRisk();
        riskUpdate.setMannualAuditResult(manualAuditResult);
        userCreditRiskMapper.updateByExampleSelective(riskUpdate,creditRiskCriteria);
    }

}
