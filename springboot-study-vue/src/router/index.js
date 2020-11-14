import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/index'
import Axois from 'axios'
import VueAxios from "vue-axios";

Vue.use(Router)
Vue.use(VueAxios,Axois)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    }
  ]
})
