<template>
    <v-app >
    <v-main class='content'>
    <v-card color="rgba(0, 0, 0, 0.300)" dark width="400" id="registre-card">
      <v-card-title class="pb-0"> 
        <h1>Личный кабинет</h1>
      </v-card-title>
      <v-card-text>
        <v-form> 
          <v-text-field 
            label="Email или моб.телефон" 
            v-model="username"
            prepend-icon="mdi-account-circle"
          />
          <v-text-field 
            :type="password ? 'text' : 'password'" 
            label="Пароль"
            v-model="password"
            prepend-icon="mdi-lock"
            :append-icon="password ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="password = !password"
          />
        </v-form>
        <p v-show="badLogin" style="color: red" > Неверный email/телефон или пароль</p>
      </v-card-text>
      <v-card-text id="card-refresh-pwd">
          <router-link to="/Refresh">Забыли пароль?</router-link>
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-btn color="grey" to="/Registration">Регистрация</v-btn>
        <v-btn @click="login()"
        color="grey">Вход</v-btn>
      </v-card-actions>
    </v-card>
    </v-main>
    </v-app>
</template>

<script>
import axios from "axios";
import store from "@/store";
//import { use } from 'vue/types/umd';
export default {
   data: () => ({
     username: null,
     password: null,
     adr: null,
     badLogin: false
   }),
  

  methods: {
  login: function () {
    
    var params = new URLSearchParams();
     params.append('username', this.username);
     params.append('password', this.password);
  
    axios
      .post("http://localhost:8080/login",params, {
        withCredentials: true,
        auth:{
        username: this.username,
        password: this.password }})
    
      .then((response) => {
        this.adr = response.data;
        this.badLogin = false;
        store.user = this.username;
        this.$router.push("/Private");
      })
      .catch((error) => {
        if (error.response.status == 500) {
            this.badLogin = true;
        }
      })
  }
}
  }
</script>

<style>
.content {
    background: url(../assets/registre.jpg) no-repeat;
    -moz-background-size: cover; /* Firefox 3.6+ */
    -webkit-background-size: cover; /* Safari 3.1+ и Chrome 4.0+ */
    -o-background-size: cover; /* Opera 9.6+ */
    background-size: cover; /* Современные браузеры */
    height: 100vh;
}

#registre-card {
    top: 30%;
    left: 50%;
    transform: translate(-50%, -50%);
}

#card-refresh-pwd {
    padding: 0;
}

</style>