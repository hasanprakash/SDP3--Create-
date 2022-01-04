<template>
  <div class="background" @click="closeImage"></div>
  <div class="close" @click="closeImage">
    <font-awesome-icon icon="times" class="icons" />
  </div>
  <div class="pop-up-image">
    <span class="helper"><img :src="src" /></span>
  </div>
</template>

<script>
export default {
  inject: ['data'],
  props: ["imageId"],
  data() {
    return {
      src: "",
    };
  },
  watch: {
    imageId(newId) {
      this.loadData(newId);
    },
  },
  methods: {
    closeImage() {
      this.$router.push("/home");
    },
    loadData(imageId) {
      var val = this.data.filter((data) => {
        return data.imageName === imageId
      });
      console.log(val);
      this.src = val[0].imageUrl;
    },
  },
  mounted() {
    const image = document.querySelector("img");
    if (image.height > window.innerHeight) image.height = window.innerHeight;
    var that = this;
    document.addEventListener("keydown", function (event) {
      if (event.key === "Escape") {
        that.closeImage();
      }
    });
  },
  created() {
      this.loadData(this.imageId);
  }
};
</script>

<style scoped>
.pop-up-image {
  width: 100%;
  height: 100%;
  position: fixed;
  z-index: 100;
  top: 0%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.helper {
  display: flex;
  justify-content: center;
  align-items: center;

  max-width: 100%;
  max-height: 100%;
  width: 100%;
  height: 100%;
}
img {
  height: auto;
  max-height: 100%;
  max-width: 100%;
  border-radius: 15px;
}
.background {
  position: fixed;
  top: 0%;
  left: 0%;
  background-color: black;
  opacity: 0.6;
  width: 100%;
  height: 100%;
  z-index: 80;
  /* backdrop-filter: blur(4px); */
}
.close {
  z-index: 200;
  position: fixed;
  left: 25px;
  top: 25px;
  font-size: 50px;
  cursor: pointer;
  padding: 0;
  margin: 0;
  color: white;
}
</style>
