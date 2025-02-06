import { createApp } from 'vue';
import App from './App.vue';
import vuetify from './plugins/vuetify';
import { createRouter, createWebHistory } from 'vue-router';
import InternshipMainDashboard from "@/components/InternshipMainDashboard.vue";
import ApiTest from "@/components/ApiTest.vue";

const app = createApp(App);

const routes = [
    {
        path: '/',
        component: InternshipMainDashboard
    },
    {
        path: '/test',
        component: ApiTest
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
    linkActiveClass: 'active',
});

app.use(vuetify);
app.use(router);
app.mount('#app');
