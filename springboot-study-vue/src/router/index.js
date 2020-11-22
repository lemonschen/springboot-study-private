import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Novel from '@/components/pages/novel'
import Chapter from '@/components/pages/chapter'
import Reader from '@/components/pages/reader'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/novel',
      name: 'Novel',
      component: Novel
    },
    {
      path: '/chapter',
      name: 'Chapter',
      component: Chapter
    },
    {
      path: '/reader',
      name: 'Reader',
      component: Reader
    }
  ]
})
