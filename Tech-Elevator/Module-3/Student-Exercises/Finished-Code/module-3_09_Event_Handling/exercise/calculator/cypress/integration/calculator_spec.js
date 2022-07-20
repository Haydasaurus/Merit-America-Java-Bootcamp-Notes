function clickNumber(num) {
  cy.get('.number').contains(num.toString()).click();
}

function clickOperator(operator) {
  return cy.get('.operator').contains(operator).click();
}

function clickEqual() {
  return cy.get('.equal-sign').click();
}

function clickClear() {
  cy.get('.all-clear').click();
}

function clickDecimal() {
  cy.get('.decimal').click();
}

describe('Event Handling Calculator Exercise Tests', () => {

  before(() => {
    cy.visit('/');
  })

  it('should be able to add 2+5 and get a result of 7', () => {
    clickNumber(2);
    clickOperator('+');
    clickNumber(5);
    clickEqual();
    cy.get('#display').should('have.value', '7');
  });

  it('should clear the display back to 0 when clicking the button AC', () => {
    cy.get('#display').clear({force: true}).type('23', {force: true}); // set initial value to test that it's cleared, force necessary because field is disabled
    clickClear();
    cy.get('#display').should('have.value', '0');
  });

  it('should be able to subtract 9-6 and get a result of 3',() => {
    cy.get('#display').clear({force: true}).type('0', {force: true}); // reset if previous test fails
    clickNumber(9)
    clickOperator('-')
    clickNumber(6)
    clickEqual();
    cy.get('#display').should('have.value', '3');
    clickClear();
  });

  it('should be able to multiply 10x8 and get a result of 80', () => {
    clickNumber(1)
    clickNumber(0)
    clickOperator('×')
    clickNumber(8)
    clickEqual();
    cy.get('#display').should('have.value', '80');
    clickClear();
  });

  it('should be able to divide 20/10 and get a result of 2', () => {
    clickNumber(2)
    clickNumber(0)
    clickOperator('÷')
    clickNumber(1)
    clickNumber(0)
    clickEqual()
    cy.get('#display').should('have.value', '2')
    clickClear()
  });

  it('should allow for decimals: add 20.3+10.5 and get a result of 30.8', () => {
    clickNumber(2); clickNumber(0); clickDecimal(); clickNumber(3);
    clickOperator('+')
    clickNumber(1); clickNumber(0); clickDecimal(); clickNumber(5);
    clickEqual()
    cy.get('#display').should('have.value', '30.8')
    clickClear()
  })

})
