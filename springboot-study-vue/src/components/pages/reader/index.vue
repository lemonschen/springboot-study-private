<template>
  <div class="s-page" ref="page">
    <vue-scroll class="s-scroll" ref="scrollBox" @handle-scroll="scrollHandler" :ops="{mode:'slide'}">
      <div class="s-content" ref="reader">
        <div class="s-text-item" v-for="chapter in chapters" :key="chapter.chapterIndex">
          <div class="s-text-reader s-text-title">{{chapter && chapter.chapterName}}</div>
          <pre class="s-text-reader">{{ chapter && chapter.content}}</pre>
        </div>
      </div>
    </vue-scroll>
  </div>
</template>
<script>
export default {
  name: "novel",
  data() {
    return {
      page: {
        pageIndex: 0,
        pageSize: 100,
        totalSize: 0,
        pagerCount: 11,
      },
      chapters: [],
      chaptersMaxContainer:20,
      novelId: 0,
      chapterIndex: 0,
      scrollTop:0,
      scrollHeight:0,
      pageHeight:0,
      loading:false
    };
  },
  created() {
    if (!this.$store.getters.token) {
      this.$router.push({ name: "HelloWorld" });
    } else if (
      this.$route.params.novelId === undefined &&
      this.$route.params.chapterIndex === undefined
    ) {
      if (this.$store.getters.novelId && typeof this.$store.getters.chapterIndex === 'number') {
        this.novelId = this.$store.getters.novelId;
        this.chapterIndex = this.$store.getters.chapterIndex;
      } else {
        this.$router.push({ name: "Chapter" });
      }
    } else {
      this.novelId = this.$route.params.novelId;
      this.chapterIndex = this.$route.params.chapterIndex;
      this.$store.commit("novelId", this.$route.params.novelId);
      this.$store.commit("chapterIndex", this.$route.params.chapterIndex);
    }
  },
  mounted() {
    this.loadChapter();
  },
  methods: {
    loadChapter() {
      if (this.novelId && typeof this.chapterIndex === 'number') {
        const loading = this.$loading({
          lock: true,
          text: "hi 好久不见，你还好吗 ~",
          background: "rgba(255,255,255,0)",
        });
        this.$get
          .findChapter(this.novelId, this.chapterIndex)
          .then((res) => {
            if(res){
              loading.close();
              this.chapters.push(res);
              this.updateTheLastChapterSize(0,0);
            }
          })
          .catch((err) => {
            loading.close();
          });
      }
    },
    updateFirstChapterSize(oldLength,oldFirstHeight){
      this.$nextTick(()=>{
        let scrollHeight = this.$refs.reader.clientHeight || this.$refs.reader.scrollHeight

        let chapters = this.chapters;

        let chapterHeight = 0;
        // 更新前容量已满就需要删除掉最后一章 当前scrollHeight是已替换过的高度
        if(oldLength === this.chaptersMaxContainer){
          chapterHeight = scrollHeight - (this.scrollHeight - oldFirstHeight)
        }
        // 否则不需要
        else{
          chapterHeight = scrollHeight - this.scrollHeight;
        }

        this.scrollHeight = scrollHeight;
        
        chapters[this.chapters.length-1].height = chapterHeight;

        this.chapters = JSON.parse(JSON.stringify(chapters));
        
        this.pageHeight = this.$refs.page.clientHeight || this.$refs.page.scrollHeight
        this.$refs.scrollBox.scrollTo(0,chapterHeight+this.$refs.scrollBox.getPosition().scrollTop);
        this.loading = false
      })
    },
    updateTheLastChapterSize(oldLength,oldFirstHeight){
      this.$nextTick(()=>{
        let scrollHeight = this.$refs.reader.clientHeight || this.$refs.reader.scrollHeight

        let chapters = this.chapters;

        let chapterHeight = 0;
        // 更新前容量已满就需要删除掉第一章 当前scrollHeight是已替换过的高度
        if(oldLength === this.chaptersMaxContainer){
          chapterHeight = scrollHeight - (this.scrollHeight - oldFirstHeight)
        }
        // 否则不需要
        else{
          chapterHeight = scrollHeight - this.scrollHeight;
        }

        this.scrollHeight = scrollHeight;
        
        chapters[this.chapters.length-1].height = chapterHeight;

        this.chapters = JSON.parse(JSON.stringify(chapters));

        this.pageHeight = this.$refs.page.clientHeight || this.$refs.page.scrollHeight

        this.loading = false
      })
    },
    scrollHandler(vertical, horizontal, nativeEvent){
      if(this.scrollHeight <= this.pageHeight){
        this.loadNext();
      }else if(this.scrollHandler < this.pageHeight * 3){
        if(vertical.process < 0.2 && !this.loading){
          this.loadPrevious();
        }else if(vertical.process > 0.8 && !this.loading){
          this.loadNext();
        }
      }else {
        if(vertical.scrollTop < 500 && !this.loading){
          this.loadPrevious();
        }else if(this.scrollHeight - this.pageHeight - vertical.scrollTop < 500 && !this.loading){
          this.loadNext();
        }
      }
    },
    loadPrevious(){
      this.loading = true;
      this.$get.findPreviousChapter(this.novelId,this.chapters[0].chapterIndex).then(res=>{
        if(res){
          this.chapterIndex = res.chapterIndex;
          this.$store.commit('chapterIndex',res.chapterIndex);
          let oldLength = this.chapters.length;
          let oldTheLastHeight = oldLength?this.chapters[this.chapters.length-1].height:0;
          if(oldLength === this.chaptersMaxContainer){
            this.chapters.pop();
          }
          this.chapters.unshift(res);
          this.updateFirstChapterSize(oldLength,oldFirstHeight);
        }else{
          this.loading = false
        }
      }).catch(err=>{this.loading = false});
    },
    loadNext(){
      this.loading = true;
      this.$get.findNextChapter(this.novelId,this.chapters[this.chapters.length-1].chapterIndex).then(res=>{
        if(res){
          this.chapterIndex = res.chapterIndex;
          this.$store.commit('chapterIndex',res.chapterIndex);
          let oldLength = this.chapters.length;
          let oldFirstHeight = oldLength?this.chapters[0].height:0;
          if(oldLength === this.chaptersMaxContainer){
            this.chapters.splice(0,1);
          }
          this.chapters.push(res);
          this.updateTheLastChapterSize(oldLength,oldFirstHeight);
        }else{
          this.loading = false
        }
      }).catch(err=>{this.loading = false});
    }
  },
};
</script>
<style lang="stylus" scoped>
.s-page
  width 100%
  height 100vh
  display flex
  align-items center
  flex-direction column
  .s-scroll
    width 100%
    flex 1
    .s-content
      width 100%
      display flex
      flex-direction column
      align-items center
      padding 30px 0
      .s-text-item
        width 100%
        display flex
        flex-direction column
        align-items center
        .s-text-reader
          padding 0 30px
          max-width 1000px
          word-break break-all
          word-wrap break-word
          white-space pre-wrap
          font-size 18px
          line-height 200%
          font-family '微软雅黑'
        .s-text-title
          font-size 20px
</style>