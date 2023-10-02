package co.com.umano.dynamodb.helper;

import co.com.umano.dynamodb.DynamoDBTemplateAdapter;
import co.com.umano.dynamodb.UmanoProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import reactor.test.StepVerifier;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TemplateAdapterOperationsTest {

    @Mock
    private DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient;

    @Mock
    private ObjectMapper mapper;

    @Mock
    private DynamoDbAsyncTable<UmanoProductEntity> customerTable;

    private UmanoProductEntity umanoProductEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(dynamoDbEnhancedAsyncClient.table("table_name", TableSchema.fromBean(UmanoProductEntity.class)))
                .thenReturn(customerTable);

        umanoProductEntity = new UmanoProductEntity();
        umanoProductEntity.setId("id");
        umanoProductEntity.setAtr1("atr1");
    }

    @Test
    void modelEntityPropertiesMustNotBeNull() {
        UmanoProductEntity umanoProductEntityUnderTest = new UmanoProductEntity("id", "atr1");

        assertNotNull(umanoProductEntityUnderTest.getId());
        assertNotNull(umanoProductEntityUnderTest.getAtr1());
    }

    @Test
    void testSave() {
        when(customerTable.putItem(umanoProductEntity)).thenReturn(CompletableFuture.runAsync(()->{}));
        when(mapper.map(umanoProductEntity, UmanoProductEntity.class)).thenReturn(umanoProductEntity);

        DynamoDBTemplateAdapter dynamoDBTemplateAdapter =
                new DynamoDBTemplateAdapter(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapter.save(umanoProductEntity))
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void testGetById() {
        String id = "id";

        when(customerTable.getItem(
                Key.builder().partitionValue(AttributeValue.builder().s(id).build()).build()))
                .thenReturn(CompletableFuture.completedFuture(umanoProductEntity));
        when(mapper.map(umanoProductEntity, Object.class)).thenReturn("value");

        DynamoDBTemplateAdapter dynamoDBTemplateAdapter =
                new DynamoDBTemplateAdapter(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapter.getById("id"))
                .expectNext("value")
                .verifyComplete();
    }

    @Test
    void testDelete() {
        when(mapper.map(umanoProductEntity, UmanoProductEntity.class)).thenReturn(umanoProductEntity);
        when(mapper.map(umanoProductEntity, Object.class)).thenReturn("value");

        when(customerTable.deleteItem(umanoProductEntity))
                .thenReturn(CompletableFuture.completedFuture(umanoProductEntity));

        DynamoDBTemplateAdapter dynamoDBTemplateAdapter =
                new DynamoDBTemplateAdapter(dynamoDbEnhancedAsyncClient, mapper);

        StepVerifier.create(dynamoDBTemplateAdapter.delete(umanoProductEntity))
                .expectNext("value")
                .verifyComplete();
    }
}