<template>
  <div class="container" :class="{ 'container': true, darker: !isYourFriend }">
    <img :class="{ right: !isYourFriend }" src="https://bestprofilepictures.com/wp-content/uploads/2021/04/Cool-Profile-Picture.jpg" alt="Avatar" style="width:100%;" />
    <p :class="{ floatRight:!isYourFriend, userName: true }">( <slot name="username"></slot> )</p>
    <p><slot name="message"></slot></p>
    <span :class="{ 'time-left': !isYourFriend, 'time-right': isYourFriend }"><slot name="time"></slot></span>
  </div>
</template>

<script>
export default {
    props: ['isYourFriend'],
    data() {
        return {
        }
    },
}
</script>

<style scoped>
body {
  margin: 0 auto;
  max-width: 800px;
  padding: 0 20px;
}

.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right: 0;
}

.time-right {
  float: right;
  color: #aaa;
}

.time-left {
  float: left;
  color: #999;
}

.floatRight {
  float: right;
}
.userName {
  color: green;
}

.example::-webkit-scrollbar {
  display: none;
}
.example {
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}

/* SCROLL BAR CREATION */
::-webkit-scrollbar {
  width: 2px;
}

/* Track */
::-webkit-scrollbar-track {
  /* background: #f1f1f1;  */
  background: transparent;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: #888;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555;
}
</style>