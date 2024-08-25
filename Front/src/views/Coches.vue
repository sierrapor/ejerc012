<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const coches = ref([]);

onMounted(async () => {
    const response = await axios.get('/api/coches');
    coches.value = response.data;
});
</script>

<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>Fabricante</th>
                    <th>Modelo</th>
                    <th>Año</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="coche in coches" :key="coche.id">
                    <td>{{ coche.make }}</td>
                    <td>{{ coche.model }}</td>
                    <td>{{ coche.year }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
.coches-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.coches-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.coches-table th, .coches-table td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

.coches-table th {
    background-color: #f2f2f2;
    font-weight: bold;
}

.coches-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.coches-table tr:hover {
    background-color: #f1f1f1;
}
</style>