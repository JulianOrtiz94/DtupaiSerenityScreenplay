@uno
Feature: Buscar Producto
  Daniel quiere buscar un producto

  @smokeTest
  Scenario Outline: Buscar un producto
    Given Daniel esta en la pagina principal de Dtupai
    When el busca un producto "<producto>"
    Then el verifica que el podructo "<resultadoEsperado>" este en los resultados

    Examples: 
      | producto   | resultadoEsperado |
      | zapatillas | zapatillas        |
