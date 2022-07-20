describe('Shopping List Events Exercise Tests', () => {
  before(() => {
    cy.visit('/');
  });

  it('Must have a title of "My Shopping List"', () => {
    cy.get('h1').should('contain', 'My Shopping List');
  });

  it('Must have 10 items on the shopping list', () => {
    cy.get('li').should('have.length', 10);
  });

  it('Each item in the list must not have the class `completed` until clicked', () => {
    cy.get('li').each(($item) => {
      cy.wrap($item).should('not.have.class', 'completed');
      cy.wrap($item).click();
      cy.wrap($item).should('have.class', 'completed');
    });
  });

  it('Each item in the list that\'s completed can be double-clicked and marked incomplete', () => {
    cy.get('li').each(($item) => {
      cy.wrap($item).should('have.class', 'completed');
      cy.wrap($item).dblclick();
      cy.wrap($item).should('not.have.class', 'completed');
    });
  });

  it('Clicking on the \'Mark All Complete\' button must set all items to complete', () => {
    cy.get('#toggleAll').click();
    cy.get('li').each(($item) => {
      cy.wrap($item).should('have.class', 'completed');
    });
    cy.get('#toggleAll').should('contain', 'Mark All Incomplete');
  });

  it('Clicking on the \'Mark All Incomplete\' button must set all items to incomplete', () => {
    cy.get('#toggleAll').click();
    cy.get('li').each(($item) => {
      cy.wrap($item).should('not.have.class', 'completed');
    });
    cy.get('#toggleAll').should('contain', 'Mark All Complete');
  });
});
