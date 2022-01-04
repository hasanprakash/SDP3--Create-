<template>
  <div class="scrollDown" @click="scrollToDown">
    <font-awesome-icon icon="arrow-down" class="icons" />
  </div>
</template>

<script>
export default {
  data() {
    return {

    }
  },
  methods: {
    scrollToDown() {
      console.log("Scrolling");
      window.scrollTo(0,document.body.scrollHeight);
    }
  }
};
</script>

<style scoped>
  .scrollDown {
    position: fixed;
    right: 3%;
    bottom: 3%;
    font-size: 40px;
    border: 2px solid green;
    padding: 5px 10px;
    border-radius: 50%;
    background-color: white;
    cursor: pointer;
  }
  .scrollDown:hover {
    background-color: #ccc;
  }
</style>
