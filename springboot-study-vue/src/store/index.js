import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    ua: ''
  },
  mutations: {
    ua(state, ua) {
      state.ua = ua
    }
  },
  getters: {
    ua(state) {
      return state.ua
    }
  }
})

export default store