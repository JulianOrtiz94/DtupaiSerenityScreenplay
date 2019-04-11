@dos
Feature: Seleccionar un producto
  Daniel quiere seleccionar un producto de la lista de resultados

  @smokeTest
  Scenario: Seleccionar un producto de la lista de resultados
    Given Daniel realizo la busqueda del producto
    When el seleccione el producto "1"
    Then el verifica que el podructo seleccionado "2016 Hombres Zapatos Zapatillas Hombre Calzado Zapatos Corrientes De Los Hombres Zapatillas Deportivas Running Hombre Zapatos Hombre QHUY981499" sea el correcto
