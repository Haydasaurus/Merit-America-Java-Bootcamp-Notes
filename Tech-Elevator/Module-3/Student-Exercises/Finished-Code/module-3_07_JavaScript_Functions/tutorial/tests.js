let should = chai.should();

describe('tutorial', () => {
  describe('turnOn', () => {
    it('should return true', () => {
      turnOn().should.be.true;
    });
  });

  describe('returnsName', () => {
    it('should return a string', () => {
      returnsName().should.be.a('string');
    });
  });

  describe('returnGivenParameter', () => {
    it('should return parameter', () => {
      returnGivenParameter('this').should.equal('this');
    });
    it('should return undefined on no parameter', () => {
      should.not.exist(returnGivenParameter());
    });
  });

  describe('takeOptionalParameter', () => {
    it('should return parameter', () => {
      takeOptionalParameter('this').should.equal('this');
    });
    it('should return 0 on no parameter', () => {
      takeOptionalParameter().should.equal(0);
    });
  });

  describe('filterArrayToOnlySingleDigitNumbers', () => {
    it('should return array', () => {
      filterArrayToOnlySingleDigitNumbers([1, 2, 3, 4, 5, 6, 6]).should.be.an('array');
    });

    let cases = [
      { parameters: [1, 1, 1, 1, 9, 10], expected: [1, 1, 1, 1, 9] },
      { parameters: [-1, -1, -1, -1, -9, -10], expected: [-1, -1, -1, -1, -9] }
    ];
    cases.forEach((test) => {
      it('should handle negative numbers properly', () => {
        filterArrayToOnlySingleDigitNumbers(test.parameters).should.deep.equal(test.expected);
      });
    });
  });

  describe('mapArrayToDoubleAllNumbers', () => {
    it('should return array', () => {
      mapArrayToDoubleAllNumbers([1, 2, 3, 4, 5, 6, 6]).should.be.an('array');
    });
    it('should double all numbers', () => {
      mapArrayToDoubleAllNumbers([1, 2, 3]).should.deep.equal([2, 4, 6]);
    });
  });

  describe('reduceArrayToFindProduct', () => {
    it('should return number', () => {
      reduceArrayToFindProduct([1, 2, 3]).should.be.a('number');
    });
    it('should multiply all numbers', () => {
      reduceArrayToFindProduct([1, 5, 10]).should.equal(50);
    });
  });

  describe('filterStringArrayForSon', () => {
    it("should only keep 'son' names", () => {
      filterStringArrayForSon(['Erickson', 'Jackson', 'Walters', 'Johnson']).should.deep.equal(['Erickson', 'Jackson', 'Johnson']);
    });
  });

  describe('makeNamesAllCaps', () => {
    it('should convert array to all capital letters', () => {
      makeNamesAllCaps(['one', 'TwO', 'ThRee']).should.deep.equal(['ONE', 'TWO', 'THREE']);
    });
  });

  describe('convertTemperature', () => {
    it('should convert C to F and return string', () => {
      convertTemperature(0, 'C').should.equal('32');
    });
    it('should convert F to C and return string', () => {
      convertTemperature(32, 'F').should.equal('0');
    });
    it('should add unit if asked', () => {
      convertTemperature(32, 'F', true).should.equal('0C');
    });
  });
});
