<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';;

const fabricantes = ref([]);
const router = useRouter();

onMounted(async () => {
    const response = await axios.get('/api/fabricantes');
    fabricantes.value = response.data;
});

const createFabricante = () => {
    router.push('/Fabricante-form');
};

const editabricante = (id) => {
    router.push(`/Fabricante-form/${id}`);
};

const deleteFabricante= async (id) => {
    await axios.delete(`/api/fabricantes/${id}`);
    const response = await axios.get('/api/fabricantes');
    fabricantes.value = response.data;
};
</script>

<template>
    <div>
        <button @click="createFabricante">Crear Coche</button>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Coches</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="fabricante in fabricantes" :key="fabricante.id">
                    <td>{{ fabricante.nombre }}</td>
                    <td>{{ fabricante.coches }}</td>
                    <td>
                        <button @click="editabricante(coche.id)">Editar</button>
                        <button @click="deleteFabricante(coche.id)">Eliminar</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <CocheForm v-if="false" /> <!-- Solo para verificar la importación -->
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