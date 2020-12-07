package com.kopranych.barbershop.appointments.repository

import com.kopranych.barbershop.appointments.model.dao.Appointment
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import java.time.Instant

interface AppointmentsRepository : PagingAndSortingRepository<Appointment, Long> {
  fun findAllByBarberIdAndDateBetween(barberId: Long, pageable: Pageable, start: Instant, end: Instant): Page<Appointment>
}