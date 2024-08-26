<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const coches = ref([]);
const selectedCoche = ref(null);
const showModal = ref(false);
const isEditing = ref(false);
const newCoche = ref({
    make: '',
    model: '',
    year: ''
});

onMounted(async () => {
    const response = await axios.get('/api/coches');
    coches.value = response.data;
});

const openModal = (coche = null) => {
    if (coche) {
        selectedCoche.value = { ...coche };
        isEditing.value = true;
    } else {
        selectedCoche.value = null;
        isEditing.value = false;
    }
    showModal.value = true;
};

const closeModal = () => {
    showModal.value = false;
    selectedCoche.value = null;
    isEditing.value = false;
};

const saveCoche = async () => {
    if (isEditing.value) {
        await axios.put(`/api/coches/${selectedCoche.value.id}`, selectedCoche.value);
        const index = coches.value.findIndex(c => c.id === selectedCoche.value.id);
        if (index !== -1) {
            coches.value.splice(index, 1, selectedCoche.value);
        }
    } else {
        const response = await axios.post('/api/coches', newCoche.value);
        coches.value.push(response.data);
        newCoche.value = { make: '', model: '', year: '' };
    }
    closeModal();
};

const deleteCoche = async (coche) => {
    await axios.delete(`/api/coches/${coche.id}`);
    coches.value = coches.value.filter(c => c.id !== coche.id);
};
</script>

<template>
    <div class="coches-container">
        <button @click="openModal">Agregar Coche</button>
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
                    <td>
                        <button @click="openModal(coche)">Ver Detalles</button>
                        <button @click="openModal(coche)">Editar</button>
                        <button @click="deleteCoche(coche)">Eliminar</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <div v-if="showModal" class="modal">
            <div class="modal-content">
                <span class="close" @click="closeModal">&times;</span>
                <h2>{{ isEditing ? 'Editar Coche' : 'Agregar Coche' }}</h2>
                <form @submit.prevent="saveCoche">
                    <p>
                        <label>Fabricante:</label>
                        <input :value="isEditing ? selectedCoche.make : newCoche.make" @input="isEditing ? selectedCoche.make = $event.target.value : newCoche.make = $event.target.value" required>
                    </p>
                    <p>
                        <label>Modelo:</label>
                        <input :value="isEditing ? selectedCoche.model : newCoche.model" @input="isEditing ? selectedCoche.model = $event.target.value : newCoche.model = $event.target.value" required>
                    </p>
                    <p>
                        <label>Año:</label>
                        <input :value="isEditing ? selectedCoche.year : newCoche.year" @input="isEditing ? selectedCoche.year = $event.target.value : newCoche.year = $event.target.value" required>
                    </p>
                    <button type="submit">{{ isEditing ? 'Guardar Cambios' : 'Agregar' }}</button>
                    <button type="button" @click="closeModal">Cancelar</button>
                </form>
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
    position: relative;
}

.close {
    position: absolute;
    top: 10px;
    right: 10px;
    font-size: 24px;
    cursor: pointer;
}
</style>