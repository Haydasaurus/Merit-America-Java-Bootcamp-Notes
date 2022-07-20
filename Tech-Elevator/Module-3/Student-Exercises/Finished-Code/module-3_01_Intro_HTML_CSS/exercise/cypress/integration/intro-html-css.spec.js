// See https://docs.cypress.io/guides/references/configuration#cypress-json for cypress.json configuration options

describe('Part 1: Fan page', () => {

    before(() => {
        cy.visit('./index.html');
    });

    // Document structure
    describe('Document structure', () => {
        it('Your document must have a meaningful title that appears as the browser tab\'s text.', () => {
            cy.title().should('exist').and('have.length.above', 0).and('not.equal', 'Document');
        });

        // There should be a link to the css
        it('Your document must link to a separate .css file which contains style rules.', () => {
            cy.get('head > link[rel="stylesheet"]').should('have.length.at.least', 1);
        });

        it('Your document must have a background color that\'s different than the default background of white.', () => {
            // Get the body CSS and check the bg
            cy.get('body').should('have.css', 'background-color').should('not.equal', 'rgba(0, 0, 0, 0)')
                .and('not.equal', 'rgb(255, 255, 255)')
                .and('not.equal', 'white');
        });

        it('Your document must have a header area, in which you display the main page heading.', () => {
            // Find the header element and make sure there is exactly one
            cy.get('body > header').should('have.length', 1);
        });

        it('Your document must have a main area which displays your page content.', () => {
            // Find the main element
            cy.get('body > main').should('have.length', 1);
        });

    });


    // Main page Heading
    describe('Main page heading', () => {
        it('Your page must have a heading describing its purpose, using the appropriate tag for a page-level heading.', () => {
            // Find the h1 element anywhere on the page - there should be 1
            cy.get('h1').should('have.length', 1);
        });
        it('The page heading must appear inside the appropriate semantic element.', () => {
            // Find the h1 element inside header - there should be 1
            cy.get('header h1').should('have.length', 1);
        });

        // TODO: How to check if the heading is centered? Are there other (simple) ways to center which this misses?
        it('The heading text must be centered on the page.', () => {
            cy.get('header h1').should('have.css', 'text-align').should('equal', 'center');
        });
    });


    // Image
    describe('Image', () => {

        it('Your page must contain an image relevant to the subject, like a book cover, a movie poster, picture of a band, or picture of a team.', () => {
            cy.get('main img');
        });

        it('All image tags in the main part of your page must refer to valid image files.', () => {
            cy.get('main img').each(
                ($img, index, $list) => {
                    // If src refers to non-existent file, naturalWidth will be 0.
                    expect($img[0].naturalWidth).to.be.greaterThan(0);
                }
            );
        });

        it('All images in the main part of your page must be no wider than 400 pixels on the page.', () => {
            cy.get('main img').each(
                ($img, index, $list) => {
                    // Get the actuals width (strip off the "px")
                    cy.get($img).should('have.css', 'width').then((w) => {
                        let width = parseInt(w);
                        expect(width).to.be.lte(400);
                    });
                }
            );
        });
    });

    // Table
    describe('Table section', () => {

        it('Your page must have a section with "id" of "facts-section".', () => {
            // Find the 'facts-section' section. There should be one
            cy.get('section#facts-section').should('have.length', 1);
        });

        it('Inside "facts-section", your page must have a second-level heading describing its contents. The heading must be a direct child of the section.', () => {
            cy.get('section#facts-section > h2').should('have.length.at.least', 1);
        });

        it('The heading inside the section must be underlined.', () => {
            cy.get('section#facts-section > h2').should('have.css', 'text-decoration').should('include', 'underline');
        });

        it('The "facts-section" must contain an HTML `table` element to include some information in a table.', () => {
            cy.get('section#facts-section table').should('have.length.at.least', 1);
        });

        it('The table must have multiple columns.', () => {
            cy.get('section#facts-section table tr:nth-child(2) > td').should('have.length.at.least', 2);
        });
    });

    // Quotes
    describe('Quotes section', () => {

        it('Your page must have a section with "id" of "quotes-section".', () => {
            // Find the 'quotes-section' section. There should be one
            cy.get('section#quotes-section').should('have.length', 1);
        });

        it('Inside "quotes-section", your page must have a second-level heading describing its contents. The heading must be a direct child of the section.', () => {
            cy.get('section#quotes-section > h2').should('have.length.at.least', 1);
        });

        it('The heading inside the section must be underlined.', () => {
            cy.get('section#quotes-section > h2').should('have.css', 'text-decoration').should('include', 'underline');
        });

        it('The "quotes-section" must include two or three quotes using the appropriate semantic element. ', () => {
            cy.get('section#quotes-section blockquote').should('have.length.at.least', 2);
        });

        it('The quote elements must have CSS (not HTML) making the text italics.', () => {
            cy.get('section#quotes-section blockquote').each(
                ($quote, index, $list) => {
                    cy.get($quote).should('have.css', 'font-style').should('equal', 'italic');
                });

            // Check to make sure the quotes are not italics by surrounding them in <em> tags. Students are supposed to use css.
            cy.get('section#quotes-section em blockquote').should('have.length', 0);
        });
    });

    // Links
    describe('Links section', () => {

        it('Your page must have a section with "id" of "links-section".', () => {
            // Find the 'links-section' section. There should be one
            cy.get('section#links-section').should('have.length', 1);
        });

        it('Inside "links-section", your page must have a second-level heading describing its contents. The heading must be a direct child of the section.', () => {
            cy.get('section#links-section > h2').should('have.length.at.least', 1);
        });

        it('The heading inside the section must be underlined.', () => {
            cy.get('section#links-section > h2').should('have.css', 'text-decoration').should('include', 'underline');
        });

        it('The "links-section" must include an unordered list of links (2 to 4) to other sites for the user to get more information. ', () => {
            cy.get('section#links-section ul').should('have.length.at.least', 1);
            cy.get('section#links-section ul > li').should('have.length.at.least', 2);
        });

        it('Each item in the unordered list must include a link. Use the appropriate HTML element to create a hyperlink.', () => {
            cy.get('section#links-section ul > li').each(
                ($item, index, $list) => {
                    // Check that the list item contains an anchor tag with a reference attribute
                    expect($item.children('a[href]')).to.have.length.greaterThan(0);
                    // Check that the anchor tag has inner text to display
                    expect($item.children('a[href]')[0].innerText).to.have.length.greaterThan(0);
                });

        });
    });


});
describe('Part 2: Information form', () => {
    before(() => {
        cy.visit('./info.html');
    });
    // Document structure
    describe('Document structure', () => {
        it('Your document must have a meaningful title that appears as the browser tab\'s text.', () => {
            cy.title().should('exist').and('have.length.above', 0).and('not.equal', 'Document');
        });

        // There should be a link to the css
        it('Your document must link to a separate .css file which contains style rules.', () => {
            cy.get('head > link[rel="stylesheet"]').should('have.length.at.least', 1);
        });
    });

    // Form
    describe('Form', () => {
        it('Your page must have a form element which contains all the controls for the user to enter data.', () => {
            cy.get('body form');
        });

        it('The form must have the necessary attributes.', () => {
            cy.get('body form').should('have.attr', 'method').should('match', /post/i);
            cy.get('body form').should('have.attr', 'action');
        });

        it('The form must have a background color that\'s different than the default background of white.', () => {
            // Get the form CSS and check the bg
            cy.get('body form').should('have.css', 'background-color').should('not.equal', 'rgba(0, 0, 0, 0)')
                .and('not.equal', 'rgb(255, 255, 255)')
                .and('not.equal', 'white');
        });

        // Name
        it(`The form must have a "name" control with appropriate attributes.`, () => {
            // Find the control and check its attributes
            cy.get(`body form input#name`).then(ctrl => {
                // Is required
                cy.wrap(ctrl).should('have.attr', 'required');
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^text$/i);
            });
        });
        it(`There must be a label for the "name" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=name]`);
        });

        // Email
        it(`The form must have a "email" control with appropriate attributes.`, () => {
            // Find the control and check its attributes
            cy.get(`body form input#email`).then(ctrl => {
                // Is required
                cy.wrap(ctrl).should('have.attr', 'required');
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^email$/i);
            });
        });
        it(`There must be a label for the "email" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=email]`);
        });

        // Birth date
        it('The form must have a "date-of-birth" control with appropriate attributes.', () => {
            // Find the control and check its attributes
            cy.get('body form input#date-of-birth').then(ctrl => {
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^date$/i);
            });
        });
        it(`There must be a label for the "date-of-birth" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=date-of-birth]`);
        });

        // Favorite color
        it('The form must have a "favorite-color" control with appropriate attributes.', () => {
            // Find the control and check its attributes
            cy.get('body form input#favorite-color').then(ctrl => {
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^color$/i);
            });
        });
        it(`There must be a label for the "favorite-color" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=favorite-color]`);
        });

        // lucky number
        it('The form must have a "lucky-number" control with appropriate attributes.', () => {
            // Find the control and check its attributes
            cy.get('body form input#lucky-number').then(ctrl => {
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^number$/i);
            });
        });
        it(`There must be a label for the "lucky-number" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=lucky-number]`);
        });

        // Confirmation
        it('The form must have a "confirmation" control with appropriate attributes.', () => {
            // Find the control and check its attributes
            cy.get('body form input#confirmation').then(ctrl => {
                // Has name attribute same as id attribute
                cy.wrap(ctrl).should('have.attr', 'name').should('equal', ctrl[0].id);
                // Has the right type attribute
                cy.wrap(ctrl).should('have.attr', 'type').should('match', /^checkbox$/i);
            });
        });
        it(`There must be a label for the "confirmation" control.`, () => {
            // Find the label associated with the control
            cy.get(`body form label[for=confirmation]`);
        });

        // Submit
        it('There must be one additional control for the user to press and submit the form.', () => {
            // Find the control and check its attributes
            cy.get('body form input[type=submit],body form button[type=submit]');
        });
    });
});
