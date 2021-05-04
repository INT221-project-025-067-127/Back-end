package int221.project.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String id;
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

    @MapsId("brand_brand_id")
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private Brand brand;

}
