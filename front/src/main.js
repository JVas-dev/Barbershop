import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import axios from 'axios';

Vue.config.productionTip = false;
window.axios = require('axios');

new Vue({
  axios,
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
