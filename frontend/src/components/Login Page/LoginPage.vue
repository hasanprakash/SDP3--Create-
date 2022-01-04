<template>
  <div id="background"></div>
  <font-awesome-icon
    @click="gotoHome"
    icon="times-circle"
    class="icons close"
  />
  <div class="container">
    <router-view @show-dialog="showDialog"></router-view>
  </div>

  <base-dialog v-if="isInputInvalid" @okay="confirmError">
    <template #default>{{ dialogErrorName }}</template>
    <template #matter>{{ dialogErrorDescription }}</template>
    <template #action><button @click="confirmError">{{ dialogErrorAction }}</button></template>
  </base-dialog>
</template>

<script>
export default {
  data() {
    return {
      dialogErrorName: "",
      dialogErrorDescription: "",
      dialogErrorAction: "",
      isInputInvalid: false,
    };
  },
  methods: {
    gotoHome() {
      this.$router.push("/home");
    },
    showDialog(errorName, errorMatter, errorAction) {
      this.dialogErrorName = errorName;
      this.dialogErrorDescription = errorMatter;
      this.dialogErrorAction = errorAction;
      this.isInputInvalid = true;
    },
    confirmError() {
      this.isInputInvalid = false;
    }
  },
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr;
  grid-auto-rows: auto;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);

  background: white;

  border: 2px solid #2F2533;
  padding: 40px;
  border-radius: 15px;

  box-shadow: 0 0 10px rgb(128, 128, 128);

  z-index: 101;
}

#background {
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  backdrop-filter: blur(4px);
}

.close {
  position: fixed;
  left: 15px;
  top: 15px;
  font-size: 28px;
  cursor: pointer;
  color: #2f2533;
}
</style>
