<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
import FabricanteForm from './FabricanteForm.vue';

const coches = ref([]);
const router = useRouter();

onMounted(async () => {
    const response = await axios.get('/api/fabricantes');
    coches.value = response.data;
});

const addFabricante = () => {
    router.push('/fabricante-form');
};

const editFabricante = (id) => {
    router.push(`/fabricante-form/${id}`);
};

const deleteFabricante = async (id) => {
    await axios.delete(`/api/fabricantes/${id}`);
    const response = await axios.get('/api/fabricantes');
    coches.value = response.data;
};
</script>

<template>
    <div class="main-container">
        <div class="fabricantes-container">
            <button @click="addFabricante">Agregar Fabricante</button>
            <table class="fabricantes-table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Coches</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="coche in coches" :key="coche.id">
                        <td>{{ coche.make }}</td>
                        <td>{{ coche.model }}</td>
                        <td>
                            <img src="@/assets/editar.png" @click="editFabricante(coche.id)" class="imagen" alt="Editar" />
                            <img src="@/assets/eliminar.jpg" @click="deleteFabricante(coche.id)" class="imagen" alt="Eliminar" />
                            <router-link :to="{ name: 'FabricanteDetalle', params: { id: coche.id } }">
                                <img src="@/assets/detalles.png" class="imagen" alt="Ver Detalles" />
                            </router-link>
                        </td>
                    </tr>
                </tbody>
            </table>
            <FabricanteForm v-if="false" /> <!-- Solo para verificar la importación -->
        </div>
    </div>
</template>

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

.fabricantes-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    text-align: center;
    padding-bottom: 45vh;
}

.fabricantes-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.fabricantes-table th, .fabricantes-table td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

.fabricantes-table th {
    background-color: #f2f2f2;
    font-weight: bold;
}

.fabricantes-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.fabricantes-table tr:hover {
    background-color: #f1f1f1;
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

.imagen {
    width: 26px;
    height: 26px;
    cursor: pointer;
    margin: 5px;
}

.imagen:hover {
    opacity: 0.7;
}

@media (max-width: 768px) {
    .main-container {
        width: 80vw;
        height: auto;
    }

    .fabricantes-container {
        padding: 15px;
        padding-bottom: 55vh;
    }

    .fabricantes-table th, .fabricantes-table td {
        padding: 10px;
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

    .fabricantes-container {
        padding: 10px;
        padding-bottom: 10vh;
    }

    .fabricantes-table th, .fabricantes-table td {
        padding: 8px;
    }

    button {
        padding: 8px;
        font-size: 12px;
    }
}
</style>