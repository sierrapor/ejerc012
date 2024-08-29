describe('Coche Detalle Page', () => {
  beforeEach(() => {
      cy.intercept('GET', '/api/coches/1', { fixture: 'coche.json' }).as('getCoche');
      cy.visit('/coche-detalle/1');
      cy.wait('@getCoche');
  });

  it('should display coche details', () => {
      cy.get('p').contains('Fabricante: Toyota');
      cy.get('p').contains('Modelo: Corolla');
      cy.get('p').contains('Año: 2020');
  });

  it('should navigate back to coches list', () => {
      cy.get('button').contains('Volver').click();
      cy.url().should('include', '/coches');
  });
});