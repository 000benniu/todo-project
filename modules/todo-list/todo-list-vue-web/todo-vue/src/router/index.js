import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoList from "../components/TodoList";

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'todolist',
        component: TodoList
    }
];

const router = new VueRouter({
    routes
});

export default router
