/// <reference types="cypress" />

describe('Formulário de Contato - Automation Exercise', () => {
  it('Envia o formulário de contato com sucesso', () => {

    cy.fixture('contactData').then((data) => {


      cy.visit('https://automationexercise.com/contact_us');


      cy.get('input[data-qa="name"]').type(data.name);
      cy.get('input[data-qa="email"]').type(data.email);
      cy.get('input[data-qa="subject"]').type(data.subject);
      cy.get('textarea[data-qa="message"]').type(data.message);


      cy.get('input[name="upload_file"]').attachFile('example.txt');


      cy.get('input[data-qa="submit-button"]').click();


      cy.get('.status.alert.alert-success').should('contain', 'Success! Your details have been submitted successfully.');
    });
  });
});
