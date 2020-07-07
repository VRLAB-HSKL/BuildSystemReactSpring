package com.hskl.buildsystem.dal;


import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UnityPlatformConfigurationDataImpl implements DALUnityPlatformConfigurationData{

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SequenceGeneratorService seqService;
}
