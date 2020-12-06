package com.kopranych.barbershop.appointments.model.dao

import java.time.Instant


data class Appointment(
    val id: Long,
    val clientId: Long,
    val barberId: Long,
    val date: Instant,
    val typeService: TypeService,
    val status: AppointmentStatus
    ) {
}