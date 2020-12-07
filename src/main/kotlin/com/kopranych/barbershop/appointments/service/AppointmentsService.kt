package com.kopranych.barbershop.appointments.service

import com.kopranych.barbershop.appointments.model.dao.Appointment
import com.kopranych.barbershop.appointments.repository.AppointmentsRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset

@Service
class AppointmentsService(val appointmentsRepository: AppointmentsRepository) {
  fun get(barberId: Long, pageable: Pageable, startDate: LocalDate, endDate: LocalDate): Page<Appointment> {
    val startInstant = startDate.atStartOfDay().toInstant(ZoneOffset.UTC)
    val endInstant = endDate.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC)
    return appointmentsRepository
        .findAllByBarberIdAndDateBetween(barberId, pageable, startInstant, endInstant)
  }

  fun save(appointment: Appointment) {
    appointmentsRepository.save(appointment)
  }

  fun update(appointment: Appointment) {
    appointmentsRepository.findById(appointment.id).let {
      appointmentsRepository.save(appointment)
    }
  }

}
