package com.eduardo.project.dynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eduardo.project.exceptions.PestNotFoundException;
import com.eduardo.project.models.WheatPest;

import javax.inject.Inject;
import java.util.List;

public class WheatPestDAO {

    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public WheatPestDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public WheatPest getWheatPest(String pestId) {
        WheatPest pest = dynamoDbMapper.load(WheatPest.class, pestId);
        if (pest == null) {
            throw new PestNotFoundException("Wheat pest with ID " + pestId + " not found.");
        }
        return pest;
    }



    public List<WheatPest> getAllPests() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<WheatPest> pests = dynamoDbMapper.scan(WheatPest.class, scanExpression);
        return pests;
    }

    public void saveWheatPest(WheatPest pest) {
        dynamoDbMapper.save(pest);
    }



    public void updateWheatPest(String pestId, String pestName) {
        WheatPest pest = getWheatPest(pestId);
        pest.setPestName(pestName);
        saveWheatPest(pest);
    }
}

