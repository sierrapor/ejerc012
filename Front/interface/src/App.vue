<script setup>
import { RouterView, RouterLink } from 'vue-router';
</script>

<template>
  <main>
    <nav>
      <RouterLink active-class="active" to="/">Home</RouterLink>
      <RouterLink active-class="active" to="/about">About</RouterLink>
    </nav>
    <RouterView />
  </main>
</template>

