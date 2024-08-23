import express from 'express';
import cors from 'cors';

const app = express();

// Configuración básica de CORS
app.use(cors());

// Configuración avanzada de CORS (opcional)
const corsOptions = {
  origin: 'http://example.com', // Reemplaza con el origen permitido
  methods: 'GET,HEAD,PUT,PATCH,POST,DELETE',
  credentials: true,
  optionsSuccessStatus: 204
};

app.use(cors(corsOptions));

// Rutas y lógica de tu servidor
app.get('/', (req, res) => {
  res.send('Hello World!');
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});