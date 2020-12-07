package com.kopranych.barbershop.appointments.model.exception

import org.springframework.http.HttpStatus

class BadRequestException : HttpException {
  constructor(message: String?, detailed: String?) : super(HttpStatus.BAD_REQUEST, message!!, detailed!!) {}
  constructor(message: String?) : super(HttpStatus.BAD_REQUEST, message!!, "") {}
}