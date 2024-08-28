import { createRouter, createWebHistory } from "vue-router";
import Inicio from "../views/Inicio.vue";
import Coches from "../views/Coches.vue";
import Fabricantes from "../views/Fabricantes.vue";
import CocheForm from '../views/CocheForm.vue';
import FabricanteForm from '../views/FabricanteForm.vue';


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
    name: 'AgregarCoche',
    component: CocheForm
},
{
    path: '/coche-form/:id',
    name: 'EditarCoche',
    component: CocheForm
},
{
  path: "/fabricantes",
  name: "Fabricantes",
  component: Fabricantes,
},
{
  path: '/fabricante-form',
  name: 'AgregarFabricante',
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