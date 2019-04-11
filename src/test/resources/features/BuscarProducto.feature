@uno
Feature: Buscar Producto
  Daniel quiere buscar un producto

  @smokeTest
  Scenario: Buscar un producto
    Given Daniel esta en la pagina principal de Dtupai
    When el busca un producto "zapatillas"
    Then el verifica que el podructo "zapatillas" este en los resultados
