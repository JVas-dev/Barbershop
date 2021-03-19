<template>
  <v-app>
      <v-main class='content'>
          <v-card color="rgba(0, 0, 0, 0.300)" dark width="400" id="registre-card">
              <v-card-title class="pb-0"> 
                <h1>Личный кабинет</h1>
              </v-card-title>
              <v-card-text>Привет {{user}}</v-card-text>
              <v-btn color="grey" @click="logOut()">Выход</v-btn>
          </v-card>
      </v-main>
  </v-app>
</template>

<script>
import store from "@/store";

export default {
  data: () => ({
     user: store.user
  }),
  methods: {
    logOut() {
      store.user = null;
      this.$router.push("/")
    }
  },
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

</style>