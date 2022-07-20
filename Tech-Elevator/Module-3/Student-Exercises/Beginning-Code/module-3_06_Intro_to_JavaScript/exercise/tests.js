let should = chai.should();

describe("exercises", () => {
  describe("Sum Double", () => {
    it("should yield 3 when given (1, 2)", () => {
      sumDouble(1, 2).should.equal(3);
    });
    it("should yield 5 when given (3, 2)", () => {
      sumDouble(3, 2).should.equal(5);
    });
    it("should yield 8 when given (2, 2)", () => {
      sumDouble(2, 2).should.equal(8);
    });
  });

  describe("Has Teen", () => {
    it("should be true when first is teen", () => {
      hasTeen(13, 20, 10).should.be.true;
    });
    it("should be true when second is teen", () => {
      hasTeen(20, 19, 10).should.be.true;
    });
    it("should be true when third is teen", () => {
      hasTeen(20, 10, 13).should.be.true;
    });
    it("should be false when none is teen", () => {
      hasTeen(12, 2, 5).should.be.false;
    });
  });

  describe("Last Digit", () => {
    it("should be true when end digits are the same", () => {
      lastDigit(7, 17).should.be.true;
    });
    it("should be false when end digits aren't equal", () => {
      lastDigit(6, 17).should.be.false;
    });
    it("should be true when end digits are the same even on large numbers", () => {
      lastDigit(3, 1143534533).should.be.true;
    });
  });

  describe("See Color", () => {
    it("should be red if the word starts with red", () => {
      seeColor("redxx").should.equal("red");
    });
    it("should be empty if the word ends with red", () => {
      seeColor("xxred").should.equal("");
    });
    it("should be blue if the word starts with blue", () => {
      seeColor("blueTimes").should.equal("blue");
    });
    it("should be color name if bare color name is given", () => {
      seeColor("blue").should.equal("blue");
    });
    it("should be empty if empty string given", () => {
      seeColor("").should.equal("");
    });
  });

  describe("Odd Only", () => {
    it("only returns the odd numbered values", () => {
      oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]).should.deep.equal([
        1, 3, 5, 7, 9, 11,
      ]);
    });
    it("returns empty array if there are no odd numbers", () => {
      oddOnly([2, 4, 8, 32, 256]).should.deep.equal([]);
    });
  });

  describe("Front Again", () => {
    it("should be true if word starts and ends with `ed`", () => {
      frontAgain("edited").should.be.true;
    });
    it("should be false if word doesn't start and end with same letters", () => {
      frontAgain("edit").should.be.false;
    });
    it("should be true if word only two characters", () => {
      frontAgain("no").should.be.true;
    });
    it("should be false if letter case is different", () => {
      frontAgain("Edited").should.be.false;
    });
  });

  describe("Cigar Party", () => {
    it("should be false if there are not enough cigars", () => {
      cigarParty(30, false).should.be.false;
    });
    it("should be false if there are too many cigars", () => {
      cigarParty(70, false).should.be.false;
    });
    it("should be true if there are just enough cigars", () => {
      cigarParty(40, false).should.be.true;
    });
    it("should be true if there are just not too many cigars", () => {
      cigarParty(60, false).should.be.true;
    });
    it("should be true if there are lots of cigars and it's the weekend", () => {
      cigarParty(129, true).should.be.true;
    });
  });

  describe("Fizz Buzz", () => {
    it("should be '1' if a 1 is given", () => {
      fizzBuzz(1).should.equal(1);
    });
    it("should be '2' if a 2 is given", () => {
      fizzBuzz(2).should.equal(2);
    });
    it("should be 'Fizz' if a 3 is given", () => {
      fizzBuzz(3).should.equal("Fizz");
    });
    it("should be 'Buzz' if a 5 is given", () => {
      fizzBuzz(5).should.equal("Buzz");
    });
    it("should be 'Fizz' if a 9 is given", () => {
      fizzBuzz(9).should.equal("Fizz");
    });
    it("should be 'Buzz' if a 10 is given", () => {
      fizzBuzz(10).should.equal("Buzz");
    });
    it("should be 'FizzBuzz' if a 15 is given", () => {
      fizzBuzz(15).should.equal("FizzBuzz");
    });
    it("should be 'FizzBuzz' if a 30 is given", () => {
      fizzBuzz(30).should.equal("FizzBuzz");
    });
  });

  describe("Filter Evens", () => {
    it("should be an empty array if empty array given", () => {
      filterEvens([]).should.deep.equal([]);
    });
    it("should be an empty array if array is only odd numbers", () => {
      filterEvens([1, 3, 5]).should.deep.equal([]);
    });
    it("should return all numbers if all numbers are even", () => {
      filterEvens([2, 4, 6]).should.deep.equal([2, 4, 6]);
    });
    it("should return only even numbers if numbers is mixed", () => {
      filterEvens([100, 8, 21, 24, 62, 9, 7]).should.deep.equal([
        100, 8, 24, 62,
      ]);
    });
  });

  describe("Filter Numbers Bigger Than 100", () => {
    it("should return only numbers bigger than or equal to 100", () => {
      filterBigNumbers([7, 10, 121, 100, 24, 162, 200]).should.deep.equal([
        121, 100, 162, 200,
      ]);
    });
    it("should return an empty array if no numbers are over or equal to 100", () => {
      filterBigNumbers([3, 2, 7, 1, -100, -120]).should.deep.equal([]);
    });
    it("should return an empty array if empty array is given", () => {
      filterBigNumbers([]).should.deep.equal([]);
    });
  });

  describe("Filter Multiples of X", () => {
    it("should only keep numbers that are a multiple of 3", () => {
      filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3).should.deep.equal([
        3, 9, 18, 21, 42,
      ]);
    });
    it("should only keep numbers that are a multiple of 5", () => {
      filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5).should.deep.equal([
        5, 10, 20,
      ]);
    });
    it("should return an empty array if there are no multiples", () => {
      filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 100).should.deep.equal(
        []
      );
    });
  });

  describe("Create Object", () => {
    it("should contain a firstName, lastName and age", () => {
      const result = createObject();

      result.firstName.should.not.be.undefined;
      result.lastName.should.not.be.undefined;
      result.age.should.not.be.undefined;
    });
  });
});
