<template>
  <div>
    <h1>Data Table</h1>
    <table>
      <thead>
        <tr>
          <th>Select</th>
          <th>ID</th>
          <th>Make</th>
          <th>Model</th>
          <th>Year</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="car in cars" :key="car.id">
          <td><input type="checkbox" v-model="selectedCars" :value="car" /></td>
          <td>{{ car.id }}</td>
          <td>{{ car.make }}</td>
          <td>{{ car.model }}</td>
          <td>{{ car.year }}</td>
        </tr>
      </tbody>
    </table>
    <button @click="updateSelectedCars">Actualizar autos seleccionados</button>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const cars = ref([]);
const selectedCars = ref([]);
const router = useRouter();

onMounted(async () => {
  const response = await fetch('http://localhost:8080/coches');
  cars.value = await response.json();
});

const updateSelectedCars = () => {
  router.push({ name: 'details', query: { selectedCars: JSON.stringify(selectedCars.value) } });
};
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

th {
  background-color: #f2f2f2;
}
</style>