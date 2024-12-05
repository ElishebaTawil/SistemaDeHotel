# SistemaDeHotel
sistema en java con POO de gestion de las reservas de las habitaciones del hotel
CONTEXTO
Hemos sido contratados para diseñar y desarrollar un sistema de administración de
hoteles para Argentina.
RELEVAMIENTO
Los gerentes de hoteles utilizarán nuestro sistema para seguir las habitaciones y
clientes a través de un único portal. Para esto podrá publicar habitaciones disponibles y
generar facturas. También permitirá a clientes buscar y reservar habitaciones.
Tanto gerentes desde el hotel como clientes desde el sitio web podrán reservar
habitaciones. Para ello se deberá poder filtrar por cantidad de personas, tipo
(habitación, suite) y extras (servicio despertador, TV, Internet, mini bar). Se deberá
asegurar que una habitación no pueda ser reservada dos veces. La reserva indicará
fecha de check in y check out, cliente registrado, detalle de huéspedes (nombre,
apellido y DNI), medio de pago (transferencia, tarjeta de crédito, tarjeta de débito,
efectivo), y estado (pendiente de pago, pagada, cancelada).
El monto de la reserva será calculado según la proximidad de la fecha de reserva, el
tipo de habitación, y los extras. Por defecto, si la reserva se efectúa 15 días antes de la
reserva, el precio será un 15% inferior al precio base. Si la reserva se efectúa con más
de dos meses de anticipación, entonces el precio será 20% superior al precio base. No
obstante, estos valores pueden ser modificados por el gerente del hotel a discreción.
Además, a futuro podrían agregarse otras políticas de precio con relación a la
antelación de la fecha de reserva.
Por cada cliente se registra su nombre, apellido, DNI, teléfono, email y preferencia de
contacto (SMS, WhatsApp, email). Cuando se generan las facturas al recibir el pago
por una reserva, la misma se envía por el medio de contacto seleccionado. El pago de
reservas es gestionado por MercadoPago, un servicio externo a nuestro sistema. Si no
se registra un pago pasadas las 24 horas de reserva, el sistema cancelará la reserva
automáticamente.
Todos los cambios que sufre una reserva serán notificados a los clientes (reserva
registrada, pagada, cancelada) por el medio que haya indicado al registrarse. A su vez,
estos cambios también deberán ser loggeados para informar al área contable acerca de
los pagos de reservas. También al área de marketing, ya que utilizarán esta información
para elaborar un perfil y luego enviar publicidades y promociones.
Cabe destacar que nuestro sistema deberá interactuar con varios sistemas externos
que suelen tener los hoteles, como sistemas contables y de marketing. Por esta razón,
todas las funcionalidades que ofrezcamos deberán ser fácilmente accedidas por otros
sistemas.
ALCANCE Y REQUERMIENTOS
El sistema deberá permitir:
• Cargar nuevos clientes.
• Cargar habitaciones y disponibilidad.
• Buscar habitaciones según el criterio solicitado y mostrar datos completos.
• Reservar y cancelar habitaciones presencialmente o vía web.
• Actualizar parámetros de facturación (plazo en días y porcentaje de variación).
• Enviar facturas y notificaciones a clientes.
• Generar un reporte del estado de las habitaciones del hotel (reservadas,
disponibles).
• Loggear cambios de reservas para el área contable y enviar información sobre
cambios de reservas al área de marketing.

