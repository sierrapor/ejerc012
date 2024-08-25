<script setup>
import { ref } from 'vue';

const message = ref('¡Bienvenido a la página de los coches!');

</script>

<template>
    <div>
        <h1>{{ message }}</h1>
    </div>
</template>

<style scoped>
.inicio-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.inicio-container h1 {
    font-size: 24px;
    color: #333;
}
</style>