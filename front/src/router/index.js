import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home.vue'
import Private from '../components/Private.vue'
import Login from '../components/Login.vue'
import Refresh_pwd from '../components/Refresh_pwd.vue'
import Bag from '../components/Bag.vue'
import Registration from '../components/Registration.vue'
import store from '../store'


Vue.use(Router)

//const isAuthenticated =()=> false;
const router = new Router({

  
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Refresh',
      name: 'Refresh',
      component: Refresh_pwd
    },
    {
      path: '/Bag',
      name: 'Bag',
      component: Bag
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/Private',
      name: 'Private',
      component: Private,
      meta: {requiresAuth: true}
    },
    {
      path: '/Registration',
      name: 'Registration',
      component: Registration
    }
  ]
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    if(!store.user) {
      next({
        name: "Login"
      })
    } else {
      next();
    }
  }else next();
})

export default router;
