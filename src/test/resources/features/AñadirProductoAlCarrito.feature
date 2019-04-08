@uno
Feature: Añardir producto al carrito de compras
  Daniel quiere añadir el producto seleccionado al carrito de compras

  @smokeTest
  Scenario Outline: Añardir producto al carrito de compras
    Given Daniel selecciono el producto con la posicion "<posicionProducto>" que desea comprar 
    When Daniel agrega el producto al carrito con las caracteristicas
      | posicionTalla   | posicionColor   | cantidad   |
      | <posicionTalla> | <posicionColor> | <cantidad> |
    Then Daniel verifica que el precio "<precio>" corresponde al del carrito de compras

    Examples: 
      | posicionProducto | posicionTalla | posicionColor | cantidad | precio |
      |                0 |             0 |             2 |        1 | €59.57 |
