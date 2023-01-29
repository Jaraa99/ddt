package com.example.facturasapi.service

import com.example.facturasapi.model.Client
import com.example.facturasapi.model.Invoice
import com.example.facturasapi.repository.ClientRepository
import com.example.facturasapi.repository.InvoiceRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class InvoiceServiceTest {

  @InjectMocks
  lateinit var invoiceService: InvoiceService

  @Mock
  lateinit var invoiceRepository: InvoiceRepository

  @Mock
  lateinit var clientRepository: ClientRepository




  val jsonString = File("./src/test/resources/invoice.json").readText(Charsets.UTF_8)
  val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)

  var clientMock = Client().apply {
    id=1
    nui="0301707030"
    fullname="Juan"
    addrees= "Ceunca"
  }

  @Test
  fun saveInvoiceWhenIsCorrect(){
    Mockito.`when`(clientRepository.findById(invoiceMock.clientId)).thenReturn(clientMock)
    Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
    val response = invoiceService.save(invoiceMock)
    Assertions.assertEquals(response.id, invoiceMock.id)
  }



}

