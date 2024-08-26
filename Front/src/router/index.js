import { createRouter, createWebHistory } from "vue-router";
import Inicio from "../views/Inicio.vue";
import Coches from "../views/Coches.vue";

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
];
const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;