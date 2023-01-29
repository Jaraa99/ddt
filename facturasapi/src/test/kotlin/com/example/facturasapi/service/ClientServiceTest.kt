package com.example.facturasapi.service

import com.example.facturasapi.model.Client
import com.example.facturasapi.repository.ClientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ClientServiceTest {

  @InjectMocks
  lateinit var clientService: ClientService

  @Mock
  lateinit var  clientRepository: ClientRepository

  var clientMock = Client().apply{
    id=1
    nui="0150289320"
    fullname="David Bermeo"
    addrees="Cuenca"
  }

  @Test
  fun saveClientCorrect(){
    Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
    val response = clientService.save(clientMock)
    Assertions.assertEquals(response?.id, clientMock.id)
  }

  @Test
  fun saveClientWhenFullnameIsBlank(){

    Assertions.assertThrows(Exception::class.java) {
      clientMock.apply { fullname=" "}
      Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
      clientService.save(clientMock)
    }

  }
}


