<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <main>
    <nav>
      
      <RouterLink active-class="active" to="/">Inicio</RouterLink>
      <RouterLink active-class="active" to="/coches">Coches</RouterLink>
       
    </nav>
    <RouterView />
  </main>
</template>

<style scoped>
.app-container {
    padding: 20px;
    background-color: #ffffff;
    border-radius: 8px;
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

.app-nav a:hover {
    background-color: #f1f1f1;
}

.active {
    font-weight: bold;
    color: red;
}
</style>