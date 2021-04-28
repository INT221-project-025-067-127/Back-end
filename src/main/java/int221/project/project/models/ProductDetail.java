package int221.project.project.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quantity")
public class ProductDetail implements Serializable {
    private int amount;
    @Id
    private String productId;
    @Id
    private String colorId;
    @Id
    private String sizeId;
    @Id
    private String imageId;
}
