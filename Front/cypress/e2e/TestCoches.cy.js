describe('template spec', () => {
  beforeEach(() => {
    cy.intercept('GET', '/api/coches', { fixture: 'coches.json' }).as('getCoches');
    cy.visit('/coches');
    cy.wait('@getCoches');
});

it('should display a list of coches', () => {
    cy.get('table tbody tr').should('have.length', 3); // Assuming the fixture has 3 coches
});

it('should navigate to create coche form', () => {
    cy.get('button').contains('Crear Coche').click();
    cy.url().should('include', '/coche-form');
});

it('should navigate to edit coche form', () => {
    cy.get('table tbody tr').first().find('button').contains('Editar').click();
    cy.url().should('include', '/coche-form/1'); // Assuming the first coche has id 1
});

it('should delete a coche', () => {
    cy.intercept('DELETE', '/api/coches/1', {}).as('deleteCoche');
    cy.get('table tbody tr').first().find('button').contains('Eliminar').click();
    cy.wait('@deleteCoche');

});
})