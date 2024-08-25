describe('App Navigation and Content', () => {
  beforeEach(() => {
    cy.visit('/');
  });

  it('should display the welcome message on the home page', () => {
    cy.contains('¡Bienvenido a la página de los coches!').should('be.visible');
  });

  it('should navigate to the Coches page and display the table', () => {
    cy.contains('Coches').click();
    cy.url().should('include', '/coches');
    cy.get('table').should('be.visible');
    cy.get('th').contains('Fabricante').should('be.visible');
    cy.get('th').contains('Modelo').should('be.visible');
    cy.get('th').contains('Año').should('be.visible');
  });

  it('should display car data in the table', () => {
    cy.contains('Coches').click();
    cy.url().should('include', '/coches');
    cy.get('tbody tr').should('have.length.greaterThan', 0);
  });
});