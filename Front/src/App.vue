<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <div class="app-container">
    <nav class="app-nav">
      <RouterLink active-class="active" to="/">Inicio</RouterLink>
      <RouterLink active-class="active" to="/coches">Coches</RouterLink>
      <RouterLink active-class="active" to="/fabricantes">Fabricantes</RouterLink>  
    </nav>
    <main>
      <RouterView />
    </main>
  </div>
</template>

<style scoped>
.app-container {
    padding: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.app-nav {
    display: flex;
    gap: 20px;
    margin-bottom: 20px;
}

.app-nav a {
    text-decoration: none;
    color: #333;
    padding: 8px 16px;
    border-radius: 4px;
    transition: background-color 0.3s;
}

.active {
    font-weight: bold;
    color: red;
}
</style>