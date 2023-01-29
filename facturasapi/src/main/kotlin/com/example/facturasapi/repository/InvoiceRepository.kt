package com.example.facturasapi.repository

import com.example.facturasapi.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository: JpaRepository <Invoice, Long> {

    fun findById(id: Long?):Invoice?
}
