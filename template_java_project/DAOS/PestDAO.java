package bd_lbc_team_template.template_java_project.DAOS;

// Import AWS SDK for DynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;


public class PestDAO {
    private DynamoDB dynamoDB;
    private Table table;

    // Constructor that accepts the table name for dynamic table selection
    public PestDAO(String tableName) {
    this.dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder.defaultClient());
    this.table = dynamoDB.getTable(tableName);
}

// Retrieve a pest by its ID
public Item getPest(String pestId) {
    GetItemSpec spec = new GetItemSpec().withPrimaryKey("PestID", pestId);
    return table.getItem(spec);
}

// Add a new pest to the table
public void addPest(String pestId, String pestName) {
    Item newItem = new Item()
        .withPrimaryKey("PestID", pestId)
        .withString("PestName", pestName);

    PutItemSpec putSpec = new PutItemSpec().withItem(newItem);
    table.putItem(putSpec);
}

// Update an existing pest's name
public void updatePest(String pestId, String pestName) {
    UpdateItemSpec updateSpec = new UpdateItemSpec()
        .withPrimaryKey("PestID", pestId)
        .withUpdateExpression("set PestName = :name")
        .withValueMap(new ValueMap().withString(":name", pestName))
        .withReturnValues(ReturnValue.UPDATED_NEW);

    table.updateItem(updateSpec);
}
}
