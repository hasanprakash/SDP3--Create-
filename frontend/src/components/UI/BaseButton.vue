<template>
    <button class="save"><slot></slot></button>
</template>

<script>
export default {};
</script>

<style scoped>
.save {
  background-color: #ffb87c;
  color: #2f2533;
  border: 2px solid #2f2533;
  padding: 3px 6px;
  border-radius: 7px;
  width: 35%;
  font-weight: bold;
  cursor: pointer;
}
.save:hover {
  background-color: #2f2533;
  color: #ffb87c;
  border: 2px solid #ffb87c;
}

</style>
