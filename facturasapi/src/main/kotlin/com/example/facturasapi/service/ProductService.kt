package com.example.facturasapi.controller

import com.example.facturasapi.model.Product
import com.example.facturasapi.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository



    fun list ():List<Product>{
        return productRepository.findAll()
    }

    fun save (product: Product):Product{
      try {
        product.stock?.takeIf { it > 0}
          ?: throw Exception("Error Placa")



//client.fullname?.takeIf { it.stock > 0 }
        //              ?: throw Exception("fullname no debe ser vacio")
        return productRepository.save(product)
    }
      catch(ex:Exception){
        throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
      }
    }

    fun update(product: Product):Product{
        try {
            productRepository.findById(product.id)
                ?: throw Exception("El id ${product.id} en producto no existe")
            return productRepository.save(product)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateTotal(product: Product):Product{
        try{
            val response = productRepository.findById(product.id)
                ?:throw Exception("El ${product.id} en producto no existe")
            return productRepository.save(product)
            response.apply{
                stock = product.stock
                price = product.price
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }
    var product= Product().apply{
        id=1
        description="UBA-5389"
        brand="Cañar"

        id=2
        description="AMl-8977"
        brand="Azuay"

        id=3
        description= "PKN-7823"
        brand="Pichincha"
    }

}


