
package com.notification_service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {

  private String eventType; // Tipo de evento (e.g., "TASK_ASSIGNED", "TASK_COMPLETED")
  private String recipient; // Usuario que recibirá la notificación (e.g., correo o ID)
  private String message; // Contenido del mensaje (e.g., "Tarea asignada: Revisar informes")
}
