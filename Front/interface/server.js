import express from 'express';
import cors from 'cors';

const app = express();

// Configuración básica de CORS
app.use(cors());

// Datos de ejemplo
const data = [
  { id: 1, name: 'Item 1', detail: 'Detail 1' },
  { id: 2, name: 'Item 2', detail: 'Detail 2' },
  { id: 3, name: 'Item 3', detail: 'Detail 3' }
];

// Ruta para obtener datos
app.get('/api/data', (req, res) => {
  res.json(data);
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});