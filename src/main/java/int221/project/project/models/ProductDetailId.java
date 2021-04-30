package int221.project.project.models;

import java.io.Serializable;

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
    @ManyToOne
    private Color color;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_image_image_id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "product_size_size_id")
    private Size size;
}