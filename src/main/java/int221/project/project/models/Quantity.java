package int221.project.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quantity")
@Entity
public class Quantity {
    @Id
    // @JsonIgnore
    private ProductDetailId id;

    @Column(name = "amount")
    private int amount;

    @MapsId("colorId")
    @ManyToOne
    @JoinColumn(name = "color_color_id", insertable = false, updatable = false)
    private Color color;

    // @MapsId("imageId")
    // @ManyToOne
    // @JoinColumn(name = "product_image_image_id")
    // private Image image;

    @MapsId("sizeId")
    @ManyToOne
    @JoinColumn(name = "product_size_size_id", insertable = false, updatable = false)
    private Size size;
}
