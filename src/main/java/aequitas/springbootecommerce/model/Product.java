package aequitas.springbootecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="product")
@Data                       // automatikusan generál gettert, és settert a háttérben -->> Lombok dependencia
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="sku")
  private String sku;

  @Column(name="name")
  private String name;

  @Column(name="description")
  private String description;

  @Column(name="unit_price")
  private BigDecimal unitPrice;

  @Column(name="image_url")
  private String imageUrl;

  @Column(name="active")
  private boolean active;

  @Column(name="unit_in_stock")
  private int unitInStock;

  @Column(name="date_created")
  @CreationTimestamp               // a Hibernate automatikusan kezeli a dátumozást
  private Date dateCreated;

  @Column(name="last_updated")
  @UpdateTimestamp                 // a Hibernate automatikusan kezeli a dátumozást
  private Date lastUpdated;


}
