<template>
  <div class="main-container">
      <div class="detalle-container">
          <h1>Detalles del Fabricante</h1>
          <div v-if="fabricante">
              <p><strong>Nombre:</strong> {{ fabricante.nombre }}</p>
              <p><strong>Coches:</strong> {{ fabricante.coches.length }}</p>
          </div>
          <button @click="volver">Volver</button>
      </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const router = useRouter();
const fabricante = ref(null);

onMounted(async () => {
  const response = await axios.get(`/api/makes/${route.params.id}`);
  fabricante.value = response.data;
});

const volver = () => {
  router.push('/fabricantes');
};
</script>
  
  <style scoped>
  body, html {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
  }
  
  .main-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 90vh;
    width: 60vw;
    box-sizing: border-box;
  }
  
  .detalle-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    text-align: center;
    padding-bottom: 45vh;
  }
  
  button {
    padding: 8px 16px;
    margin: 5px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  
  @media (max-width: 768px) {
    .main-container {
      width: 80vw;
      height: auto;
    }
  
    .detalle-container {
      padding: 15px;
      padding-bottom: 55vh;
    }
  
    button {
      padding: 10px;
      font-size: 14px;
    }
  }
  
  @media (max-width: 480px) {
    .main-container {
      width: 90vw;
      height: auto;
    }
  
    .detalle-container {
      padding: 10px;
      padding-bottom: 10vh;
    }
  
    button {
      padding: 8px;
      font-size: 12px;
    }
  }
  </style>