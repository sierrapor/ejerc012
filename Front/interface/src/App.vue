<template>
  <div id="app">
    <router-link to="/data">Data Table</router-link>
    <router-link to="/details">Detail Table</router-link>
    <router-view></router-view>
  </div>
</template>

<script setup>
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

router-link {
  margin: 0 10px;
  text-decoration: none;
  color: #42b983;
}

router-link-active {
  font-weight: bold;
}
</style>