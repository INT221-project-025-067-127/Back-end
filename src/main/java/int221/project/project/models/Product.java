package int221.project.project.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    private String id;
    String name;
    Double price;
    Date releaseDate;
    String description;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "brands_id")
    Brand brand;
}
