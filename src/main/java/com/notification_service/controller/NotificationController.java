
package com.notification_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {

  /**
   * Endpoint para verificar el estado del servicio.
   * 
   * @return Estado actual del servicio.
   */
  @GetMapping("/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok("Notification Service is running.");
  }
}
