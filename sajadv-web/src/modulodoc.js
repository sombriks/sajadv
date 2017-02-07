// modulodoc.js
const moment = require("moment");

// o módulo angular
const modulodoc = angular.module('modulodoc', [
  require("angular-aria"),
  require("angular-route"),
  require("angular-animate"),
  require("angular-material"),
  require('angular-material-data-table')
]);

const processo_consulta = require("./features/processo/consulta");
const processo_cadastro = require("./features/processo/cadastro");
const responsavel_consulta = require("./features/responsavel/consulta");
const responsavel_cadastro = require("./features/responsavel/cadastro");

// serviço angular para consultarmos as api's rest
modulodoc.service("SajAdvClient", require("./services/SajAdvClient"));

// kit de ícones
// https://materialdesignicons.com
modulodoc.config(function ($mdIconProvider) {
  $mdIconProvider.defaultIconSet('mdi.svg', 24);
});

// garantindo que os datepickers respeitarão o locale
modulodoc.config(function ($mdDateLocaleProvider) {
  $mdDateLocaleProvider.formatDate = function (date) {
    return moment(date).format('DD/MM/YYYY');
  };
});

// roteamento client-side
modulodoc.config(($routeProvider) => {
  // https://docs.angularjs.org/api/ngRoute/provider/$routeProvider
  $routeProvider
  .when(processo_consulta.path, processo_consulta.route)
  .when(processo_cadastro.path, processo_cadastro.route)
  .when(responsavel_consulta.path, responsavel_consulta.route)
  .when(responsavel_cadastro.path, responsavel_cadastro.route)
  .otherwise("/processo/consulta");
});

// usualmente os exports vem no fim do documento para garantirmos que todos os
// símbolos foram definidos antes de disponibilizarmos o módulo
module.exports = modulodoc;