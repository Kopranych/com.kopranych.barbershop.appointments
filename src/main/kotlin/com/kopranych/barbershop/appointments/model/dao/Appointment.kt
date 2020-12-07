package com.kopranych.barbershop.appointments.model.dao

import java.math.BigDecimal
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

data class Appointment(
    @Id
    val id: Long,
    val clientId: Long,
    val barberId: Long,
    val date: Instant,
    val typeService: TypeService,
    val status: AppointmentStatus,
    val price: BigDecimal
    ) {
}