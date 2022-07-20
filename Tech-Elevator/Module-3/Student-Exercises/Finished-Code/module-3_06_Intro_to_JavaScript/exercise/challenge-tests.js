let should = chai.should();

describe('Challenge Exercises', () => {
  describe('IQ Test', () => {
    it('should be 3 when third number is only one not even', () => {
      iqTest('2 4 7 8 10').should.equal(3);
    });
    it('should be 2 when second number is only one even', () => {
      iqTest('1 2 1 1').should.equal(2);
    });
    it('should be 0 when no numbers are given', () => {
      iqTest('').should.equal(0);
    });
    it('should be 0 when all numbers are even', () => {
      iqTest('2 2 4 6').should.equal(0);
    });
  });

  describe('Title Case', () => {
    it('should properly titlify even if extra words are given', () => {
      titleCase('a clash of KINGS', 'a an the of').should.equal('A Clash of Kings');
    });
    it('should properly titlify even if given words are different case', () => {
      titleCase('THE WIND IN THE WILLOWS', 'The In').should.equal('The Wind in the Willows');
    });
    it('should properly titlify even if no non titled words are given', () => {
      titleCase('the quick brown fox').should.equal('The Quick Brown Fox');
    });
  });
});
