@tres
Feature: Añardir producto al carrito de compras
  Daniel quiere añadir el producto seleccionado al carrito de compras

Background:
		Buscar un producto
    Given Daniel esta en la pagina principal de Dtupai
    When el busca un producto "zapatillas"
    Then el verifica que el podructo "zapatillas" este en los resultados
    
    Given Daniel realizo la busqueda del producto
    When el seleccione el producto "1"
    Then el verifica que el podructo seleccionado "2016 Hombres Zapatos Zapatillas Hombre Calzado Zapatos Corrientes De Los Hombres Zapatillas Deportivas Running Hombre Zapatos Hombre QHUY981499" sea el correcto
  
  
  Scenario Outline: Añardir producto al carrito de compras
    Given Daniel selecciono el producto con la posicion "<posicionProducto>" que desea comprar
    When el agrega el producto al carrito con las caracteristicas
      | posicionTalla   | posicionColor   | cantidad   |
      | <posicionTalla> | <posicionColor> | <cantidad> |
    Then el verifica que el precio "<precio>" corresponde al del carrito de compras

    Examples: 
      | posicionProducto | posicionTalla | posicionColor | cantidad | precio |
      |                0 |             0 |             2 |        1 |  59.57 |
