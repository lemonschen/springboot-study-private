// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import get from './api/get.js'
import './axios/index.js'
import './utils/dialog.js'
import Components from './utils/components.js';

Vue.use(VueAxios,Axios)
Vue.use(ElementUI)
Vue.use(Components)

Vue.prototype.$get = get

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
