package com.kopranych.barbershop.appointments.model.exception

import org.springframework.http.HttpStatus

class NotFoundException : HttpException {
  constructor(message: String?, detailed: String?) : super(HttpStatus.NOT_FOUND, message!!, detailed!!)
  constructor(message: String?) : super(HttpStatus.NOT_FOUND, message!!, "")
}