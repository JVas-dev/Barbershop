<template >
  <v-app row>
    <v-main class="section-home" dark>
      <img />
      <v-flex class="section-home-text">
        <p>Цитата Великих людей</p>
        <v-btn class="section-home-sign-up">Записаться</v-btn>
      </v-flex>
    </v-main>
    <v-main class="section-service" id="section-service">
      <v-flex class="section-service-header">
        <p id="v-text-title">УСЛУГИ</p>
      </v-flex>
      <v-list-group
        v-for="(item,i) in serv"
        :key="i"
        v-model="item.active"
        no-action
        color="rgba(173, 15, 15, 0.87)"
        class="section-service-list"
      >
        <template v-slot:activator>
          <v-list-item-content>
            <v-list-item-title v-text="i"></v-list-item-title>
          </v-list-item-content>
        </template>
        <v-list-item v-for="(subitem, idx) in item" :key="idx">
          <v-list-item-content>
            <v-list-item-title v-text="subitem.service"></v-list-item-title>
          </v-list-item-content>
          <v-list-item-content>
            <v-list-item-title v-text="subitem.price"></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-group>
    </v-main>
    <v-main class="section-map" id="section-map" dark>
      <v-flex class="section-map-header">
        <p>КАРТА</p>
      </v-flex>
      <v-container id="section-map-container">
        <v-layout class="d-flex flex-wrap">
          <v-flex class="section-map-adress">
            <v-list-group v-for="(item,i) in adr" :key="i" color="rgba(173, 15, 15, 0.87)">
              <template v-slot:activator>
                <v-list-item-icon>
                  <v-icon id="section-map-adress-icon">mdi-subway</v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title v-text="item.underground"></v-list-item-title>
                </v-list-item-content>
              </template>
              <v-list-item-content class="section-map-adress-item">
                <v-list-item-title v-text="item.underground"></v-list-item-title>
                <v-list-item-title v-text="item.street"></v-list-item-title>
                <v-list-item-title v-text="item.phone"></v-list-item-title>
              </v-list-item-content>
            </v-list-group>
          </v-flex>
          <v-flex class="section-map-yandex">
            <div style="position:relative;overflow:hidden;border-width: 5px;">
              <a
                href="https://yandex.ru/maps/213/moscow/?utm_medium=mapframe&utm_source=maps"
                style="color:#eee;font-size:12px;position:absolute;top:0px;"
              >Москва</a>
              <a
                href="https://yandex.ru/maps/213/moscow/house/novgorodskaya_ulitsa_37/Z04YcwBoTEEGQFtvfXVxdHhqZg==/?ll=37.578540%2C55.905492&utm_medium=mapframe&utm_source=maps&z=16.87"
                style="color:#eee;font-size:12px;position:absolute;top:14px;"
              >Новгородская улица, 37 — Яндекс.Карты</a>
              <iframe
                src="https://yandex.ru/map-widget/v1/-/CCQle6sdKB"
                width="100%"
                height="300"
                frameborder="1"
                allowfullscreen="true"
                style="position:relative; 	filter: brightness(60%);"
              ></iframe>
            </div>
          </v-flex>
        </v-layout>
      </v-container>
    </v-main>
    <v-main class="section-shop" id="section-shop">
      <v-flex class="section-shop-header">
        <p>Магазин</p>
      </v-flex>
      <v-container id="section-shop-container" style="height: 800px; overflow: scroll">
        <v-row>
          <v-col style="display: flex; width: 200px; " v-for="n in 12" :key="n" cols="12" md="4">
            <v-card dark>
              <v-img
                src="https://kerastase.ru/media/catalog/product/cache/45426b8adb9b5eb97858c7f419958be7/k/e/kerastase-densifique-homme-men-thinning-hair-bain-1000x1000.png"
              ></v-img>
              <v-card-text>Shampoo</v-card-text>
              <v-btn>Купить</v-btn>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    adr: null,
    serv: null,
  }),
  mounted: function adr() {
    axios
      .post("http://localhost:8080/adress")
      .then((response) => {
        this.adr = response.data;
      })
      .catch((error) => console.log(error));
    axios
      .post("http://localhost:8080/service")
      .then((response) => {
        this.serv = response.data;
      })
      .catch((error) => console.log(error));
  },
  function() {
    let el = document.getElementById("img-rusty-nail");
    let isScrolling = false;

    window.addEventListener("scroll", throttleScroll, false);

    function throttleScroll(e) {
      if (isScrolling == false) {
        window.requestAnimationFrame(function () {
          scrolling(e);
          isScrolling = false;
        });
      }
      isScrolling = true;
    }
    function scrolling() {
      if (isPartiallyVisible()) {
        el.classList.add("active");
      } 
    }

    function isPartiallyVisible() {
      let elementBoundary = el.getBoundingClientRect();
      let top = elementBoundary.top;
      let bottom = elementBoundary.bottom;
      return top >= 0 && bottom <= window.innerHeight;
    }
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.section-home {
  background: linear-gradient(
      to bottom,
      rgba(0, 0, 0, 0.377),
      rgba(0, 0, 0, 0.986)
    ),
    url(../assets/interior.jpg);
  -moz-background-size: cover; /* Firefox 3.6+ */
  -webkit-background-size: cover; /* Safari 3.1+ и Chrome 4.0+ */
  -o-background-size: cover; /* Opera 9.6+ */
  background-size: cover; /* Современные браузеры */
  height: 100vh;
  position: relative;
}
.section-home-text {
  top: 50%;
  left: 50%;
  position: absolute;
  margin-right: -50%;
  transform: translate(-50%, -50%);
}
.section-home-text p {
  color: rgba(255, 255, 255, 0.753);
  font-style: oblique;
}
.section-home-sign-up {
  margin-top: 30%;
  top: 50%;
  left: 50%;
  margin-right: -50%;
  transform: translate(-50%, -50%);
}
.section-service {
  background: linear-gradient(
      to bottom,
      rgba(0, 0, 0, 0.973),
      rgba(0, 0, 0, 0.897)
    ),
    url(../assets/map-canvas.jpg);

  -moz-background-size: cover;
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  height: 100vh;
}

.section-service-header,
.section-map-header,
.section-shop-header {
  text-align: center;
  color: rgba(255, 255, 255, 0.753);
  font-size: 300%;
  padding-top: 2%;
  font-family: "Courier New", Courier, monospace;
  font-weight: bolder;
}

.v-list-item__title {
  color: rgba(255, 255, 255, 0.753);
}

.mdi-chevron-down::before {
  color: rgba(255, 255, 255, 0.753);
}
/*
#img-rusty-nail.disactive {
  background: url(../assets/rusty-nail.png) no-repeat;

  transition:  all 3s  2s;
  background-position: center;
  padding-top: 150px;

}
#img-rusty-nail.active {
  background: url(../assets/image.png) no-repeat;
  background-position: center; 
  padding-top: 150px;
}
*/

.section-map {
  background: linear-gradient(
      to top,
      rgba(0, 0, 0, 0.829),
      rgba(0, 0, 0, 0.932)
    ),
    url(../assets/service-devases.jpg) no-repeat;
  -moz-background-size: cover; /* Firefox 3.6+ */
  -webkit-background-size: cover; /* Safari 3.1+ и Chrome 4.0+ */
  -o-background-size: cover; /* Opera 9.6+ */
  background-size: cover; /* Современные браузеры */
  height: 100vh;
}

.section-map-adress {
  color: rgba(255, 255, 255, 0.753);
}

#section-map-adress-icon {
  color: rgba(255, 255, 255, 0.753);
}

.section-shop {
  background: linear-gradient(
    to top,
    rgba(0, 0, 0, 0.884),
    rgba(0, 0, 0, 0.966)
  );
  height: 100vh;
}
</style>
