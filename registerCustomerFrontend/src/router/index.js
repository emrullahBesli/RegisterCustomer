import { createRouter, createWebHistory } from 'vue-router'
import RegisterCustomer from '../views/RegisterCustomer.vue'
import ViewCustomers from '../views/ViewCustomers.vue' // Yeni bileşeni import edin

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/register',
      name: 'Kullanıcı Ekleyin',
      component: RegisterCustomer
    },
    {
      path: '/view',
      name: 'Kullanıcıları Görüntüle', // Yeni route'un adı
      component: ViewCustomers // Yeni bileşen
    }
  ]
})

export default router
