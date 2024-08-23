import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import DataTable from '../components/DataTable.vue';
import DetailTable from '../components/DetailTable.vue';

const routes = [
  {
    path: '/home',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'About',
    component: AboutView
  },
  { path: '/', redirect: '/data' },
  { path: '/data', name: 'DataTable', component: DataTable },
  { path: '/details', name: 'DetailTable', component: DetailTable }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;