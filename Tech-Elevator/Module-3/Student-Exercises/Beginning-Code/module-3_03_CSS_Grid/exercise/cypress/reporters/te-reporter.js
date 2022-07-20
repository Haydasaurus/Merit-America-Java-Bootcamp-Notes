// my-reporter.js
// See https://mochajs.org/api/tutorial-custom-reporter.html
'use strict';

const Mocha = require('mocha');
const {
  EVENT_RUN_BEGIN,
  EVENT_RUN_END,
  EVENT_TEST_FAIL,
  EVENT_TEST_PASS,
  EVENT_SUITE_BEGIN,
  EVENT_SUITE_END
} = Mocha.Runner.constants;

// this reporter outputs test results, indenting two spaces per suite
class MyReporter {
  constructor(runner) {
    this._indents = 0;
    const stats = runner.stats;

    runner
      .once(EVENT_RUN_BEGIN, () => {
        console.log('*** Start test run');
      })
      .on(EVENT_SUITE_BEGIN, (suite) => {
        console.log(`${this.indent()}${suite.title}`);
        this.increaseIndent();
      })
      .on(EVENT_SUITE_END, () => {
        this.decreaseIndent();
      })
      .on(EVENT_TEST_PASS, test => {
        // Test#fullTitle() returns the suite name(s) prepended to the test title
        console.log(`${this.indent()}✔ PASS: ${test.title}`);
      })
      .on(EVENT_TEST_FAIL, (test, err) => {
        //console.log(`${this.indent()}fail: ${test.fullTitle()} - error: ${err.message}`);
        console.log(`${this.indent()}❌ FAIL: ${test.title}`);
      })
      .once(EVENT_RUN_END, () => {
        console.log(`*** End test run: ${stats.passes} of ${stats.passes + stats.failures} passed.`);
      });
  }

  indent() {
    return Array(this._indents).join('  ');
  }

  increaseIndent() {
    this._indents++;
  }

  decreaseIndent() {
    this._indents--;
  }
}

module.exports = MyReporter;