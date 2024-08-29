<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
import CocheForm from './CocheForm.vue';

const coches = ref([]);
const router = useRouter();

onMounted(async () => {
    const response = await axios.get('/api/coches');
    coches.value = response.data;
});

const addCoche = () => {
    router.push('/coche-form');
};

const editCoche = (id) => {
    router.push(`/coche-form/${id}`);
};

const deleteCoche = async (id) => {
    await axios.delete(`/api/coches/${id}`);
    const response = await axios.get('/api/coches');
    coches.value = response.data;
};
</script>

<template>
    <div class="main-container">
      <div class="coches-container">
        <button @click="addCoche">Agregar Coche</button>
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
                <img src="@/assets/editar.png" @click="editCoche(coche.id)" class="imagen" alt="Editar" />
                <img src="@/assets/eliminar.jpg" @click="deleteCoche(coche.id)" class="imagen" alt="Eliminar" />
                <router-link :to="{ name: 'CocheDetalle', params: { id: coche.id } }">
                    <img src="@/assets/detalles.png" class="imagen" alt="Ver Detalles" />
                </router-link>
              </td>
            </tr>
          </tbody>
        </table>
        <CocheForm v-if="false" /> <!-- Solo para verificar la importación -->
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

.coches-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    text-align: center;
    padding-bottom: 45vh;
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

    .coches-container {
        padding: 15px;
        padding-bottom: 55vh;
    }

    .coches-table th, .coches-table td {
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

    .coches-container {
        padding: 10px;
        padding-bottom: 10vh;
    }

    .coches-table th, .coches-table td {
        padding: 8px;
    }

    button {
        padding: 8px;
        font-size: 12px;
    }
}
</style>