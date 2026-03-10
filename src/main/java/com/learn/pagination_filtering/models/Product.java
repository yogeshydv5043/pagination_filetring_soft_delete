package com.learn.pagination_filtering.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
@Entity
@Getter
@Setter
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET is_deleted = true, deleted_at = now() WHERE id=?")
//@SQLRestriction("IS_DELETED = false")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotNull(message = "Category is required")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}