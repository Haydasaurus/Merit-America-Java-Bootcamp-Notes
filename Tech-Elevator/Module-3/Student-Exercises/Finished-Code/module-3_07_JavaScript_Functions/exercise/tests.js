let should = chai.should();

describe('Exercises', () => {

  describe('isAdmitted', () => {
    it('should accept anyone with high gpa', () => {
      isAdmitted(4.2).should.be.true;
    });
    it('should accept anyone with high SAT', () => {
      isAdmitted(1, 1301).should.be.true;
    });
    it('should accept anyone with good gpa and recommendation', () => {
      isAdmitted(3.5, 0, true).should.be.true;
    });
    it('should accept anyone with good SAT and recommendation', () => {
      isAdmitted(1, 1201, true).should.be.true;
    });
    it('should reject unqualified', () => {
      isAdmitted(1, 100, false).should.be.false;
    });
    it('should reject unqualified even if recommended', () => {
      isAdmitted(1, 100, true).should.be.false;
    });
  });

  describe('useParameterToFilterArray', () => {
    it('should return array', () => {
      useParameterToFilterArray(() => {
        return true;
      }).should.be.an('array');
    });
    it('should return everything if function just returns true', () => {
      useParameterToFilterArray((e) => {
        return true;
      }).should.deep.equal([1, 2, 3, 4, 5, 6]);
    });
    it('should filter array with given function', () => {
      useParameterToFilterArray((e) => {
        return e % 2 === 0;
      }).should.deep.equal([2, 4, 6]);
    });
  });

  describe('makeNumber', () => {
    it('should return number', () => {
      makeNumber('1', '0').should.be.a('number');
    });
    it('should be able to take one param', () => {
      makeNumber('0').should.equal(0);
    });
    it('should be able to take two params', () => {
      makeNumber('1', '0').should.equal(10);
    });
    it('should not add numbers together', () => {
      makeNumber('23456', '593484').should.equal(23456593484);
    });
  });

  describe('addAll', () => {
    it('should return 0 for no arguments', () => {
      addAll().should.equal(0);
    });
    it('should add up all arguments', () => {
      addAll(1, 2, 3).should.equal(6);
    });
    it('should take any number of arguments', () => {
      addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).should.equal(55);
    });
  });

  describe('makeHappy', () => {
    it('should return an array of strings', () => {
      makeHappy(['arst']).should.be.an('array');
      makeHappy(['arst'])[0].should.be.a('string');
    });
    it("should put 'Happy' at the beginning of the strings", () => {
      makeHappy(['days', 'feet', 'dance']).should.deep.equal(['Happy days', 'Happy feet', 'Happy dance']);
    });
  });

  describe('getFullAddressOfProperties', () => {
    let properties = [
      {
        city: 'Greenwich',
        streetNumber: '443B',
        streetName: 'Baker',
        zip: '44322',
        streetType: 'St',
        state: 'OH'
      }, {
        streetNumber: 2002,
        city: 'Tokyo',
        streetName: 'Winston',
        streetType: 'Rd',
        state: 'OK',
        zip: 65434
      }
    ];
    it('should return full addresses or property', () => {
      getFullAddressesOfProperties(properties).should.deep.equal(['443B Baker St Greenwich OH 44322', '2002 Winston Rd Tokyo OK 65434']);
    });
  });

  describe('findLargest', () => {
    it('should find largest number in an array', () => {
      findLargest([1, 3, 5, 2, 4, 7, 6]).should.equal(7);
    });
    it('should find the largest string (latest in the alphabet)', () => {
      findLargest(['aardvark', 'zebra', 'mongoose', 'hippo']).should.equal(
        'zebra'
      );
    });
  });
});
