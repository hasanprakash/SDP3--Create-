<template>
  <router-view></router-view>
  <router-view name="feed"></router-view>
</template>

<script>
import { provide, ref } from 'vue';
import axios from 'axios';
export default {
  data() {
    return {
    }
  },
  provide() {
    return {
    }
  },
  setup() {
    const userName = ref("");
    const isLogout = ref(true);
    var updateUsername = (username) => {
      userName.value = username;  
    };
    var updateIsLogout = (boolValue) => isLogout.value = boolValue;

    provide('userName', (userName));
    provide('updateUsername', updateUsername);

    provide('isLogout', isLogout);
    provide('updateIsLogout', updateIsLogout);
    
  },
  methods: {
  },
  created() {
    axios
      .get("http://localhost:8080/api/profile1")
      .then((response) => {
        console.log(response.status);
      })
    axios
      .get("http://localhost:8080/api/profile1")
      .then((response) => {
        console.log(response.status);
      })
  }
};
</script>

<style>
html, body {
  padding: 0;
  font-family: sans-serif;
}
</style>