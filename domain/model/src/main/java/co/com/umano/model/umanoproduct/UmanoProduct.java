package co.com.umano.model.umanoproduct;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class UmanoProduct {
    private String productId;
    private String name;
    private String category;
    private String subCategory;
    private String description;
    private Integer price;
    private Character size;
    private Integer quantity;
    private String storeId;

}
