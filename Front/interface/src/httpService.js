const axios = require('axios');

const solicitudHttp = axios.create({
  baseURL: 'http://localhost:8080:/coches',
  timeout: 1000,
  headers: {'X-Custom-Header': 'foobar'}
});

module.exports = solicitudHttp;