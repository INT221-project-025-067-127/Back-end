package int221.project.project.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.beans.factory.annotation.Autowired;

import int221.project.project.repositories.ProductRepository;
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
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ProductDetailId productDetailId;

    @Column(name = "amount")
    private int amount;

    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "product_product_id", insertable = false, updatable = false)
    private Product product;

    @MapsId("colorId")
    @ManyToOne
    @JoinColumn(name = "color_color_id", insertable = false, updatable = false)
    private Color color;

    @MapsId("imageId")
    @ManyToOne
    @JoinColumn(name = "product_image_image_id")
    private Image image;

    @MapsId("sizeId")
    @ManyToOne
    @JoinColumn(name = "product_size_size_id", insertable = false, updatable = false)
    private Size size;
}
