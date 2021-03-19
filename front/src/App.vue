<template>
  <div id="app" >
      <v-app-bar fixed dark class="app" id="app-nav">
  <v-toolbar  dark class='app-header'>
      <v-toolbar-title @click='$router.push("/")'>Barbershop name
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn depressed id="app-nav-btn" @click="position('app-nav')" to='/'>
        Главная
      </v-btn>
      <v-btn depressed id="app-nav-btn" @click="position('section-service')" to='/'>Услуги</v-btn>
      <v-btn depressed id="app-nav-btn" @click="position('section-map')" to='/'>Карта</v-btn>
      <v-btn depressed id="app-nav-btn" @click="position('section-shop')" to='/'>Магазин</v-btn>
      <v-btn depressed id="app-nav" to='/Private'>
        <v-icon>mdi-account</v-icon>
      </v-btn>
      <v-btn depressed id="app-nav" to='/Bag'>
        <v-icon>mdi-cart</v-icon>
      </v-btn>
  </v-toolbar>
  </v-app-bar>
  <router-view/>
  </div>
</template>
<script>

export default {
  name: 'App',
  methods: {
    position: function (el) {
      //scroll to element
      let elem = document.getElementById(el);
      let pos = elem.getBoundingClientRect();
      let heightNav = parseInt(window.getComputedStyle(document.getElementById('app-nav')).getPropertyValue('height'));
      
      if (!pos.y) {
        window.scrollTo(0,0);
      } else window.scrollTo( pos.x + pageXOffset, pos.y + pageYOffset - heightNav);

    }
  }

}
</script>
<style lang="scss">

.v-toolbar__title {
  width: 300px;
}

.app-nav {
  -webkit-justify-content: space-between;
  justify-content: flex-end;
  display: inline-flex;
}

@media all and (max-width: 800px) {
  .v-btn__content {font-size: 10px;}

}
@media only screen and (min-device-width : 320px) and (max-device-width : 568px) {
  #app-nav-btn {display: none;}

  .v-toolbar__title {width: 400px;}
}
.app-header, .app {
    width: 100%;
    opacity: 0.8;
  

}
</style>
