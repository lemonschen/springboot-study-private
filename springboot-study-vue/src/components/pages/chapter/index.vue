<template>
  <div class="s-page">
    <vue-scroll class="s-scroll">
      <div class="s-content">
        <div class="s-chapter-list">
          <div v-for="item in chapters" :key="item.noveId" class="s-chapter-item">
            <el-link class="s-chapter-title" @click="readerChapter(item)">{{ item.chapterName }}</el-link>
          </div>
        </div>
      </div>
    </vue-scroll>
    <div class="s-pagination">
      <el-pagination
        @current-change="handleCurrentChange"
        :page-size="page.pageSize"
        :total="page.totalSize"
        :pager-count="page.pagerCount"
        layout="prev, pager, next"
      ></el-pagination>
    </div>
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
        pagerCount: 5,
      },
      chapters: [],
      novelId:0
    };
  },
  created() {
    if (!this.$store.getters.token) {
      this.$router.push({ name: "HelloWorld" });
    } else if (this.$route.params.novelId === undefined) {
      if(this.$store.getters.novelId){
        this.novelId = this.$store.getters.novelId
      }else{
        this.$router.push({ name: "Novel" });
      }
    }else {
      this.novelId = this.$route.params.novelId;
      this.$store.commit('novelId',this.$route.params.novelId)
    }
  },
  mounted() {
    this.loadChapters();
  },
  methods: {
    loadChapters() {
      if(this.novelId){
        
        const loading = this.$loading({
          lock:true,
          text:'hi 好久不见，你还好吗 ~',
          background:'rgba(255,255,255,0)'
        })
        this.$get
          .findChapters(
            this.novelId,
            this.page.pageIndex,
            this.page.pageSize
          )
          .then((res) => {
            loading.close();
            this.chapters = res.result;
            this.page.totalSize = res.totalSize;
          }).catch(err=>{loading.close();});
      }
    },
    handleCurrentChange(val) {
      console.log(val);
      this.page.pageIndex = val - 1;
      this.loadChapters();
    },
    readerChapter(chatper){
      this.$router.push({name:"Reader",params:{novelId:chatper.novelId,chapterIndex:chatper.chapterIndex}})
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
      padding 30px 0
      display flex
      flex-direction column
      align-items center
      cursor pointer
      .s-chapter-list
        max-width 1000px
        display flex
        flex-wrap wrap
        justify-content center
        .s-chapter-item
          width 300px
          .s-chapter-title
            font-size 14px
            line-height 30px
            padding 0 10px
            display flex
            justify-content flex-start
            width 280px
            overflow hidden
            text-overflow ellipsis
            white-space nowrap
  .s-pagination
    width 100%
    height 40px
    display flex
    justify-content center
    align-items center
</style>