<template>
  <div>
    <div class="container">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style scoped>
.container {
  width: calc(100% - 4px);
  height: auto;
  background: green;
  color: white;
  padding: 5px;
  text-align: right;
  margin-bottom: 10px;
}
.close {
  padding: 0 10px;
  cursor: pointer;
}
</style>
