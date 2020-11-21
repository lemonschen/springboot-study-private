<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style lang="stylus">
#app
  width 100%
  height 100vh
.refuse-select
  -moz-user-select none
  -webkit-user-select none
  -ms-user-select none
  -khtml-user-select none
  -o-user-select none
  user-select none
</style>
