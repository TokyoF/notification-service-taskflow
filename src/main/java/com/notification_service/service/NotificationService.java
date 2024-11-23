
package com.notification_service.service;

import com.notification_service.dto.NotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

  /**
   * Procesa y envía la notificación basada en el evento recibido.
   * 
   * @param event Evento de notificación recibido desde Kafka.
   */
  public void sendNotification(NotificationEvent event) {
    System.out.println("Procesando notificación: " + event);
    log.info("Procesando notificación: {}", event);

    // Determina el canal según el tipo de evento (puedes agregar lógica más
    // avanzada aquí)
    switch (event.getEventType()) {
      case "TASK_ASSIGNED":
        sendEmail(event.getRecipient(), event.getMessage());
        break;
      case "TASK_COMPLETED":
        sendPushNotification(event.getRecipient(), event.getMessage());
        break;
      default:
        log.warn("Tipo de evento no reconocido: {}", event.getEventType());
    }
  }

  /**
   * Simula el envío de un correo electrónico.
   * 
   * @param recipient Destinatario del correo.
   * @param message   Contenido del correo.
   */
  private void sendEmail(String recipient, String message) {
    log.info("Enviando correo a {}: {}", recipient, message);
    // Lógica para enviar correos (puedes integrar una librería como JavaMail)
  }

  /**
   * Simula el envío de una notificación push.
   * 
   * @param recipient Destinatario de la notificación.
   * @param message   Contenido de la notificación.
   */
  private void sendPushNotification(String recipient, String message) {
    log.info("Enviando notificación push a {}: {}", recipient, message);
    // Lógica para enviar notificaciones push (puedes integrar un servicio como
    // Firebase)
  }
}
