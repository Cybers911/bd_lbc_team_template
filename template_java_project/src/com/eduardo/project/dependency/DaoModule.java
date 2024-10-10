package com.eduardo.project.dependency;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.eduardo.project.dynamoDB.CornPestDAO;
import com.eduardo.project.dynamoDB.WheatPestDAO;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {

    @Singleton
    @Provides
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2));
    }

    @Singleton
    @Provides
    public CornPestDAO provideCornPestDAO(DynamoDBMapper dynamoDBMapper) {
        return new CornPestDAO(dynamoDBMapper);
    }

    @Singleton
    @Provides
    public WheatPestDAO provideWheatPestDAO(DynamoDBMapper dynamoDBMapper) {
        return new WheatPestDAO(dynamoDBMapper);
    }
}
