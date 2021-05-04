package int221.project.project.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductInfo {
    @Id
    @JsonIgnore
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "description")
    private String description;
    @Column(name = "brand_brand_id")
    @JsonIgnore
    private String brandId;

    @ManyToOne
    @JoinColumn(name = "brand_brand_id", insertable = false, updatable = false)
    private Brand brand;

    @OneToMany
    @JoinColumn(name = "product_product_id")
    // @NotFound(action = NotFoundAction.IGNORE)
    private List<Quantity> quantity;

    @OneToMany
    @JoinColumn(name = "product_product_id")
    // @NotFound(action = NotFoundAction.IGNORE)
    private List<Image> images;
}
