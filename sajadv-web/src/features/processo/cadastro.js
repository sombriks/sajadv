/* global __dirname */

// processo/cadastro.js
const fs = require("fs");

class ProcessoCadastro {

  constructor($rootScope, $routeParams, $location, SajAdvClient) {
    $rootScope.titulosecao = "Gestão de Processos | Cadastrar Processo";
    this.$location = $location;
    this.client = SajAdvClient;
    this.client.buscasituacoes().then((ret) => {
      this.situacoes = ret.data;
      this.numeroProcessoUnificado = $routeParams.numeroProcessoUnificado;
      if (this.numeroProcessoUnificado != "novo") {
        this.client.findprocesso(this.numeroProcessoUnificado).then((ret) => {
          ret.data.dataDistribuicao = new Date(ret.data.dataDistribuicao);
          this.processo = ret.data;
          return this.client.buscaprocessos({
            numeroProcessoPai: this.numeroProcessoUnificado,
            idSituacao: 0,
            page: 1,
            limit: 10
          });
        }).then((ret) => {
          this.processosfilhos = ret.data;
        });
      }
    });
    this.processo = {
      responsaveis: [],
      dataDistribuicao: new Date()
    };
  }

  dosave(stay) {
    console.log("dosave!");
    this.client.saveprocesso(this.processo).then((ret) => {
      alert("Processo salvo com sucesso");
      if(!stay)
        this.$location.path("/processo/consulta");
    });
  }

  buscaresponsaveis(text) {
    return this.client.buscaresponsaveis({nome: text, page: 1, limit: 10, cpf: ""}).then((ret) => {
      return ret.data.resultResponsavel;
    });
  }

  adicionaResponsavel() {
    if (this.selectedItem) {
      if (confirm("Adicionar responsável a este processo?")) {
        this.processo.responsaveis.push(this.selectedItem);
        this.dosave(true);
      }
    }
  }
  
  removeResponsavel(resp) {
    if(resp && confirm("Quer realmente remover este responsável?")){
      this.processo.responsaveis = this.processo.responsaveis.filter((e) => e.cpf != resp.cpf);
      this.dosave(true);
    }
  }
}
;

module.exports = {
  path: "/processo/cadastro/:numeroProcessoUnificado",
  route: {
    template: fs.readFileSync(__dirname + "/cadastro.html", "utf8"),
    controller: ProcessoCadastro,
    controllerAs: "ctl"
  }
};