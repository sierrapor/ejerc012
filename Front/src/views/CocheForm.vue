<script setup>
import { ref, watch, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const router = useRouter();

const id = route.params.id ? Number(route.params.id) : null;

const make = ref('');
const model = ref('');
const year = ref('');

const manufacturers = ref([]);
const filteredModels = ref([]);

const fetchManufacturers = async () => {
    try {
        const response = await axios.get('/api/makes/names');
        manufacturers.value = response.data;
    } catch (error) {
        console.error('Error fetching manufacturers:', error);
    }
};

const filterModels = () => {
    const selectedMake = make.value;
    if (models.value[selectedMake]) {
        const query = model.value.toLowerCase();
        filteredModels.value = models.value[selectedMake].filter(model =>
            model.toLowerCase().includes(query)
        );
    } else {
        filteredModels.value = [];
    }
};

const submitForm = async () => {
    const coche = { make: make.value, model: model.value, year: year.value };
    if (id) {
        await axios.put(`/api/coches/${id}`, coche);
    } else {
        await axios.post('/api/coches', coche);
    }
    router.push('/coches');
};

const cancel = () => {
    router.push('/coches');
};

// Watch for changes in make to filter models accordingly
watch(make, filterModels);

// Load coche data if editing
onMounted(async () => {
    await fetchManufacturers();
    if (id) {
        const response = await axios.get(`/api/coches/${id}`);
        const coche = response.data;
        make.value = manufacturers.value;
        model.value = coche.model;
        year.value = coche.year;
    }
});
</script>

<template>
    <div>
        <h1>{{ id ? 'Modificar ' + make + ' ' + model : 'Crear Coche' }}</h1>
        <form @submit.prevent="submitForm">
            <div>
                <label for="make">Fabricante:</label>
                <select id="make" v-model="make" required>
                    <option v-for="manufacturer in manufacturers" :key="manufacturer" :value="manufacturer">
                        {{ manufacturer }}
                    </option>
                </select>
            </div>
            <div>
                <label for="model">Modelo:</label>
                <input id="model" v-model="model" @input="filterModels" list="models-list" required />
                <datalist id="models-list">
                    <option v-for="model in filteredModels" :key="model" :value="model">
                        {{ model }}
                    </option>
                </datalist>
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

input, select {
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

    input, select {
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

    input, select {
        padding: 8px;
    }

    button {
        padding: 8px;
        font-size: 12px;
    }
}
</style>