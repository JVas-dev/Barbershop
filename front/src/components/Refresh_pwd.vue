<template>
      <v-app >
        <v-main class='content'>
            <v-card color="rgba(0, 0, 0, 0.300)" dark width="400" id="registre-card"> 
                <v-card-title class="pb-0">
                    Восстановление пароля
                </v-card-title>
                <v-card-text>
                    <v-form>
                        <v-text-field
                        label="Введите почту или моб.телефон"
                        v-model="username"
                        prepend-icon="mdi-account-circle"
                        >
                        </v-text-field>
                    </v-form>
                </v-card-text>
                <v-card-actions>
                    <v-btn color="grey">Восстановить</v-btn>
                </v-card-actions>
            </v-card>
        </v-main>
      </v-app>
</template>

<script>
export default {

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