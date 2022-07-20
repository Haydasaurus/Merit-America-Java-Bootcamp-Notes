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

describe('CSS Grid tests', () => {

    before(() => {
        cy.visit('./index.html');
    });

    // Layout of grid and grid areas
    describe('Step one: Create grids and grid areas', () => {
        // main-grid is a grid display.
        it('main-grid must be a grid container', () => {
            cy.get('#main-grid').should('have.css', 'display').should('equal', 'grid');
        });
        // experience-grid is a grid display
        it('experience-grid must be a grid container', () => {
            cy.get('#experience-grid').should('have.css', 'display').should('equal', 'grid');
        });

        // All main-grid children must be assigned to a grid-area
        it('All main-grid children must be assigned to a grid-area', () => {
            checkValidGridArea('#headline');
            checkValidGridArea('#student-picture');
            checkValidGridArea('#student-quote');
            checkValidGridArea('#student-profile');
            checkValidGridArea('#student-contact');
            checkValidGridArea('#experience-grid');
        });

        // All experience-grid children must be assigned to a grid-area
        it('All experience-grid children must be assigned to a grid-area', () => {
            checkValidGridArea('#experience-code');
            checkValidGridArea('#experience-database');
            checkValidGridArea('#experience-web');
            checkValidGridArea('#experience-design');
        });
    });


    let mainGrid = [];
    let mainGridColumns = [];
    let experienceGrid = [];
    let experienceGridColumns = [];

    // Grid layout for Desktop (> 1024px wide)
    describe('Step two: Create the desktop layout', {
        viewportWidth: 1025,
        viewportHeight: 800
    },
        () => {
            beforeEach(() => {
                // Note: based on thread https://github.com/cypress-io/cypress/issues/1534, we are able to pass config overrides
                // now as part of the describe (above), so the next line is no longer needed.  The old way caused massive flicker,
                // as the viewport was set between each test (it).
                // cy.viewport(1025, 800);

                cy.get('#main-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    mainGrid = getGridAreas(gta);
                    cy.log(mainGrid);
                });

                cy.get('#main-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    mainGridColumns = getGridColumns(gtc);
                    cy.log(mainGridColumns);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    experienceGrid = getGridAreas(gta);
                    cy.log(experienceGrid);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    experienceGridColumns = getGridColumns(gtc);
                    cy.log(experienceGridColumns);
                });

            });

            // main grid columns (children) are equal widths
            it('main-grid must have 3 columns of equal width', () => {
                assert(mainGridColumns.length === 3, `Expected 3 columns in main-grid-template-columns, but found ${mainGridColumns.length}`);

                // Make sure they all have the same width (or close to it)
                let colValue;
                let colIndex = 1;
                mainGridColumns.forEach((col) => {
                    col = parseInt(col); // because the browser may have minor decimal point variations, we'll parse to int
                    if (!colValue) {
                        colValue = col;
                    } else {
                        colIndex += 1;
                    }
                    assert(col === colValue || col + 1 === colValue || col === colValue + 1, // because the variation may be like 255.999 and 256.001, we'll allow one pixel off in either direction
                        `Expected column #${colIndex} to have the same width as column #1. Column #1 width is '${colValue}px'; column #${colIndex} width is '${col}px'.`);
                });
            });

            // main-grid has gap of 20px, 50px
            it('main-grid must have row gap 20px and column gap 50px', () => {
                cy.get('#main-grid').should('have.css', 'row-gap').should('equal', '20px');
                cy.get('#main-grid').should('have.css', 'column-gap').should('equal', '50px');
            });

            // main-grid must have valid grid-template-areas with 4 rows and 3 columns
            it('main-grid must have valid grid-template-areas with 4 rows and 3 columns', () => {
                checkRowsAndColumns(mainGrid, 4, 3);
            });

            // In main-grid, grid child "headline" must be in row 0, columns 0-1
            it('In main-grid, grid child "headline" must be in row 0, columns 0-1', () => {
                checkMainGridArea('#headline', 0, 0);
                checkMainGridArea('#headline', 0, 1);
            });

            // In main-grid, grid child "student-picture" must be in rows 0-1, column 2
            it('In main-grid, grid child "student-picture" must be in rows 0-1, column 2', () => {
                checkMainGridArea('#student-picture', 0, 2);
                checkMainGridArea('#student-picture', 1, 2);
            });

            // In main-grid, grid child "student-quote" must be in row 1, columns 0-1
            it('In main-grid, grid child "student-quote" must be in row 1, columns 0-1', () => {
                checkMainGridArea('#student-quote', 1, 0);
                checkMainGridArea('#student-quote', 1, 1);
            });

            // In main-grid, grid child "student-profile" must be in row 2, columns 0-1
            it('In main-grid, grid child "student-profile" must be in row 2, columns 0-1', () => {
                checkMainGridArea('#student-profile', 2, 0);
                checkMainGridArea('#student-profile', 2, 1);
            });

            // In main-grid, grid child "student-contact" must be in row 2, column 2
            it('In main-grid, grid child "student-contact" must be in row 2, column 2', () => {
                checkMainGridArea('#student-contact', 2, 2);
            });

            // In main-grid, grid child "experience-grid" must be in row 3, columns 0-2
            it('In main-grid, grid child "experience-grid" must be in row 3, columns 0-2', () => {
                checkMainGridArea('#experience-grid', 3, 0);
                checkMainGridArea('#experience-grid', 3, 1);
                checkMainGridArea('#experience-grid', 3, 2);
            });

            // In main-grid, cell content must be vertically centered using align-items
            it('In main-grid, cell content must be vertically centered using align-items', () => {
                cy.get('#main-grid').should('have.css', 'align-items').should('equal', 'center');
            });

            // In main-grid, the student picture and contact information must be horizontally centered
            it('In main-grid, the student picture and contact information must be horizontally centered', () => {
                cy.get('#student-picture').should("satisfy", ($ele) => {
                    return ($ele.css('text-align') === "center"
                        ||  $ele.css('justify-self') === "center")
                });
                cy.get('#student-contact').should("satisfy", ($ele) => {
                    return ($ele.css('text-align') === "center"
                        ||  $ele.css('justify-self') === "center")
                });
            });


            // experience-grid must have valid grid-template-areas with 3 rows and 2 columns
            it('experience-grid must have valid grid-template-areas with 3 rows and 2 columns', () => {
                checkRowsAndColumns(experienceGrid, 3, 2);
            });

            // experience-grid has gap of 20px, 50px
            it('experience-grid must have row gap 20px and column gap 50px', () => {
                cy.get('#experience-grid').should('have.css', 'row-gap').should('equal', '20px');
                cy.get('#experience-grid').should('have.css', 'column-gap').should('equal', '50px');
            });

            // experience grid columns (children) are equal widths
            it('experience-grid must have 2 columns of equal width', () => {
                assert(experienceGridColumns.length === 2, "There must be 2 columns in grid-template-columns.");

                // Make sure they all have the same width (or close to it)
                let colValue;
                let colIndex = 1;
                experienceGridColumns.forEach((col) => {
                    col = parseInt(col); // because the browser may have minor decimal point variations, we'll parse to int
                    if (!colValue) {
                        colValue = col;
                    } else {
                        colIndex += 1;
                    }
                    assert(col === colValue || col + 1 === colValue || col === colValue + 1, // because the variation may be like 255.999 and 256.001, we'll allow one pixel off in either direction
                        `Expected column #${colIndex} to have the same width as column #1. Column #1 width is '${colValue}px'; column #${colIndex} width is '${col}px'.`);
                });
            });

            // In experience-grid, grid child "experience-code" must be in row 0, columns 0-1
            it('In experience-grid, grid child "experience-code" must be in row 0, columns 0-1', () => {
                checkExperienceGridArea('#experience-code', 0, 0);
                checkExperienceGridArea('#experience-code', 0, 1);
            });

            // In experience-grid, grid child "experience-database" must be in row 1, columns 0-1
            it('In experience-grid, grid child "experience-database" must be in row 1, columns 0-1', () => {
                checkExperienceGridArea('#experience-database', 1, 0);
                checkExperienceGridArea('#experience-database', 1, 1);
            });

            // In experience-grid, grid child "experience-web" must be in row 2, column 0
            it('In experience-grid, grid child "experience-web" must be in row 1, column 0', () => {
                checkExperienceGridArea('#experience-web', 2, 0);
            });

            // In experience-grid, grid child "experience-design" must be in row 2, column 1
            it('In experience-grid, grid child "experience-design" must be in row 2, column 1', () => {
                checkExperienceGridArea('#experience-design', 2, 1);
            });
        });


    // Grid layout for Tablet ( <= 1024px && > 450px)
    describe('Step three: Create the tablet layout', {
        viewportWidth: 1024,
        viewportHeight: 600
    },
        () => {
            beforeEach(() => {
                cy.get('#main-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    mainGrid = getGridAreas(gta);
                    cy.log(mainGrid);
                });

                cy.get('#main-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    mainGridColumns = getGridColumns(gtc);
                    cy.log(mainGridColumns);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    experienceGrid = getGridAreas(gta);
                    cy.log(experienceGrid);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    experienceGridColumns = getGridColumns(gtc);
                    cy.log(experienceGridColumns);
                });

            });

            // main-grid must have valid grid-template-areas with 5 rows and 2 columns
            it('main-grid must have valid grid-template-areas with 5 rows and 2 columns', () => {
                checkRowsAndColumns(mainGrid, 5, 2);
            });

            // main-grid has gap of 20px, 35px
            it('main-grid must have row gap 20px and column gap 35px', () => {
                cy.get('#main-grid').should('have.css', 'row-gap').should('equal', '20px');
                cy.get('#main-grid').should('have.css', 'column-gap').should('equal', '35px');
            });

            // main grid columns (children) are equal widths
            it('main-grid must have 2 columns of equal width', () => {
                assert(mainGridColumns.length === 2, "There must be 2 columns in grid-template-columns.");

                // Make sure they all have the same width (or close to it)
                let colValue;
                let colIndex = 1;
                mainGridColumns.forEach((col) => {
                    col = parseInt(col); // because the browser may have minor decimal point variations, we'll parse to int
                    if (!colValue) {
                        colValue = col;
                    } else {
                        colIndex += 1;
                    }
                    assert(col === colValue || col + 1 === colValue || col === colValue + 1, // because the variation may be like 255.999 and 256.001, we'll allow one pixel off in either direction
                        `Expected column #${colIndex} to have the same width as column #1. Column #1 width is '${colValue}px'; column #${colIndex} width is '${col}px'.`);
                });
            });

            // In main-grid, grid child "headline" must be in row 0, columns 0-1
            it('In main-grid, grid child "headline" must be in row 0, columns 0-1', () => {
                checkMainGridArea('#headline', 0, 0);
                checkMainGridArea('#headline', 0, 1);
            });

            // In main-grid, grid child "student-picture" must be in rows 1, column 1
            it('In main-grid, grid child "student-picture" must be in row 1, column 1', () => {
                checkMainGridArea('#student-picture', 1, 1);
            });

            // In main-grid, grid child "student-quote" must be in rows 1-2, column 0
            it('In main-grid, grid child "student-quote" must be in rows 1-2, column 0', () => {
                checkMainGridArea('#student-quote', 1, 0);
                checkMainGridArea('#student-quote', 2, 0);
            });

            // In main-grid, grid child "student-contact" must be in row 2, column 1
            it('In main-grid, grid child "student-contact" must be in row 2, column 1', () => {
                checkMainGridArea('#student-contact', 2, 1);
            });

            // In main-grid, grid child "student-profile" must be in row 3, columns 0-1
            it('In main-grid, grid child "student-profile" must be in row 3, columns 0-1', () => {
                checkMainGridArea('#student-profile', 3, 0);
                checkMainGridArea('#student-profile', 3, 1);
            });

            // In main-grid, grid child "experience-grid" must be in row 4, columns 0-1
            it('In main-grid, grid child "experience-grid" must be in row 4, columns 0-1', () => {
                checkMainGridArea('#experience-grid', 4, 0);
                checkMainGridArea('#experience-grid', 4, 1);
            });

            // experience-grid must have valid grid-template-areas with 2 rows and 2 columns
            it('experience-grid must have valid grid-template-areas with 2 rows and 2 columns', () => {
                checkRowsAndColumns(experienceGrid, 2, 2);

                // assert(experienceGrid.length === 3, "There must be 3 rows in the grid area.");
                // experienceGrid.forEach((cols) => {
                //     assert(cols.length === 2, "There must be 2 columns in every row of the grid area.");
                // });
            });

            // experience-grid has gap of 20px, 20px
            it('experience-grid must have row gap 20px and column gap 20px', () => {
                cy.get('#experience-grid').should('have.css', 'row-gap').should('equal', '20px');
                cy.get('#experience-grid').should('have.css', 'column-gap').should('equal', '20px');
            });

            // experience grid columns (children) are equal widths
            it('experience-grid must have 2 columns of equal width', () => {
                assert(experienceGridColumns.length === 2, "There must be 2 columns in grid-template-columns.");

                // Make sure they all have the same width (or close to it)
                let colValue;
                let colIndex = 1;
                experienceGridColumns.forEach((col) => {
                    col = parseInt(col); // because the browser may have minor decimal point variations, we'll parse to int
                    if (!colValue) {
                        colValue = col;
                    } else {
                        colIndex += 1;
                    }
                    assert(col === colValue || col + 1 === colValue || col === colValue + 1, // because the variation may be like 255.999 and 256.001, we'll allow one pixel off in either direction
                        `Expected column #${colIndex} to have the same width as column #1. Column #1 width is '${colValue}px'; column #${colIndex} width is '${col}px'.`);
                });
            });

            // In experience-grid, grid child "experience-code" must be in row 0, column 0
            it('In experience-grid, grid child "experience-code" must be in row 0, column 0', () => {
                checkExperienceGridArea('#experience-code', 0, 0);
            });

            // In experience-grid, grid child "experience-database" must be in row 1, column 0
            it('In experience-grid, grid child "experience-database" must be in row 1, column 0', () => {
                checkExperienceGridArea('#experience-database', 1, 0);
            });

            // In experience-grid, grid child "experience-web" must be in row 0, column 1
            it('In experience-grid, grid child "experience-web" must be in row 0, column 1', () => {
                checkExperienceGridArea('#experience-web', 0, 1);
            });

            // In experience-grid, grid child "experience-design" must be in row 1, column 1
            it('In experience-grid, grid child "experience-design" must be in row 1, column 1', () => {
                checkExperienceGridArea('#experience-design', 1, 1);
            });
        });


    // Grid layout for Tablet ( <= 450px)
    describe('Step four: Create the phone layout', {
        viewportWidth: 450,
        viewportHeight: 700
    },
        () => {
            beforeEach(() => {
                cy.get('#main-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    mainGrid = getGridAreas(gta);
                    cy.log(mainGrid);
                });

                cy.get('#main-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    mainGridColumns = getGridColumns(gtc);
                    cy.log(mainGridColumns);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-areas').then((gta) => {
                    cy.log(gta);
                    experienceGrid = getGridAreas(gta);
                    cy.log(experienceGrid);
                });

                cy.get('#experience-grid').should('have.css', 'grid-template-columns').then((gtc) => {
                    cy.log(gtc);
                    experienceGridColumns = getGridColumns(gtc);
                    cy.log(experienceGridColumns);
                });

            });

            // main-grid must have valid grid-template-areas with 6 rows and 1 column
            it('main-grid must have valid grid-template-areas with 6 rows and 1 column', () => {
                checkRowsAndColumns(mainGrid, 6, 1);
            });

            // In main-grid, grid child "headline" must be in row 0, column 0
            it('In main-grid, grid child "headline" must be in row 0, column 0', () => {
                checkMainGridArea('#headline', 0, 0);
            });

            // In main-grid, grid child "student-picture" must be in row 1, column 0
            it('In main-grid, grid child "student-picture" must be in row 1, column 0', () => {
                checkMainGridArea('#student-picture', 1, 0);
            });

            // In main-grid, grid child "student-contact" must be in row 2, column 0
            it('In main-grid, grid child "student-contact" must be in row 2, column 0', () => {
                checkMainGridArea('#student-contact', 2, 0);
            });

            // In main-grid, grid child "student-quote" must be in row 3, column 0
            it('In main-grid, grid child "student-quote" must be in row 3, column 0', () => {
                checkMainGridArea('#student-quote', 3, 0);
            });

            // In main-grid, grid child "student-profile" must be in row 4, column 0
            it('In main-grid, grid child "student-profile" must be in row 4, column 0', () => {
                checkMainGridArea('#student-profile', 4, 0);
            });

            // In main-grid, grid child "experience-grid" must be in row 5, column 0
            it('In main-grid, grid child "experience-grid" must be in row 5, column 0', () => {
                checkMainGridArea('#experience-grid', 5, 0);
            });

            // experience-grid must have valid grid-template-areas with 4 rows and 1 column
            it('experience-grid must have valid grid-template-areas with 4 rows and 1 column', () => {
                checkRowsAndColumns(experienceGrid, 4, 1);
            });

            // In experience-grid, grid child "experience-code" must be in row 0, column 0
            it('In experience-grid, grid child "experience-code" must be in row 0, column 0', () => {
                checkExperienceGridArea('#experience-code', 0, 0);
            });

            // In experience-grid, grid child "experience-web" must be in row 1, column 0
            it('In experience-grid, grid child "experience-web" must be in row 1, column 0', () => {
                checkExperienceGridArea('#experience-web', 1, 0);
            });

            // In experience-grid, grid child "experience-database" must be in row 2, column 0
            it('In experience-grid, grid child "experience-database" must be in row 2, column 0', () => {
                checkExperienceGridArea('#experience-database', 2, 0);
            });

            // In experience-grid, grid child "experience-design" must be in row 3, column 0
            it('In experience-grid, grid child "experience-design" must be in row 3, column 0', () => {
                checkExperienceGridArea('#experience-design', 3, 0);
            });
        });



    /**
     * Parses the string that is the grid-template-areas value and creates an array representation of the areas.
     * @param {string} gta - Value of the grid-template-areas attribute.
     * @returns Array of arrays representing grid-template-areas. Outer array is the rows of the grid. Each element is an array of columns.
     */
    function getGridAreas(gta) {
        let grid = [];
        let gtaRows = gta.split('"').filter(s => s.trim().length > 0);
        gtaRows.forEach((gtaRow) => {
            let cols = gtaRow.split(' ').filter(s => s.trim().length > 0);
            grid.push(cols);
        });
        return grid;
    }

    /**
     * Parses the string that is the grid-template-columns value and creates an array representation of the columns.
     * @param {string} gtc - Value of the grid-template-columns attribute.
     * @returns Array representing grid-template-columns values.
     */
    function getGridColumns(gtc) {
        let cols = gtc.split(' ').filter(s => s.trim().length > 0);
        return cols;
    }

    /**
     * Checks to make sure that the grid-area specified for a grid child matches the proper area in grid-template-areas for the grid.
     * @param {string} selector The css selector to find the grid child element which should have a grid-area css property.
     * @param {number} rowIndex Zero-based row index of where the grid-area is expected inside grid-template-areas
     * @param {number} colIndex Zero-based column index of where the grid-area is expected inside grid-template-areas
     */
    function checkMainGridArea(selector, rowIndex, colIndex) {
        cy.get(selector).should('have.css', 'grid-area').then((area) => {
            // For some reason, area contains "headline / headline / headline / headline" I have not been able to figure out why.
            // My workaround is to reduce it to the first word.
            area = area.split(' ')[0];
            assert(area === mainGrid[rowIndex][colIndex], `Expected row ${rowIndex}, column ${colIndex} to contain '${area}' but it contains ${mainGrid[rowIndex][colIndex]}.`);
        });
    }

    /**
     * Checks to make sure that the grid-area specified for a grid child matches the proper area in grid-template-areas for the grid.
     * @param {string} selector The css selector to find the grid child element which should have a grid-area css property.
     * @param {number} rowIndex Zero-based row index of where the grid-area is expected inside grid-template-areas
     * @param {number} colIndex Zero-based column index of where the grid-area is expected inside grid-template-areas
     */
    function checkExperienceGridArea(selector, rowIndex, colIndex) {
        cy.get(selector).should('have.css', 'grid-area').then((area) => {
            // For some reason, area contains "headline / headline / headline / headline" I have not been able to figure out why.
            // My workaround is to reduce it to the first word.
            area = area.split(' ')[0];
            assert(area === experienceGrid[rowIndex][colIndex], `Expected row ${rowIndex}, column ${colIndex} to contain '${area}' but it contains ${experienceGrid[rowIndex][colIndex]}.`);
        });
    }

    function checkRowsAndColumns(grid, expectedRows, expectedColumns) {
        assert(grid.length === expectedRows, `Expected ${expectedRows} rows in the grid area, but there were ${mainGrid.length}.`);
        grid.forEach((cols) => {
            assert(cols.length === expectedColumns, `Expected ${expectedColumns} in every row, but a row has ${cols.length} columns.`);
        });
    }

    function checkValidGridArea(selector) {
        cy.get(selector).should('have.css', 'grid-area').then((area) => {
            assert(area !== 'auto / auto / auto / auto', `${selector} must be assigned to a grid-area`);
        });
    }
});
