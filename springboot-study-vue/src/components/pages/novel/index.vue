<template>
  <div class="novel-page">
    <vue-scroll class="novel-scroll">
      <div class="novel-content">
        <div class="nove-list">
          <div v-for="item in novels" :key="item.noveId" @click="intoChapters(item)">
              <el-tooltip placement="right">
                  <div style="display:flex;flex-direction:column;font-size:14px" slot="content">
                      <div>{{item.novelName}}</div>
                      <div>{{item.author}}</div>
                  </div>
                  <el-image fit="fill" class="novel-image" :src="item.coverImage"></el-image>
              </el-tooltip>
          </div>
        </div>
      </div>
    </vue-scroll>
    <div class="novel-pagination">
      <el-pagination
        @current-change="handleCurrentChange"
        :pager-count="page.pagerCount"
        :page-size="page.pageSize"
        :total="page.totalSize"
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
      novels: [],
    };
  },
  created() {
    if (!this.$store.getters.token) {
      this.$router.push({ name: "HelloWorld" });
    }
  },
  mounted() {
    this.loadNovels();
  },
  methods: {
    loadNovels() {
      const loading = this.$loading({
        lock:true,
        text:'hi 好久不见，你还好吗 ~',
        background:'rgba(255,255,255,0)'
      })
      this.$get.findNovels(this.page.pageIndex, this.page.pageSize).then((res) => {
        loading.close();
        this.novels = res.result;
        this.page.totalSize = res.totalSize;
      }).catch(err=>{loading.close();});
    },
    handleCurrentChange(val) {
      console.log(val);
      this.page.pageIndex = val;
    },
    intoChapters(novel){
      this.$router.push({name:'Chapter',params:{novelId:novel.novelId}})
    }
  },
};
</script>