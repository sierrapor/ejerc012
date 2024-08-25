import express from 'express';
import cors from 'cors';

const app = express();

// Configuración básica de CORS
app.use(cors());

// Ruta para obtener datos de coches
app.get('/api/coches', (req, res) => {
  res.json(cars);
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});