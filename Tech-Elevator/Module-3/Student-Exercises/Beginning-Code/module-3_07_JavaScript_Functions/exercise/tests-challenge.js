describe('CHALLENGE', () => {
    describe('getSumOfSubArrayValues', () => {
        it('should return a number', () => {
            getSumOfSubArrayValues([[23, 4, 33]]).should.be.a('number');
        });
        it('should add up all numbers in arrays and return sum', () => {
            let nestedArray = [[1, 2, 3], [1, 2, 3], [2, 2, 2, 2]];
            getSumOfSubArrayValues(nestedArray).should.equal(20);
        });
        it('should return 0 if no parameter passed in', () => {
            getSumOfSubArrayValues().should.equal(0);
        });
        it('should return 0 if given an empty array', () => {
            getSumOfSubArrayValues([]).should.equal(0);
        });
    });
});