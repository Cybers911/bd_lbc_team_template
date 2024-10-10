package com.eduardo.project.dynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.eduardo.project.exceptions.PestNotFoundException;
import com.eduardo.project.models.CornPest;

import javax.inject.Inject;
import java.util.List;

public class CornPestDAO {

    private final DynamoDBMapper dynamoDbMapper;

    @Inject
    public CornPestDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public CornPest getCornPest(String pestId) {
        CornPest pest = dynamoDbMapper.load(CornPest.class, pestId);
        if (pest == null) {
            throw new PestNotFoundException("Corn pest with ID " + pestId + " not found.");
        }
        return pest;
    }

    public List<CornPest> getAllPests() {
        // Implementation to scan all pests from the DynamoDB table

        // Example implementation using DynamoDBMapper's scan operation
        return dynamoDbMapper.scan(CornPest.class).getItems();

    }


    public void saveCornPest(CornPest pest) {
        dynamoDbMapper.save(pest);
    }

    public void updateCornPest(String pestId, String pestName) {
        CornPest pest = getCornPest(pestId);
        pest.setPestName(pestName);
        saveCornPest(pest);
    }
}
