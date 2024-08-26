import { createRouter, createWebHistory } from "vue-router";
import Inicio from "../views/Inicio.vue";
import Coches from "../views/Coches.vue";
import CocheForm from '../views/CocheForm.vue';


const routes = [
  {
    path: "/",
    name: "Inicio",
    component: Inicio,
  },
  {
      path: "/coches",
      name: "Coches",
      component: Coches,
  },
  {
    path: '/coche-form',
    name: 'CrearCoche',
    component: CocheForm
},
{
    path: '/coche-form/:id',
    name: 'EditarCoche',
    component: CocheForm
}
];
const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;