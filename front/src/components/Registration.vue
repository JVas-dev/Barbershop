<template>
    <v-app >
    <v-main class='content'>
    <v-card color="rgba(0, 0, 0, 0.300)" dark width="400" id="registre-card">
      <v-card-title class="pb-0"> 
        <h1>Регистрация</h1>
      </v-card-title>
      <v-card-text>
        <v-form> 
            <v-text-field 
            label="Имя"
            v-model="first_name"
            prepend-icon="mdi-account-circle"
          />
          <v-text-field 
            label="Email" 
            v-model="username"
            prepend-icon="mdi-mail"
          />
          <v-text-field 
            label="Телефон"
            v-model="phone"
            prepend-icon="mdi-phone"
          />
          <v-text-field 
            label="Пароль"
            v-model="password"
            prepend-icon="mdi-lock"
          />
        </v-form>
      </v-card-text>
      <p v-show="exist" style="color: red" > Пользователь существует</p>
      <v-divider></v-divider>
      <v-card-actions >
        <v-btn color="grey" @click="registration()">Регистрация</v-btn>
      </v-card-actions>
    </v-card>
    </v-main>
    </v-app>
</template>
<script>
import axios from "axios";
import store from "@/store";
export default {
    data: () => ({
        first_name: null,
        username: null,
        phone: null,
        password: null,
        exist: false
    }),
    methods: {
        registration: function () {
            var params = new URLSearchParams();
     params.append('username', this.username);
     params.append('password', this.password);
     params.append('firstName', this.first_name);
     params.append('phone', this.phone);
  
    axios
      .post("http://localhost:8080/registration",params)
      .then((response) => {
          let data = response.data;
          if (data){
            store.user = this.username;
            this.$router.push("/");
          } else {
            this.exist = true;
          }
      })
      .catch((error) => {
          console.log(error.response.status);
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