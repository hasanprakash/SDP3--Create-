<template>
  <my-header @toggle-apps="toggleApps" @toggle-chat="toggleChat"></my-header>
  <app-container :is-apps-visible="isAppsVisible"></app-container>
  <router-view name="imageAndLogin"></router-view>
  <comment-box v-model="isCommentVisible"></comment-box>  
</template>

<script>
import MyHeader from './MyHeader.vue';
import AppContainer from './AppContainer.vue';
import CommentBox from "./CommentBox.vue";
export default {
  components: {
    MyHeader,
    AppContainer,
    CommentBox,
  },
  data() {
    return {
      isAppsVisible:false,
      visibleComponent:null,
      isCommentVisible: false,
    }
  },
  methods: {
    toggleApps() {
      this.isAppsVisible = !this.isAppsVisible;
      var date = new Date();
      let formatted_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "T" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds()
      console.log(formatted_date);
    },
    toggleChat() {
      this.isCommentVisible = !this.isCommentVisible;
    },
  }
}



// let formatted_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "T" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds()
// this is the way to get spring LocalDateTime format
</script>

<style>

</style>