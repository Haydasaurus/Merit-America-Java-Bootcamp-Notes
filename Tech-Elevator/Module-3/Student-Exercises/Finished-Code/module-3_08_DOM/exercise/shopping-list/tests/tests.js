let should = chai.should();

describe("dom-exercise", () => {
  before(async () => {
    if (typeof documentLoader !== "undefined") {
      await documentLoader();
    }
  });

  it("page title is added to the DOM", () => {
    const title = document.getElementById("title");
    title.innerText.should.equal("My Shopping List");
  });

  it("groceries array should contain 10 items", () => {
    groceries.should.have.lengthOf(10);
  });

  it("groceries are added to the DOM", () => {
    const items = document.querySelectorAll("#groceries > li");
    items.should.have.lengthOf(10);
  });

  it("should have items in the list, but 0 items completed", () => {
    const itemsCompleted = document.querySelectorAll("#groceries > li.completed");
    const items = document.querySelectorAll("#groceries > li");
    itemsCompleted.should.have.lengthOf(0);
    items.should.have.length.greaterThan(0);
  });

  it("clicking the button marks all of the items complete", () => {
    markCompleted();
    const items = document.querySelectorAll("#groceries > li.completed");
    items.should.have.lengthOf(10);
  });
});
