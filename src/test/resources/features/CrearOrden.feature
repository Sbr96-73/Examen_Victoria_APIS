Feature: Crear una orden en PetStore


  @crearOrden
  Scenario Outline: Crear una orden exitosamente

    Given estoy en el formulario
    When creo la orden con id <id> Mascota <petId>, con cantidad <quantity> y fecha "<shipDate>"
    Then el sistema me da como respuesta 200
    And la orden muestra el id <id> y status "<status>"

    Examples:
    |      id | petId  | quantity |         shipDate   | status |
    |10000001 | 199928 | 1        |2025-10-06T10:00:00Z| placed |
    |10000002 | 199929 | 2        |2025-10-06T10:00:00Z| placed |