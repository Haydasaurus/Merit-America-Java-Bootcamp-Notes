// See https://docs.cypress.io/guides/references/configuration#cypress-json for cypress.json configuration options

/***
 * Notes:
 * An outer section (describe)
 * A section (describe) for each viewport width
 *      Desktop (>1024)
 *      Tablet (<=1024)
 *      Phone (<=450)
 */
// A section

describe('CSS Flexbox tests', {
    viewportWidth: 1200,
    viewportHeight: 800
},
    () => {
        // Part 1: Mini-exercises
        describe('Part 1: Practice with flexbox properties', () => {

            describe('Set 1: Adjust header layout', () => {

                // Align navigation items
                describe('Step 1: Align navigation items', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-1-headers/step-1/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('header > nav > ul', 'row');
                    });
                });

                // Align logo with navigation items
                describe('Step 2: Align the logo and navigation items on the same row', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-1-headers/step-2/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('header > nav > ul', 'row');
                    });

                    // Check for appropriate flex container
                    it('The parent of the logo and the navigation element must be a row-based flex container', () => {
                        checkFlex('header', 'row');
                    });
                });

                // Center the navigations items in the space after the logo
                describe('Step 3: Center the navigations items in the space after the logo', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-1-headers/step-3/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('header > nav > ul', 'row');
                    });

                    // Check for appropriate flex container
                    it('The parent of the logo and the navigation element must be a row-based flex container', () => {
                        checkFlex('header', 'row');
                    });

                    // Check for appropriate flex properties
                    it('Only the flex item holding the navigation must grow to fill available space', () => {
                        cy.get('header > a').should('have.css', 'flex-grow').should('equal', '0');
                        cy.get('header > nav').should('have.css', 'flex-grow').should('not.equal', '0');
                    });

                    // Check for appropriate flex properties
                    it('The navigation list flex container must horizontally center its content', () => {
                        cy.get('header > nav > ul').should('have.css', 'justify-content', 'center');
                    });
                });

                // Center the navigations items in the space after the logo
                describe('Step 4: Right-align the navigation items', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-1-headers/step-4/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('header > nav > ul', 'row');
                    });

                    // Check for appropriate flex container
                    it('The parent of the logo and the navigation element must be a row-based flex container', () => {
                        checkFlex('header', 'row');
                    });

                    // Check for appropriate flex properties
                    it('Only the flex item holding the navigation must grow to fill available space', () => {
                        cy.get('header > a').should('have.css', 'flex-grow').should('equal', '0');
                        cy.get('header > nav').should('have.css', 'flex-grow').should('not.equal', '0');
                    });

                    // Check for appropriate flex properties
                    it('The navigation list flex container must horizontally align its content to the right', () => {
                        cy.get('header > nav > ul').should('have.css', 'justify-content', 'flex-end');
                    });
                });

                // Center the navigations items in the space after the logo
                describe('Step 5: Right-align the user icon', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-1-headers/step-5/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('header > nav > ul', 'row');
                    });

                    // Check for appropriate flex container
                    it('The parent of the logo and the navigation element must be a row-based flex container', () => {
                        checkFlex('header', 'row');
                    });

                    // Check for appropriate flex properties
                    it('Only the spacer flex item must grow to fill available space', () => {
                        cy.get('header > a:first-of-type').should('have.css', 'flex-grow').should('equal', '0');
                        cy.get('header > nav').should('have.css', 'flex-grow').should('equal', '0');
                        cy.get('header > div.spacer').should('have.css', 'flex-grow').should('not.equal', '0');
                        cy.get('header > a.my-account').should('have.css', 'flex-grow').should('equal', '0');
                    });
                });

            });

            describe('Set 2: Align flex items within a row', () => {

                // Align items with equal space on all sides
                describe('Step 1: Align items with equal space on all sides', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-2-align-content-row/step-1/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be horizontally aligned with equal space on each side', () => {
                        cy.get('div.container').should('have.css', 'justify-content', 'space-evenly');
                    });

                });

                // Align items with equal space between
                describe('Step 2: Align items with equal space between', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-2-align-content-row/step-2/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be horizontally aligned with equal space on each side', () => {
                        cy.get('div.container').should('have.css', 'justify-content', 'space-between');
                    });

                });

            });

            describe('Set 3: Align flex items vertically', () => {

                // Center the row of items vertically
                describe('Step 1: Center the row of items vertically', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-3-align-vertically/step-1/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be vertically aligned in the middle of the container', () => {
                        checkAlign('center');
                    });

                });

                // Place the row at the bottom of the container
                describe('Step 2: Place the row at the bottom of the container', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-3-align-vertically/step-2/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be vertically aligned at the bottom of the container', () => {
                        checkAlign('flex-end');
                    });

                });

                // Place the row at the top of the container
                describe('Step 3: Place the row at the top of the container', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-3-align-vertically/step-3/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be vertically aligned at the top of the container', () => {
                        checkAlign('flex-start');
                    });
                });

                // Set vertical and horizontal alignment
                describe('Step 4: Set vertical and horizontal alignment', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-3-align-vertically/step-4/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('The boxes must be vertically aligned in the center of the container', () => {
                        checkAlign('center');
                    });
                    // Check for appropriate flex properties
                    it('The boxes must be horizontally aligned with equal space on each side', () => {
                        cy.get('div.container').should('have.css', 'justify-content', 'space-evenly');
                    });
                });

            });

            describe('Set 4: Size flex items', () => {

                // Grow items to fill the row
                describe('Step 1: Grow items to fill the row', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-4-flex-grow/step-1/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('All boxes must grow an equal amount', () => {
                        cy.get('div.box:first-child').should('have.css', 'flex-grow').then((gr => {
                            cy.log(gr);
                            let growAmount = parseInt(gr);
                            assert(growAmount > 0, "All boxes must be set to allow growth");

                            for (let i = 2; i <= 4; i++) {
                                cy.get(`div.box:nth-child(${i})`).should('have.css', 'flex-grow').then(gr2 => {
                                    let growAmount2 = parseInt(gr2);
                                    assert(growAmount2 > 0, "All boxes must be set to allow growth");
                                    assert(growAmount2 === growAmount, "All boxes must grow an equal amount");
                                });
                            }
                        }));
                    });
                });

                // Grow items to fill the row
                describe('Step 2: Grow items 2 and 4 more', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-4-flex-grow/step-2/index.html');
                    });

                    // Check for appropriate flex container
                    it('The parent of the list items must be a row-based flex container', () => {
                        checkFlex('div.container', 'row');
                    });

                    // Check for appropriate flex properties
                    it('Boxes 2 and 4 must grow twice as fast as boxes 1 and 3', () => {
                        cy.get('div.box:first-child').should('have.css', 'flex-grow').then((gr => {
                            cy.log(gr);
                            let growAmount = parseInt(gr);
                            assert(growAmount > 0, "All boxes must be set to allow growth");

                            for (let i = 2; i <= 4; i++) {
                                cy.get(`div.box:nth-child(${i})`).should('have.css', 'flex-grow').then(gr2 => {
                                    let growAmount2 = parseInt(gr2);
                                    cy.log(growAmount2);
                                    assert(growAmount2 > 0, "All boxes must be set to allow growth");

                                    assert(growAmount2 === (i % 2 ? growAmount : growAmount * 2), "Boxes 2 and 4 must grow twice as fast as boxes 1 and 3");
                                });
                            }
                        }));
                    });
                });
            });

            describe('Set 5: Wrap flex items', () => {

                // Wrap flex items
                describe('Step 1: Wrap flex items', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-5-flex-wrap/step-1/index.html');
                    });

                    // Check for appropriate flex properties
                    it('The flex container must allow wrapping of items', () => {
                        cy.get('div.container').should('have.css', 'flex-wrap', 'wrap');
                    });
                });

            });

            describe('Set 6: Order flex items', () => {

                // Order flex items
                describe('Step 1: Order flex items', () => {
                    before(() => {
                        // Visit the page
                        cy.visit('./exercise-part-1/set-6-flex-order/step-1/index.html');
                    });

                    // Check for appropriate flex container - FIRST PAIR
                    it('The container of the first text-image pair must be a row-based flex container', () => {
                        checkFlex('div.bio:nth-child(1)', 'row');
                    });

                    // Check for appropriate flex properties
                    it('In the first box, the image must precede the text.', () => {
                        cy.get('div.bio:nth-child(1) > div.about').should('have.css', 'order').then(o => {
                            let ordText = parseInt(o);
                            cy.log(ordText);
                            cy.get('div.bio:nth-child(1) > img').should('have.css', 'order').then(o => {
                                let ordImg = parseInt(o);
                                cy.log(ordImg);
                                assert(ordImg <= ordText, 'In first box, expected image to be before text');
                            });
                        });
                    });

                    // Check for appropriate flex container - SECOND PAIR
                    it('The container of the second text-image pair must be a row-based flex container, and the image must follow the text', () => {
                        // Second child may be "row" or "row-reverse"
                        cy.get('div.bio:nth-child(2)').should('have.css', 'display', 'flex');
                        cy.get('div.bio:nth-child(2)').should('have.css', 'flex-direction').then(direction => {
                            assert(direction === 'row' || direction === 'row-reverse', "The container of the second text-image pair must be a row-based flex container");

                            // If row, img order must be > text order. If row-reverse, img order must be <= text order
                            cy.get('div.bio:nth-child(2) > div.about').should('have.css', 'order').then(o => {
                                let ordText = parseInt(o);
                                cy.log(ordText);
                                cy.get('div.bio:nth-child(2) > img').should('have.css', 'order').then(o => {
                                    let ordImg = parseInt(o);
                                    cy.log(ordImg);
                                    assert((direction === 'row' && ordImg > ordText) || (direction === 'row-reverse' && ordImg <= ordText) , 'In second box, expected image to be after text');
                                });
                            });
                        });
                    });
                });
            });
        });

        // Part 1: Portfolio
        describe('Part 2: Build a portfolio page with flexbox', () => {
            before(() => {
                // Visit the page
                cy.visit('./exercise-part-2/index.html');
            });

            // Ensure panels are flex items
            describe('Step 1: Define the overall layout', () => {
                // Check for appropriate flex container
                it('The parent of the panels must be a row-based flex container', () => {
                    checkFlex('body', 'row');
                });
            });

            //  Add flex layout to the left panel
            describe(' Step 2: Add flex layout to the left panel', () => {

                // Check for appropriate flex container
                it('The left panel must be a column-based flex container', () => {
                    checkFlex('section#left-panel', 'column');
                });

                // Check for appropriate flex properties
                it('The left panel must have width (basis) of 35%', () => {
                    cy.get('section#left-panel').should('have.css', 'flex-basis').then((basis) => {
                        if (basis !== '35%') {
                            // See if the width === 35% via some other css (like width)
                            cy.get('section#left-panel').should('have.css', 'width').then(panelWidth => {
                                let pxPanelWwidth = parseFloat(panelWidth);
                                cy.get('body').should('have.css', 'width').then(bodyWidth => {
                                    let pxBodyWwidth = parseFloat(bodyWidth);
                                    let actualPercent = Math.round((pxPanelWwidth * 100) / pxBodyWwidth);
                                    assert(actualPercent === 35, `Expected width (basis) of the left panel to be 35%, but it was ${actualPercent}%`);
                                });
                            });
                        }
                    });
                    ;
                });
            });

            //  Add styles to social icons
            describe(' Step 3: Add styles to social icons', () => {

                // Check for appropriate flex container
                it('The parent of the social icons must be a row-based flex container', () => {
                    checkFlex('ul.social-icons', 'row');
                });

                // Check for appropriate flex properties
                it('The social icons must be spread across the panel with equal space between them', () => {
                    cy.get('ul.social-icons').should('have.css', 'justify-content', 'space-between');
                });
                it('The social icons must display at the bottom of the panel', () => {
                    cy.get('section#left-panel > header').should('have.css', 'flex-grow', '0');
                    cy.get('section#left-panel > h2').should('have.css', 'flex-grow', '0');
                    cy.get('section#left-panel > p').should('have.css', 'flex-grow', '0');
                    cy.get('section#left-panel > nav').should('have.css', 'flex-grow').should('not.equal', '0');
                    cy.get('section#left-panel > footer').should('have.css', 'flex-grow', '0');
                });
            });

            //  Center welcome banner
            describe(' Step 4: Center welcome banner', () => {

                // Check for appropriate flex container
                it('The parent of the social icons must be a row-based flex container', () => {
                    // Either orientation would work
                    cy.get('section#right-panel').should('have.css', 'display', 'flex');

                });

                // Check for appropriate flex properties
                it('The welcome banner must be centered vertically and horizontally', () => {
                    cy.get('section#right-panel').should('have.css', 'justify-content', 'center').and('have.css', 'align-items', 'center');

                    // The right panel needs to stretch to the remaining horizontal space
                    cy.get('section#right-panel').should('have.css', 'flex-grow').then(grow => {
                        cy.get('section#right-panel').should('have.css', 'flex-basis').then(basis => {
                            assert(grow !== '0' || basis === '65%', 'Expected right panel to grow to remaining horizontal space');
                        });
                    });
                });

            });


        });
    });

function checkAlign(value) {
    cy.get('div.container').then($container => {
        // Either the container has proper align-items or all items have align-self
        const htmlContainer = $container[0];
        const containerAlignItems = getComputedStyle(htmlContainer).alignItems === value;
        const boxes = Array.from(htmlContainer.children);
        if (containerAlignItems) {
            // If the container has align-items: value, then the children
            // simply must NOT override align-self: with a different value
            boxes.forEach(box => {
                const boxAlignSelf = getComputedStyle(box).alignSelf;
                assert(boxAlignSelf === 'auto' || boxAlignSelf === value, 'The container has align-items, but at least one of the boxes overrides that value.');
            });
        } else {
            // If the container DOES NOT have align-items: value, then the children
            // MUST override with align-self: value
            boxes.forEach(box => {
                const boxAlignSelf = getComputedStyle(box).alignSelf;
                assert(boxAlignSelf === value, 'The container does not align its child boxes, and at least one of the boxes does not align itself.');
            });
        }
    });
}

function checkFlex(selector, direction) {
    cy.get(selector).should('have.css', 'display', 'flex').and('have.css', 'flex-direction', direction);

}

