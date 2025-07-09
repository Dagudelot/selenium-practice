@all
Feature: Interactuar con elementos de la web

  @smoke @chrome
  Scenario: Usuario interactua con alertas
    Given el usuario navega a la web
    And se dirige a la pestaña de alertas
    When acepta una alerta emergente
    Then la alerta se cierra


    @regression @firefox
  Scenario: Usuario interactua con boton
    Given el usuario navega a la web
    And se dirige a la pestaña de botones
    When da doble clic sobre un boton
    Then una mensaje se muestra con el texto "You have done a double click"