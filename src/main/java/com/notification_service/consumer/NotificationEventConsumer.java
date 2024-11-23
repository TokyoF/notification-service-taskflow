
package com.notification_service.consumer;

import com.notification_service.dto.NotificationEvent;
import com.notification_service.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventConsumer {

  private final NotificationService notificationService;
  private final ObjectMapper objectMapper;

  /**
   * Escucha eventos desde Kafka y procesa las notificaciones.
   * 
   * @param message Mensaje en formato JSON recibido de Kafka.
   */
  @KafkaListener(topics = "notifications", groupId = "notification-service-group")
  public void consume(String message) {
    log.info("Mensaje recibido: {}", message);
    System.out.println("Mensaje recibido: " + message);
    try {
      // Deserializar el mensaje JSON en un NotificationEvent
      NotificationEvent event = objectMapper.readValue(message,
          NotificationEvent.class);

      // Lógica de procesamiento
      log.info("Evento recibido: {}", event);
      notificationService.sendNotification(event);
    } catch (Exception e) {
      log.error("Error procesando el mensaje: {}", message, e);
    }
  }
}
