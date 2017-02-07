/* global __dirname */

// responsavel/consulta.js
const fs = require("fs");

class ResponsavelConsulta {

  constructor($rootScope, SajAdvClient) {
    this.client = SajAdvClient;
    $rootScope.titulosecao = "Gestão de Processos | Consultar Responsável";
    this.filtro = {
      cpf: "",
      nome: "",
      numeroProcessoUnificado: "",
      limit: 5,
      page: 1
    };
    this.dados = {resultResponsavel: [], countresponsaveis: 0};
  }

  doquery() {
    console.log("doquery!");
    this.client.buscaresponsaveis(this.filtro).then((ret) => this.dados = ret.data);
  }

}

module.exports = {
  path: "/responsavel/consulta",
  route: {
    template: fs.readFileSync(__dirname + "/consulta.html", "utf8"),
    controller: ResponsavelConsulta,
    controllerAs: "ctl"
  }
};