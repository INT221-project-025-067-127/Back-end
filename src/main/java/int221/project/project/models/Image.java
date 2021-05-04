package int221.project.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_image")
public class Image {
    @Id
    @JsonIgnore
    @Column(name = "image_id")
    private String id;
    @Column(name = "image")
    private String imageName;
}
