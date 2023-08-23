package co.com.umano.model.umanoproduct;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class UmanoRequest {
    private String storeId;
    private String id;
}
