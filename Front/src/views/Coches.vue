<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const coches = ref([]);
const selectedCoche = ref(null);
const showModal = ref(false);

onMounted(async () => {
    const response = await axios.get('/api/coches');
    coches.value = response.data;
});

const openModal = (coche) => {
    selectedCoche.value = coche;
    showModal.value = true;
};

const closeModal = () => {
    showModal.value = false;
    selectedCoche.value = null;
};
</script>

<template>
    <div class="coches-container">
        <table class="coches-table">
            <thead>
                <tr>
                    <th>Fabricante</th>
                    <th>Modelo</th>
                    <th>Año</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="coche in coches" :key="coche.id">
                    <td>{{ coche.make }}</td>
                    <td>{{ coche.model }}</td>
                    <td>{{ coche.year }}</td>
                    <td><button @click="openModal(coche)">Ver Detalles</button></td>
                </tr>
            </tbody>
        </table>

        <div v-if="showModal" class="modal">
            <div class="modal-content">
                <span class="close" @click="closeModal">&times;</span>
                <h2>Detalles del Coche</h2>
                <p><strong>Fabricante:</strong> {{ selectedCoche.make }}</p>
                <p><strong>Modelo:</strong> {{ selectedCoche.model }}</p>
                <p><strong>Año:</strong> {{ selectedCoche.year }}</p>
            </div>
        </div>
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

button {
    padding: 8px 16px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

.modal {
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

.close {
    position: absolute;
    top: 10px;
    right: 10px;
    font-size: 24px;
    cursor: pointer;
}
</style>