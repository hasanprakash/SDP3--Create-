<template>
  <div>
    <slot>
      <font-awesome-icon icon="question-circle" class="icons" />
    </slot>
  </div>
</template>

<script>
export default {
  data() {
    return {

    }
  }
}
</script>

<style scoped>
div{
  width:60px;
  display: flex;
  justify-self: center;
  align-items: center;
  justify-content: center;
  height:60px;
  border:2px solid #2F2533;
  color: #2F2533;
  border-radius:10px;
  margin-top: 40px;
  margin-bottom: 40px;
  cursor: pointer;
  /* box-shadow: 0 0 20px 1px; */
  box-shadow: 0 0 10px 1px #ccc;
}

.icons {
  width: 75%;
  height: 75%;
}
</style>