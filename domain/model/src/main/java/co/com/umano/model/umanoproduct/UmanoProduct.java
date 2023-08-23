package co.com.umano.model.umanoproduct;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class UmanoProduct {
    private String productId;
    private String name;
    private String category;
    private String subCategory;
    private String description;
    private Integer price;
    private String size;
    private Integer quantity;
    private String storeId;

}
