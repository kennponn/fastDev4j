import { createWebHistory, createRouter } from "vue-router";


const routes = [
  {
    path: "/",
    name: "login",
    component: () => import("@/views/login.vue"),
  },
//   {
//     path: "/about",
//     name: "About",
//     component: About,
//   },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;