Feature: Gestión de productos

  @carrito
  Scenario Outline: validar compras agregadas al carrito exitosamente
    Given estoy en la aplicacion SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto <PRODUCTO>
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                   | UNIDADES |
      | Sauce Labs Backpack        | 1        |
      | Sauce Labs Bolt - T Shirt1 | 1        |
      | Sauce Labs Bike Ligth      | 1        |

