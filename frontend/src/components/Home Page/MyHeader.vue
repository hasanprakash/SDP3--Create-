<template>
  <div class="gridContainer">
    <!-- 1st -->
    <div @click="$emit('toggle-apps')">
      <font-awesome-icon icon="bars" class="icons" />
    </div>
    <div >
      <img @click="toHome" class="logo" src="../../assets/websiteLogo.png" />
    </div>
    <!-- 2nd -->
    <div>
      <input id="search" type="text" placeholder="Search Here..." />
    </div>
    <!-- 3rd -->
    <div @click="$emit('toggle-chat')">
      <font-awesome-icon icon="comment-dots" class="icons" />
    </div>
    <div>
      <font-awesome-icon v-if="!isLogout" @click="toProfile" icon="user" class="icons" title="PROFILE"/>
      <font-awesome-icon v-else @click="$router.push('/join/signin')" icon="user-slash" class="icons" title="YOU HAVEN'T LOGGED IN YET!"/>
    </div>
  </div>
  <!-- <div v-if="isLogout" :class="{profileOptions: showPopUp, hide: !showPopUp}">
    <div class="logout">LOGOUT</div>
  </div> -->
</template>

<script>
export default {
  emits:['toggle-chat', 'toggle-apps'],
  inject:['isLogout', 'updateIsLogout'],
  data() {
    return {
    };
  },
  methods: {
    toProfile() {
      this.$router.push("/profile");
    },
    toHome() {
      this.$router.push("/home");
    }
  },
  created() {
    var username = localStorage.getItem("username");
    console.log(username);
    if(username != "" && username != "null" && username != null) 
      this.updateIsLogout(false);
    else
      this.updateIsLogout(true);
  }
};
</script>

<style scoped>
/* LOGO */
.logo {
  width: 55px;
  height: 55px;
  border-radius: 50%;
  cursor: pointer;
}
.gridContainer > div:nth-child(2) {
  width: 55px;
  height: 55px;
  display: flex;
  align-items: center;
  justify-content: center;
}

/* GRID CONTAINER */
.gridContainer {
  display: grid;
  grid-template-columns: 1fr 1fr 20fr 1fr 1fr;
  grid-template-rows: auto;
  grid-gap: 5px;
  margin-bottom: 20px;
  color: #2F2533;
}
/* .gridContainer > div {
  background-color: #FFB87C;
} */
.gridContainer > div:nth-child(3) {
  border: 2px solid #2F2533;
  border-radius: 25px;
}
.gridContainer > div:nth-child(1),
.gridContainer > div:nth-child(4),
.gridContainer > div:nth-child(5) {
  border: 2px solid #2F2533;
  border-radius: 10px;
  width: 55px;
  height: 55px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
}
.gridContainer > div > div {
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
}

#search {
  width: 100%;
  height: 100%;
  background: none;
  border: none;
  margin-left: 10px;
  margin-right: 10px;
  outline: none;
  font-weight: bolder;
  font-size: larger;
}

/* FONT AWESOME ICON */
.icons {
  width: 75%;
  height: 75%;
}


/* LOGOUT */
.profileOptions {
  position: absolute;
  right: 5px;
  top: 65px;
  height: auto;
  border: 2px solid #2F2533;
  padding: 15px;
  border-radius: 10px;
  backdrop-filter: blur(4px);
}
.hide {
  display: none;
}
.profileOptions, .hide {
  user-select: none; /* supported by Chrome and Opera */
  -webkit-user-select: none; /* Safari */
  -khtml-user-select: none; /* Konqueror HTML */
  -moz-user-select: none; /* Firefox */
  -ms-user-select: none; /* Internet Explorer/Edge */
}
.logout {
  color: red;
  backdrop-filter: blur(4px);
  opacity: 1;
}
.profileOptions:hover {
  background-color: black;
  opacity: 0.7;
  cursor: pointer;
}
</style>
