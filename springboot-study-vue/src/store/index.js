import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const STUDY_TOKEN = 'study-token'
const STUDY_NOVEL_ID = 'study-novel-id'
const STUDY_CHAPTER_INDEX = 'study-chapter-index'
const store = new Vuex.Store({
    state: {
        ua: '',
        token: '',
        novelId:'',
        chapterIndex:''
    },
    mutations: {
        ua(state, ua) {
            state.ua = ua
        },
        token(state, token) {
            state.token = token
            sessionStorage.setItem(STUDY_TOKEN,token)
        },
        novelId(state, novelId) {
            state.novelId = novelId
            sessionStorage.setItem(STUDY_NOVEL_ID,novelId)
        },
        chapterIndex(state, chapterIndex) {
            state.chapterIndex = chapterIndex
            sessionStorage.setItem(STUDY_CHAPTER_INDEX,chapterIndex)
        }
    },
    getters: {
        ua(state) {
            return state.ua
        },
        token(state) {
            if(!state.token){
                let token = sessionStorage.getItem(STUDY_TOKEN);
                if(token){
                    state.token = token
                }
            }
            return state.token
        },
        novelId(state) {
            if(!state.novelId){
                let novelId = sessionStorage.getItem(STUDY_NOVEL_ID);
                if(novelId){
                    state.novelId = novelId
                }
            }
            return state.novelId
        },
        chapterIndex(state) {
            if(!state.chapterIndex){
                let chapterIndex = sessionStorage.getItem(STUDY_CHAPTER_INDEX);
                if(chapterIndex){
                    state.chapterIndex = chapterIndex
                }
            }
            return state.chapterIndex
        }
    }
})

export default store