package com.eduardo.project.dependency;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.eduardo.project.dynamoDB.DynamoDbClientProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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
        AmazonDynamoDB amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(Regions.US_WEST_2)
                .build();

        return new DynamoDBMapper(amazonDynamoDBClient);
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
