import axios from 'axios'

export const findNovels = (page,size) => axios.get('novel',{params:{page:page,size:size}})
// export const findNovels = (page,size) => new Promise((resolve,rejiect)=>{resolve("收到"+page+"/"+size)})

export const findChapters = (novelId,page,size) => axios.get('novel/'+novelId,{params:{page:page,size:size}})

export const findChapter = (novelId,chapterIndex) => axios.get('novel/'+novelId+'/'+chapterIndex)

export const findPreviousChapter = (novelId,chapterIndex) => axios.get('novel/'+novelId+'/'+chapterIndex+'/previous')

export const findNextChapter = (novelId,chapterIndex) => axios.get('novel/'+novelId+'/'+chapterIndex+'/next')

export default {
    findNovels,
    findChapters,
    findChapter,
    findPreviousChapter,
    findNextChapter
}