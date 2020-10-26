package com.aldt.test.service.loanCollecation;

import com.aldt.test.dao.domain.loanCollection.CollectionCase;
import com.aldt.test.dao.mapper.loanCollection.CollectionCaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhf2015 on 2020-10-23.
 */

@Service
public class CollectionCaseServer {

    @Autowired
    private CollectionCaseMapper collectionCaseMapper;


    public CollectionCase getCollCaseById(Integer id){
        return collectionCaseMapper.selectByPrimaryKey(id);
    }
}
