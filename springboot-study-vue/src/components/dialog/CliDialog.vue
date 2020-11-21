<template>
  <el-dialog
    :visible.sync="innerVisible"
    append-to-body
    destroy-on-close
    v-dialog-drag
    :show-close="false"
    title="THE UNIVERSE IN A NUTSHELL"
    center
    top="40vh"
    @close="close"
  >
    <el-input v-model="inputValue" @change="listenValue" placeholder="hi 别来无恙~"></el-input>
  </el-dialog>
</template>
<script>
export default {
  name: "cli-dialog",
  model: {
    prop: "visible",
    event: "close",
  },
  props: {
    visible: Boolean,
  },
  data() {
    return {
      innerVisible: this.visible,
      inputValue:''
    };
  },
  watch: {
    visible(val) {
      this.innerVisible = val;
    },
  },
  methods: {
    close() {
      this.$emit("close", false);
    },
    listenValue(val){
        if(val === '小说'){
            this.$notify({
                message:'hi 好久不见，你还好吗~',
                showClose:false,
                duration:4000,
                offset: 20
            })
        }
    }
  },
};
</script>
<style lang="stylus" scoped>
</style>