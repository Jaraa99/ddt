package com.example.facturasapi.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name="product")
class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    @NotBlank(message="Campo obligatorio")  //validate
    var brand: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    var stock: Long? = null
    var price: Double? =null
}