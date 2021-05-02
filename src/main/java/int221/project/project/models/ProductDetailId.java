package int221.project.project.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductDetailId implements Serializable {
    // @ManyToOne
    // private Color color;

    // @ManyToOne
    // private Product product;

    // @ManyToOne
    // @JoinColumn(name = "product_image_image_id")
    // private Image image;

    // @ManyToOne
    // @JoinColumn(name = "product_size_size_id")
    // private Size size;

    @Column(name = "color_color_id")
    private String colorId;
    @Column(name = "product_product_id")
    private String productId;
    @Column(name = "product_image_image_id")
    private String imageId;
    @Column(name = "product_size_size_id")
    private String sizeId;

}