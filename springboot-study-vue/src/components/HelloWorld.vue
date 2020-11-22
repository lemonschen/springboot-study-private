<template>
  <div class="home-page" @click="clickPage">
    <el-image fit="contain" :src="backgroundImage" class="home-image" @touchend="touchendHandler"></el-image>
    <!-- <div class="home-ipc">
      <el-link @click="openIpcManageWebsite" class="refuse-select">{{ipc}}</el-link>
    </div> -->
    <cli-dialog v-model="cliDialogVisible"></cli-dialog>
  </div>
</template>

<script>
import backgroundImage from '@/assets/img/uninut.jpg'
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
      cliDialogVisible:false,
      ua: this.$store.getters.ua,
      theLastTouch:null,
      touchCount:0
    }
  },
  mounted(){
    document.onkeydown = (e) => this.handlerKeyDown(e);
    document.onkeyup = (e) => this.handlerKeyUp(e);
    this.$store.commit('token','token')
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
    },
    touchendHandler(e){
      if(this.theLastTouch === null){
        e.time = new Date();
        this.theLastTouch = e;
        this.touchCount = 1;
        console.log('第一次点击',this.theLastTouch,this.touchCount)
      }else {
        let oldTime = this.theLastTouch.time;
        let newDate = new Date();
        e.time = newDate;
        if(newDate.getTime() - oldTime.getTime() > 500){
          this.theLastTouch = e;
          this.touchCount = 1;
          console.log('超时重置',this.theLastTouch,this.touchCount)
        }else if(this.touchCount === 5){
          this.triggerHideFunction();
          this.theLastTouch = null;
          this.touchCount = 0;
          console.log('成功触发',this.theLastTouch,this.touchCount)
        }else {
          this.theLastTouch = e;
          this.touchCount ++;
          console.log('连续暴击',this.theLastTouch,this.touchCount)
        }
      }
    }
  }
}
</script>
