const { defineConfig } = require('cypress')

module.exports = defineConfig({
  viewportWidth: 1280,
  viewportHeight: 720,
  video: true,
  e2e: {
    baseUrl: 'https://automationexercise.com',
    specPattern: '**/*.feature',  // Altere conforme necessário para seus testes
    supportFile: 'cypress/support/e2e.js',  // Especifica o caminho para o arquivo de suporte e2e
  }
});
