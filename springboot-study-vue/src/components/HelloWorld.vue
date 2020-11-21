<template>
  <div class="s-page" :style="{backgroundImage:'url('+backgroundImage+')'}" @click="clickPage">
    <div class="s-ipc">
      <el-link type="primary" @click="openIpcManageWebsite" class="refuse-select">{{ipc}}</el-link>
    </div>
    <cli-dialog v-model="cliDialogVisible"></cli-dialog>
  </div>
</template>

<script>
import backgroundImage from '@/assets/uninut.jpg'
import CliDialog from './dialog/CliDialog.vue';
export default {
  components: { CliDialog },
  name: 'HelloWorld',
  data () {
    return {
      backgroundImage:backgroundImage,
      response:'',
      ipc:'黔ICP备19010140号',
      ipcManageWebsite:'http://beian.miit.gov.cn',
      keyDown:{
        ctrl:false,
        c:false,
        z:false,
        y:false,
        trigger:false
      },
      cliDialogVisible:false
    }
  },
  mounted(){
    document.onkeydown = (e) => this.handlerKeyDown(e);
    document.onkeyup = (e) => this.handlerKeyUp(e);
  },
  computed:{
    keyCode(){
      let {ctrl,c,z,y} = this.keyDown;
      return {ctrl,c,z,y}
    }
  },
  watch:{
    keyCode({ctrl,c,z,y}){
      if(ctrl && c && z && y && !this.keyDown.trigger){
        this.keyDown.trigger = true;
        this.triggerHideFunction();
      }
    },
    cliDialogVisible(val){
      console.log('cliDialogVisible',val)
    }
  },
  methods:{
    requestService(){
      this.$get.findNovels(0,100)
      .then(res=>{
        this.response = res;
      })
      .catch(err=>{
        this.response = err;
      })
    },
    openIpcManageWebsite(){
      window.open(this.ipcManageWebsite)
    },
    clickPage(){
      console.log('clickPage')
    },
    handlerKeyDown(e){
      let e1 = e || event || window.event || arguments.callee.caller.arguments[0];
      if(e1.ctrlKey && !this.keyDown.ctrl)this.keyDown.ctrl = true;
      if(e1.keyCode === 67)this.keyDown.c = true;
      if(e1.keyCode === 89)this.keyDown.y = true;
      if(e1.keyCode === 90)this.keyDown.z = true;
    },
    handlerKeyUp(e){
      let e1 = e || event || window.event || arguments.callee.caller.arguments[0];
      Object.assign(this.keyDown,{
        ctrl:false,
        c:false,
        z:false,
        y:false
      })
    },
    triggerHideFunction(){
      this.keyDown.trigger = false;
      this.$notify.success('你好，孟林C');
      this.cliDialogVisible = true;
    }
  }
}
</script>

<style lang="stylus" scoped>
.s-page
  width 100%
  height 100vh
  background-repeat no-repeat
  background-size contain
  background-position center
  position relative
  .s-ipc
    position absolute
    bottom 1vh
    width 100%
    text-align center
</style>
