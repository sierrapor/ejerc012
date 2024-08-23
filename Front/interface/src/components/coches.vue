<template>
    <div>
      <pre v-if="data">{{ data }}</pre>
      <p v-else>Cargando...</p>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import solicitudHttp from './httpService';
  
  const data = ref(null);
  
  const fetchData = async () => {
    try {
      const response = await solicitudHttp.get('/{id}');
      data.value = response.data;
    } catch (error) {
      console.error('Error realizando la solicitud:', error);
    }
  };
  
  onMounted(fetchData);
  </script>