let should = chai.should();

describe('Intro to JavaScript tutorial tests', () => {

  describe('Step Two: Reassign a variable', () => {
    it('result is true', () => {
      stepTwo().should.be.true;
    });
  });

  describe('Step Three: Add values to an array', () => {
    const output = stepThree().map(el => typeof el);
    it('values contains a boolean', () => {
      output.should.include('boolean');
    });
    it('values contains a number', () => {
      output.should.include('number');
    });
    it('values contains a string', () => {
      output.should.include('string');
    });
  });

  describe('Step Four: Round a number to two decimal places', () => {
    it('roundedTwoThirds equals 0.67', () => {
      stepFour().should.equal(0.67);
    });
  });

  describe('Step Five: Strictly compare two values', () => {
    it('answer is "No"', () => {
      stepFive().should.equal('No');
    });
  });

  describe('Step Six: Iterate through an array', () => {
    it('sum equals 100', () => {
      stepSix().should.equal(100);
    });
  });

  describe('Step Seven: Add a property to an object', () => {
    it('iceCreamCone has a property called "numberOfScoops" that equals 2', () => {
      stepSeven().should.have.property('numberOfScoops').that.equals(2);
    });
    it('iceCreamCone has a property called "hasSprinkles" that equals true', () => {
      stepSeven().should.have.property('hasSprinkles').that.equals(true);
    });
  });

});
