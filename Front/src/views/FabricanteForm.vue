<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const nombre = ref('');
const coches = ref([]);
const id = ref(route.params.id ? Number(route.params.id) : null);

if (id.value) {
    axios.get(`/api/makes/${id.value}`).then(response => {
        nombre.value = response.data.nombre;
        coches.value = response.data.coches;
    }).catch(error => {
        console.error('Error fetching fabricante:', error);
    });
}

const submitForm = async () => {
    const fabricante = {
        nombre: nombre.value,
        coches: coches.value
    };
        if (id.value) {
            await axios.put(`/api/makes/${id.value}`, fabricante);
        } else {
            await axios.post('/api/makes', fabricante);
        }
        router.push('/fabricantes');
};

const cancel = () => {
    router.push('/fabricantes');
};
</script>

<template>
    <div class="main-container">
        <div class="form-container">
            <h1>{{ id ? 'Modificar Fabricante' : 'Agregar Fabricante' }}</h1>
            <form @submit.prevent="submitForm">
                <div>
                    <label for="nombre">Nombre:</label>
                    <input id="nombre" v-model="nombre" required />
                </div>
                <div>
                    <label for="coches">Coches:</label>
                    <input id="coches" v-model="coches" />
                </div>
                <button type="submit">{{ id ? 'Modificar' : 'Agregar' }}</button>
                <button type="button" @click="cancel">Cancelar</button>
            </form>
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

.form-container {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
    text-align: center;
    padding-bottom: 40vh;
}

div {
    margin-bottom: 1em;
}

label {
    display: block;
    margin-bottom: 0.5em;
}

input {
    width: 100%;
    padding: 0.5em;
    margin-bottom: 1em;
}

button {
    padding: 0.5em 1em;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

button[type="button"] {
    background-color: #6c757d;
    margin-left: 1em;
}

button[type="button"]:hover {
    background-color: #5a6268;
}

@media (max-width: 768px) {
    .main-container {
        width: 80vw;
        height: auto;
    }

    .form-container {
        padding: 15px;
        padding-bottom: 15vh;
    }

    input {
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

    .form-container {
        padding: 10px;
        padding-bottom: 10vh;
    }

    input {
        padding: 8px;
    }

    button {
        padding: 8px;
        font-size: 12px;
    }
}
</style>