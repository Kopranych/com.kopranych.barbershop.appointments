package com.kopranych.barbershop.appointments.controller.advice

import com.kopranych.barbershop.clients.model.exception.ExceptionResponse
import com.kopranych.barbershop.clients.model.exception.NotFoundException
import com.kopranych.barbershop.clients.util.Logging
import org.apache.commons.lang.exception.ExceptionUtils.getStackTrace
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class ExceptionControllerAdvice : Logging {

  private val DEFAULT_MESSAGE = "Exception at {}"

  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException::class)
  fun handleNotFoundHttpException(request: HttpServletRequest, e: NotFoundException): ExceptionResponse {
    exceptionLog(request, e)
    return exceptionResponse(e)
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception::class)
  fun handleUnpredictedExceptions(request: HttpServletRequest, e: Exception): ExceptionResponse {
    exceptionLog(request, e)
    return exceptionResponse(e)
  }

  private fun exceptionLog(request: HttpServletRequest, e: Exception) {
    log.warn(DEFAULT_MESSAGE, request.requestURI, e)
  }

  private fun exceptionResponse(e: Exception) =
      ExceptionResponse(e.message, getStackTrace(e))
}
