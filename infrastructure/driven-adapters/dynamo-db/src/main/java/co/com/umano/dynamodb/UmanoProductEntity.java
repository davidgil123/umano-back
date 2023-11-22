package co.com.umano.dynamodb;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@DynamoDbBean
@Setter
@Getter
public class UmanoProductEntity {

    private String productId;
    private String name;
    private String category;
    private String subCategory;
    private String description;
    private Integer price;
    private String size;
    private Integer quantity;
    private String storeId;

    public UmanoProductEntity() {
    }

    public UmanoProductEntity(String productId, String name, String category, String subCategory, String description, Integer price, String size, Integer quantity, String storeId) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.storeId = storeId;
    }
@DynamoDbSortKey
    public String getProductId() {
        return productId;
    }
@DynamoDbPartitionKey
    public String getStoreId() {
        return storeId;
    }
}
