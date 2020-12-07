package com.kopranych.barbershop.appointments.controller

import com.kopranych.barbershop.appointments.mapper.AppointmentMapper
import com.kopranych.barbershop.appointments.model.dto.AppointmentDto
import com.kopranych.barbershop.appointments.model.exception.BadRequestException
import com.kopranych.barbershop.appointments.service.AppointmentsService
import org.mapstruct.factory.Mappers
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
class AppointmentsController(val appointmentsService: AppointmentsService) {

  val mapper: AppointmentMapper = Mappers.getMapper(AppointmentMapper::class.java)

  @GetMapping
  fun get(
      @RequestParam barberId: Long,
      @RequestParam page: Int,
      @RequestParam size: Int,
      @RequestParam(required = false) startDate: LocalDate?,
      @RequestParam(required = false) endDate: LocalDate?,
      @RequestParam(defaultValue = "DESC") sortBy: Sort.Direction
  ): Page<AppointmentDto> {
    val start: LocalDate = startDate ?: LocalDate.now()
    val end: LocalDate = endDate ?: LocalDate.now()

    if (start.isAfter(end))
      throw BadRequestException("Incorrect date parameters startDate: $startDate, endDate: $endDate")

    return appointmentsService.get(
        barberId, PageRequest.of(page, size, sortBy, "date"), start, end
    )
        .map { mapper.map(it) }
  }

  @PostMapping
  fun save(@RequestBody appointmentDto: AppointmentDto) {
    appointmentsService.save(mapper.map(appointmentDto))
  }

  @PutMapping
  fun update(@RequestBody appointmentDto: AppointmentDto) {
    appointmentsService.update(mapper.map(appointmentDto))
  }
}