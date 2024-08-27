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

// TODO: Obtener lista de fabricantes y modelos del backend
const manufacturers = ref(['Toyota', 'Ford', 'Chevrolet', 'Honda', 'Nissan']);
const models = ref({
    'Toyota': ['Corolla', 'Camry', 'Prius'],
    'Ford': ['Fiesta', 'Focus', 'Mustang'],
    'Chevrolet': ['Spark', 'Malibu', 'Impala'],
    'Honda': ['Civic', 'Accord', 'Fit'],
    'Nissan': ['Versa', 'Sentra', 'Altima']
});
const filteredManufacturers = ref([]);
const filteredModels = ref([]);

const filterManufacturers = () => {
    const query = make.value.toLowerCase();
    filteredManufacturers.value = manufacturers.value.filter(manufacturer =>
        manufacturer.toLowerCase().includes(query)
    );
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

const selectManufacturer = (manufacturer) => {
    make.value = manufacturer;
    filteredManufacturers.value = [];
    filterModels(); // Actualizar la lista de modelos cuando se selecciona un fabricante
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
    if (id) {
        const response = await axios.get(`/api/coches/${id}`);
        const coche = response.data;
        make.value = coche.make;
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
                <input id="make" v-model="make" @input="filterManufacturers" list="manufacturers-list" required />
                <datalist id="manufacturers-list">
                    <option v-for="manufacturer in filteredManufacturers" :key="manufacturer" :value="manufacturer">
                        {{ manufacturer }}
                    </option>
                </datalist>
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