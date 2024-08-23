import express from 'express';
import cors from 'cors';

const app = express();

// Configuración básica de CORS
app.use(cors());

// Datos de ejemplo de coches
const cars = [
  { id: 1, make: 'Toyota', model: 'Corolla', year: 2020 },
  { id: 2, make: 'Honda', model: 'Civic', year: 2019 },
  { id: 3, make: 'Ford', model: 'Focus', year: 2018 }
];

// Ruta para obtener datos de coches
app.get('/api/cars', (req, res) => {
  res.json(cars);
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});