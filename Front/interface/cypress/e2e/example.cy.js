// cypress/integration/select-cars.spec.js

describe('Select Cars Test', () => {
  it('should select cars and display them in the detail table', () => {
    // Visitar la página de DataTable
    cy.visit('/data');

    // Esperar a que los datos se carguen
    cy.intercept('GET', '/coches').as('getAllCars');
    cy.wait('@getAllCars', { timeout: 10000 }); // Aumentar el tiempo de espera a 10 segundos

    // Seleccionar los coches
    cy.get('tbody tr').eq(0).find('input[type="checkbox"]').check();
    cy.get('tbody tr').eq(1).find('input[type="checkbox"]').check();

    // Hacer clic en el botón para actualizar los coches seleccionados
    cy.contains('button', 'Actualizar autos seleccionados').click();

    // Verificar que la URL cambió a /details
    cy.url().should('include', '/details');

    // Verificar que los coches seleccionados se muestran en la tabla de detalles
    cy.get('tbody tr').should('have.length', 2);

    // Verificar que las columnas Make, Model y Year están presentes y la columna ID no está
    cy.get('thead tr th').should('have.length', 3);
    cy.get('thead tr th').eq(0).should('contain', 'Make');
    cy.get('thead tr th').eq(1).should('contain', 'Model');
    cy.get('thead tr th').eq(2).should('contain', 'Year');
  });
});