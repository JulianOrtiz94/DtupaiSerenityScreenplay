@uno
Feature: Buscar Producto
  Daniel quiere buscar un producto

  @smokeTest
  Scenario Outline: Buscar un producto
    Given Daniel esta en la pagina principal de Dtupai
    When Daniel busca un producto "<producto>"
    Then Daniel verifica que el podructo "<resultadoEsperado>" este en los resultados

    Examples: 
      | producto   | resultadoEsperado |
      | zapatillas | zapatillas        |
