let should = chai.should();

describe('Lecture', () => {
  describe('Hello There', () => {
    it("should take 'Hello' and 'There' and return 'ellohere'", () => {
      nonStart('Hello', 'There').should.equal('ellohere');
    });
    it("should take 'Java' and 'Code' and return 'avaode'", () => {
      nonStart('Java', 'Code').should.equal('avaode');
    });
  });
});
