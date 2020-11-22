<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import '@/assets/css/pc.styl'
export default {
  name: "App",
  created() {
    this.getUserAgent();
  },
  methods: {
    getUserAgent() {
      let flag = navigator.userAgent.match(
        /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
      );
      this.$store.commit("ua", flag ? "mobile" : "pc");
    },
  },
};
</script>
