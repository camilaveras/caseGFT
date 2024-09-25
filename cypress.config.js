const { defineConfig } = require('cypress');

module.exports = defineConfig({
  e2e: {
    specPattern: "automacaoWeb/cypress/e2e/**/*.cy.js",
    supportFile: "automacaoWeb/cypress/support/index.js",
    baseUrl: 'https://automationexercise.com',
    fixturesFolder: "automacaoWeb/cypress/fixtures",
    viewportWidth: 1280,
    viewportHeight: 720
  },
});
