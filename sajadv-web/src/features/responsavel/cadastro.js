/* global __dirname */

// responsavel/cadastro.js
const fs = require("fs");

class ResponsavelCadastro {
  
  constructor($rootScope, $routeParams, $location, SajAdvClient) {

    $rootScope.titulosecao = "Gestão de Processos | Cadastrar Responsável";
    this.client = SajAdvClient;
    this.responsavel = {};
    this.dados = {resultProcesso: [], countprocessos: 0};
    this.filtro = {limit: 5, page: 1};
    this.cpf = $routeParams.cpf;
    this.$location = $location;

    if (this.cpf != "novo") {
      this.client.findresponsavel(this.cpf).then((ret) => {
        this.responsavel = ret.data;
        return this.client.processosresponsavel(this.cpf);
      }).then((ret) => this.dados = ret.data);
    }
  }

  dosave() {
    console.log("dosave!");
    this.client.saveresponsavel(this.responsavel).then(() => {
      alert("Responsável salvo com sucesso!");
      this.$location.path("/responsavel/consulta");
    });
  }
  
}

module.exports = {
  path: "/responsavel/cadastro/:cpf",
  route: {
    template: fs.readFileSync(__dirname + "/cadastro.html", "utf8"),
    controller: ResponsavelCadastro,
    controllerAs: "ctl"
  }
};