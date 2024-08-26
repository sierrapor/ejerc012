<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const make = ref('');
const model = ref('');
const year = ref('');
const id = ref(null);

if (route.params.id) {
    id.value = route.params.id;
    axios.get(`/api/coches/${id.value}`).then(response => {
        make.value = response.data.make;
        model.value = response.data.model;
        year.value = response.data.year;
    });
}

const submitForm = async () => {
    const coche = {
        make: make.value,
        model: model.value,
        year: year.value
    };

    if (id.value) {
        await axios.put(`/api/coches/${id.value}`, coche);
    } else {
        await axios.post('/api/coches', coche);
    }

    router.push('/');
};

const cancel = () => {
    router.push('/coches');
};
</script>

<template>
    <div>
        <h1>{{ id ? 'Modificar Coche' : 'Crear Coche' }}</h1>
        <form @submit.prevent="submitForm">
            <div>
                <label for="make">Fabricante:</label>
                <input id="make" v-model="make" required />
            </div>
            <div>
                <label for="model">Modelo:</label>
                <input id="model" v-model="model" required />
            </div>
            <div>
                <label for="year">Año:</label>
                <input id="year" v-model="year" required type="number" />
            </div>
            <button type="submit">{{ id ? 'Modificar' : 'Crear' }}</button>
            <button type="button" @click="cancel">Cancelar</button>
        </form>
    </div>
</template>

<style scoped>
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
</style>