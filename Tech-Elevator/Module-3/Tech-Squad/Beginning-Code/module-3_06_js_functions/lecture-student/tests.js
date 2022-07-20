let should = chai.should();

describe('returnOne', () => {
  it('should return 1', () => {
    returnOne().should.equal(1);
  });
});

describe('printToConsole', () => {
  it('should be able to call the printToConsole function', () => {
    printToConsole.should.be.a('function');
    printToConsole('Message from the test!');
  });
});

describe('multiplyTogether', () => {
  it('should multiply two numbers together', () => {
    multiplyTogether(5, 2).should.equal(10);
    multiplyTogether(0, 6).should.equal(0);
  });

  it('should multiply with missing parameters', () => {
    multiplyTogether().should.be.NaN;
    multiplyTogether(9).should.be.NaN;
  });

  it('should multiply non numbers', () => {
    multiplyTogether(1, 'a').should.be.NaN;
    multiplyTogether('a', 'b').should.be.NaN;
  });
});

describe('multiplyNoUndefined', () => {
  it('should multiply two numbers together', () => {
    multiplyNoUndefined(5, 2).should.equal(10);
    multiplyNoUndefined(0, 6).should.equal(0);
  });

  it('should be zero when multiplying with default parameters', () => {
    multiplyNoUndefined().should.equal(0);
    multiplyNoUndefined(9).should.equal(0);
  });

  it("should multiply non numbers, can't prevent it!", () => {
    multiplyNoUndefined(1, 'a').should.be.NaN;
    multiplyNoUndefined('a', 'b').should.be.NaN;
  });
});

describe('scopeTest', () => {
  it("should throw an 'is not defined' error", () => {
    scopeTest.should.throw(/is not defined/);
  });
});

describe('createSentenceFromUser', () => {
  it('should use function with minimum values', () => {
    createSentenceFromUser('Joe', 38, ['glasses', 'writer']).should.equal(
      'Joe is currently 38 years old. Their quirks are: glasses, writer'
    );
  });

  /**
   * Feel free to document tests as well!
   */
  it('using function and defining separator', () => {
    createSentenceFromUser('Joe', 38, ['glasses', 'writer'], '--').should.equal(
      'Joe is currently 38 years old. Their quirks are: glasses--writer'
    );
  });

  it('should still print even when no quirks given', () => {
    createSentenceFromUser('No', 5).should.equal('No is currently 5 years old. Their quirks are: ');
  });
});

describe('sumAllNumbers', () => {
  it('should sum up all the numbers in an array', () => {
    sumAllNumbers([1, 2, 3, 4]).should.equal(10);
  });
});

describe('allDivisibleByThree', () => {
  it("should filter out all numbers that aren't multiples of three", () => {
    allDivisibleByThree([1, 2, 3, 4, 5, 6]).should.deep.equal([3, 6]);
  });
});
