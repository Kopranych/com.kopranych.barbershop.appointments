package com.kopranych.barbershop.appointments.model.dto

import com.kopranych.barbershop.appointments.model.dao.AppointmentStatus
import com.kopranych.barbershop.appointments.model.dao.TypeService
import java.math.BigDecimal
import java.time.Instant

data class AppointmentDto (
  val id: Long,
  val clientId: Long,
  val barberId: Long,
  val date: Instant,
  val typeService: TypeService,
  val status: AppointmentStatus,
  val price: BigDecimal
){

}
