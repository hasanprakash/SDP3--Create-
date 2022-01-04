<template>
  <div @click="$emit('okay')" class="black"></div>
  <div class="cmt">
    <header><slot></slot></header><br><br>
    <slot name="matter"></slot><br><br>
    <div class="btn"><slot name="action"></slot></div>
  </div>
</template>

<script>
export default {
  emits:['okay'],
  data() {
    return {

    }
  },

}
</script>

<style scoped>
.cmt {
  position:fixed;
  top:0%;
  width: 40%;
  left: 30%;
  height: auto;
  border-left:2px solid red;
  border-right:2px solid red;
  border-bottom:2px solid red;
  padding: 20px;
  color:black;
  background-color: white;
  z-index: 110;
}
header {
  font-weight: bold;
  float: left;
}
.black {
  position: fixed;
  width: 100%;
  height: 100%;
  top:0%;
  left:0%;
  background-color: black;
  opacity: 0.4;
}
.btn {
  float: right;
}
</style>