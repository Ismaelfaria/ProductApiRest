package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Table(name="product")
@Entity(name="product")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

	@Id
	@GeneratedValue
	(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;
    
	public String getName() {
		return name;}
	public void setName(String name) {
		this.name = name;}
	public Integer getPrice_in_cents() {
		return price_in_cents;}
	public void setPrice_in_cents(Integer price_in_cents) {
		this.price_in_cents = price_in_cents;}
	
    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
	
}
