Feature: Consultar Orden

  @consultaOrden

  Scenario Outline: Consultar Orden
    Given estoy en la pagina de Orden
    When hago la consulta de la orden con el id <id>
    Then el sistema da como respuesta es 200


    Examples:
      |      id |
      |10000001 |
      |10000002 |