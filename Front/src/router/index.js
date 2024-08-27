import { createRouter, createWebHistory } from "vue-router";
import Inicio from "../views/Inicio.vue";
import Coches from "../views/Coches.vue";
import CocheForm from '../views/CocheForm.vue';
import Fabriantes from "@/views/Fabriantes.vue";
import FabricanteForm from "@/views/FabricanteForm.vue";


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
},
{
    path: '/fabricantes',
    name: 'Fabricantes',
    component: Fabriantes
},
{
    path: '/fabricante-form',
    name: 'CrearFabricante',
    component: FabricanteForm
},
{
    path: '/fabricante-form/:id',
    name: 'EditarFabricante',
    component: FabricanteForm
}
];
const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;