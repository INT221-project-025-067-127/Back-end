package int221.project.project.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quantity")
public class ProductDetail {
    @EmbeddedId
    private ProductDetailId productDetailId;

    @Column(name = "amount")
    private int amount;

}
