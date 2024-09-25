import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';

Given('I open the contact page', () => {
  cy.visit('/contact_us');
});

When('I fill in the contact form', () => {
  cy.get('[data-qa="name"]').type('Seu Nome');
  cy.get('[data-qa="email"]').type('email@exemplo.com');
  cy.get('[data-qa="subject"]').type('Assunto de Teste');
  cy.get('[data-qa="message"]').type('Esta é uma mensagem de teste.');
});

When('I submit the form', () => {
  cy.get('[data-qa="submit_button"]').click();
});

Then('I should see a success message', () => {
  cy.get('.status.alert.alert-success').should('contain', 'Success! Your details have been submitted successfully.');
});
