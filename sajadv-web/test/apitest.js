// test/apitest.js
// verificar se as rotas de serviço fazem o que devem fazer
// para executar rode o script npm:
// npm run test (ou npm run testnb)

const chai = require("chai");
const axios = require("axios");
const api = axios.create({
  baseURL: process.env.SERVICOADDR || "http://127.0.0.1:8080/sajadv-core-1.0-SNAPSHOT/resources"
});


chai.should();

describe("testes das rodas oferecidas pelo sajadv-core", () => {

  it("deveria recuperar as situações", (done) => {
    api.get("/situacoes").then((ret) => {
      ret.data.should.be.an("object");
      ret.status.should.be.equal(200);
      done();
    }).catch((err) => done(err));
  });

  it("deveria recuperar processos", (done) => {
    api.get("/processos?page=1&limit=10").then((ret) => {
      ret.data.should.be.an("object");
      ret.status.should.be.equal(200);
      done();
    }).catch((err) => done(err));
  });

});