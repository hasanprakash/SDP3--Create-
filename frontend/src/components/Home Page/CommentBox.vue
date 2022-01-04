<template>
  <!-- <div v-if="isCmtVisible" class="back"></div> -->
  <div class="container" v-if="modelValue">
    <base-navbar>
      <span @click="gotoInteract">expand</span>
      <span @click="updateModelValue" class="close">close</span>
    </base-navbar>
    Comment box here!
  </div>
</template>

<script>
export default {
  props: {
    modelValue: {
      required: true,
      type: Boolean,
    },
  },
  emits: ["update:modelValue"],
  data() {
    return {};
  },
  methods: {
    updateModelValue() {
      this.$emit("update:modelValue", false);
    },
    gotoInteract() {
      console.log("Going to interact");
      this.$router.push("/interact")
    }
  },
  mounted() {
    document.addEventListener("keydown", (event) => {
      if (event.key === "Escape") {
        this.updateModelValue();
      }
    });
  },
};
</script>

<style scoped>
.container {
  background-color: white;
  position: fixed;
  top: 0px;
  height: auto;
  width: 300px;
  right: 0px;
  border-left: 2px solid blue;
  border-top: 2px solid blue;
  border-bottom: 2px solid blue;
  /* display: flex;
  align-items: center; */
  top: 0%;
  bottom: 0%;
  box-shadow: 5px 0px 40px 0.5px;
  z-index: 100;
}
span {
  padding: 0 10px;
  cursor: pointer;
}
</style>
