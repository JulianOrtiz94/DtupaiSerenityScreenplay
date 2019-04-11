@dos
Feature: Seleccionar un producto
  Daniel quiere seleccionar un producto de la lista de resultados

  @smokeTest
  Scenario Outline: Seleccionar un producto de la lista de resultados
    Given Daniel realizo la busqueda del producto
    When el seleccione el producto "<posicion>"
    Then el verifica que el podructo seleccionado "<resultadoEsperado>" sea el correcto

    Examples: 
      | posicion | resultadoEsperado                                                                                                                               |
      |        0 | 18 Ouyilu Running Shoes Zapatos Mujer Zapatillas De Deporte Para Dames Zapatillas Schoenen Fly Line La Tela Cómoda Transpirable UROY210342F     |
      |        1 | 2016 Hombres Zapatos Zapatillas Hombre Calzado Zapatos Corrientes De Los Hombres Zapatillas Deportivas Running Hombre Zapatos Hombre QHUY981499 |
