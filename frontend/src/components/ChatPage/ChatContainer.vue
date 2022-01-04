<template>
  <base-chat v-for="i of chats" :key="i" :isYourFriend="isFriend(i)">
    <template #username>
      {{ i.username }}
    </template>
    <template #message>
      {{ i.message }}
    </template>
    <template #time>
      {{ i.localDateTime }}
    </template>
  </base-chat>
</template>

<script>
import BaseChat from '../UI/BaseChat.vue'
export default {
  components: { BaseChat },
  props: ["chats"],
  inject: ['userName'],
  data() {
    return {
      username: ''
    }
  },
  methods: {
    isFriend(i) {
      return i.username != this.username;
    }
  },
  created() {
    this.username = localStorage.getItem("username");
  }
}
</script>

<style>

</style>