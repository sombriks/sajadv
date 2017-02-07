// main.js
const angular = require("angular");
const modulodoc = require("./modulodoc");

// injetando o css entrypoint
require("./main.css");

// bootstrap da aplicação SPA no body do documento  
angular.bootstrap(document.body, [modulodoc.name]);
