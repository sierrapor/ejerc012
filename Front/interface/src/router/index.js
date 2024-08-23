import { createRouter, createWebHistory } from 'vue-router';
import DataTable from '../components/DataTable.vue';
import DetailTable from '../components/DetailTable.vue';

const routes = [
  { path: '/data', name: 'data', component: DataTable },
  { path: '/details', name: 'details', component: DetailTable }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;