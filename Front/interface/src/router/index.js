import { createRouter, createWebHistory } from 'vue-router';
import DataTable from '../components/DataTable.vue';
import DetailTable from '../components/DetailTable.vue';

const routes = [
  { path: '/', redirect: '/data' },
  { path: '/data', name: 'DataTable', component: DataTable },
  { path: '/details', name: 'DetailTable', component: DetailTable }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;