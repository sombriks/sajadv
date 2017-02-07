"use strict";
/* global __dirname */

// processo/consulta.js
const fs = require("fs");
// https://momentjs.com/docs/#/manipulating/
const moment = require("moment");

class ProcessoConsulta {

  constructor($rootScope, SajAdvClient) {
    this.client = SajAdvClient;
    $rootScope.titulosecao = "Gestão de Processos | Consultar Processo";
    this.filtro = {
      inicioDataDistribuicao: moment().add(-1, "months").toDate(),
      fimDataDistribuicao: moment().add(1, "months").toDate(),
      numeroProcessoUnificado: "",
      pastaFisicaCliente: "",
      segredoJustica: false,
      nomeResponsavel: "",
      idSituacao: 0,
      limit: 5,
      page: 1
    };
    this.dados = {resultProcesso: [], countprocessos: 0};

    this.client.buscasituacoes().then((ret) => this.situacoes = ret.data);
  }

  doquery() {
    console.log("doquery!");
    this.client.buscaprocessos(this.filtro).then((ret) => this.dados = ret.data);
  }
  
}

module.exports = {
  path: "/processo/consulta",
  route: {
    template: fs.readFileSync(__dirname + "/consulta.html", "utf8"),
    controller: ProcessoConsulta,
    controllerAs: "ctl"
  }
};