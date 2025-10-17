Feature: Busqueda tarjeta grafica
  Scenario: Realizar una busqueda dentro de la pagina de una tarjeta grafica Nvidia
    Given al navegar hasta la url "https://www.spdigital.cl/"
    When coloco en el campo de busqueda "//input[contains(@class,'Fractal-SearchBar--searchbar')]" el valor de "Tarjeta de Video GIGABYTE GeForce RTX 5070 TI"
    And debo realizar un clic en el resultado "(//a[contains(@class,'Fractal-Link--link  Common-module--productPreview--GTtiZ')])[6]"
    And obtengo el precio de la tarjeta en "(//div[@class='product-detail-module--payments--vheAN']/span/span[contains(@class,'Fractal-Price--price')])[2]"
    Then el ingreso a la pagina web a sido existoso