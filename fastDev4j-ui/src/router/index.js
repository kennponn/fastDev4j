import { createWebHistory, createRouter } from "vue-router";


const routes = [
  {
    path: "/",
    name: "login",
    component: () => import("@/views/login.vue"),
  },
  {
    path: "/login",
    redirect: '/'
  },
  {
    path: "/home",
    name: "home",
    component: () => import("@/views/system/home.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;