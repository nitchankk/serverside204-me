package sit.int204.classicmodelservice.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerySimpleProductDTO {
    private String productCode;
    private String productName;
    private Double price;
}
