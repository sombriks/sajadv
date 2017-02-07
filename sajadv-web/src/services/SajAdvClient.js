
// durante a fase de construção do cliente o browserify pode fornecer variáveis
// para os componentes. Deste modo alternar entre ambientes de desenvolvimento
// e de produção resume-se a uma opção de construção nos scripts npm
const servicoAddr = process.env.SERVICOADDR || "http://127.0.0.1:8080/sajadv-core-1.0-SNAPSHOT/resources";

// aqui consumimos as chamadas REST do serviço
class SajAdvClient {

  // ao injetarmos as comodidades do angular, guardamos elas como atributos de 
  // instância para outros métodos poderem utilizar.
  constructor($http) {
    this.$http = $http;
  }

  status() {
    return this.$http.get(servicoAddr);
  }

  buscasituacoes() {
    return this.$http.get(`${servicoAddr}/situacoes`);
  }

  buscaprocessos(filtro) {
    return this.$http.get(`${servicoAddr}/processos`, {params: filtro});
  }

  buscaresponsaveis(filtro) {
    return this.$http.get(`${servicoAddr}/responsaveis`, {params: filtro});
  }

  findresponsavel(cpf) {
    return this.$http.get(`${servicoAddr}/responsavel/${cpf}`);
  }

  findprocesso(numeroProcessoUnificado) {
    return this.$http.get(`${servicoAddr}/processo/${numeroProcessoUnificado}`);
  }

  processosresponsavel(cpf) {
    return this.$http.get(`${servicoAddr}/processos/${cpf}`);
  }

  saveresponsavel(responsavel) {
    return this.$http.post(`${servicoAddr}/responsavel`, responsavel);
  }

  saveprocesso(processo) {
    return this.$http.post(`${servicoAddr}/processo`, processo);
  }
  
}

module.exports = SajAdvClient;