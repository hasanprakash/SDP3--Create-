<template>
  <div class="appContainer" v-if="isAppsVisible">
    <base-icon v-for="app in apps" :key="app" :title="app.name" @click="iconClick(app.name)">
      <font-awesome-icon :icon="app.iconName" class="icons" />
    </base-icon>
  </div>


  <base-dialog v-if="isDialogVisible" @okay="confirmError">
    <template #default>{{ dialogErrorName }}</template>
    <template #matter>{{ dialogErrorDescription }}</template>
    <template #action><button @click="confirmError">{{ dialogErrorAction }}</button></template>
  </base-dialog>
</template>

<script>
import BaseDialog from '../UI/BaseDialog.vue';
export default {
  components: { BaseDialog },
  props:{
    isAppsVisible: {
      required: true,
      type: Boolean
    }
  },
  // inject:['iconClick'],
  inject: ['updateIsLogout'],
  data() {
    return {
      containerHeight: 0,
      isDialogVisible: false,
      dialogErrorName: '',
      dialogErrorDescription: '',
      dialogErrorAction: '',
      apps: [
        {
          name:'JOIN',
          iconName:'users'
        },
        {
          name:'HOME',
          iconName:'home'
        },
        {
          name:'REFRESH',
          iconName:'users'
        },
        {
          name:'HELP',
          iconName:'users'
        },
        {
          name:'ABOUT THIS WEBSITE',
          iconName:'users'
        },
        {
          name:'ADD IMAGES',
          iconName:'images'
        },
        {
          name:'LOGOUT',
          iconName:'sign-out-alt'
        },
      ],
    }
  }, 
  methods: {
    hey() {
      console.log("click is working");
      console.log(this.visibleComponent);
    },
    iconClick(appname) {
      if(appname == "ADD IMAGES")
      this.$router.push("/home/add-image");
      else if(appname == "JOIN")
      this.$router.push("/join/signin")
      else if(appname == "LOGOUT") 
        this.logOutTheUser();
      else if(appname == "HOME")
        this.$router.push("/home")
    },
    logOutTheUser() {

      var username = localStorage.getItem("username");
      if(username === null || username === "" ||username === "null") {
        this.sendDialogMsg("LOGOUT FAILED", "You already logged out!", "Okay");
      }
      else {
        console.log(username);
        localStorage.setItem("username", null);
        this.updateIsLogout(true);
        this.sendDialogMsg("LOGGED OUT", "You Just Logged Out!!", "I Know Bro");
      }
    },
    sendDialogMsg(name, description, action) {
      this.dialogErrorName = name;
      this.dialogErrorDescription = description;
      this.dialogErrorAction = action;
      this.isDialogVisible = true;
    },
    confirmError() {
      this.isDialogVisible = false;
    }
  },
  computed: {
    getHeight() {
      return {height: (this.isAppsVisible ? 250 : 0)+"px"};
    }
  }
}
</script>

<style scoped>
div {
  display:grid;
  grid-template-columns:1fr 1fr 1fr 1fr;
  width: 100%;
  height: auto;
  border:2px solid #2F2533;
  border-radius: 15px;

  margin-top: 20px;
  margin-bottom: 20px;
}
.icons {
  width: 75%;
  height: 75%;
}
</style>