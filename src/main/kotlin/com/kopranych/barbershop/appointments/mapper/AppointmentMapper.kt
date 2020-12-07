package com.kopranych.barbershop.appointments.mapper

import com.kopranych.barbershop.appointments.model.dao.Appointment
import com.kopranych.barbershop.appointments.model.dto.AppointmentDto
import org.mapstruct.Mapper

@Mapper
interface AppointmentMapper {
  fun map(client: Appointment): AppointmentDto
  fun map(clientDto: AppointmentDto): Appointment
}