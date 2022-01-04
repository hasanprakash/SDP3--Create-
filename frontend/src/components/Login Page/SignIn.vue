<template>
  <section>
    <div id="left">
      <font-awesome-icon
        @click="gotoRegister"
        icon="arrow-left"
        class="icons"
      />
    </div>
    <div>LOGIN</div>
    <div id="right">
      <font-awesome-icon
        @click="gotoRegister"
        icon="arrow-right"
        class="icons"
      />
    </div>
  </section>
  <div class="container">
    <form v-on:submit.prevent="submitSignInForm">
      <label for="username">USERNAME</label><br />
      <input
        type="text"
        id="username"
        v-model="lusername"
        placeholder="Enter Username"
      /><br />
      <label for="username">PASSWORD</label><br />
      <input
        type="password"
        id="password"
        v-model="lpassword"
        placeholder="Enter Password"
      /><br />
      <button type="submit">SIGN IN</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  emits: ["show-dialog"],
  inject: ['updateUsername', 'updateIsLogout'],
  data() {
    return {
      lusername: "",
      lpassword: "",
    };
  },
  methods: {
    gotoRegister() {
      this.$router.push("/join/signup");
    },
    submitSignInForm() {
      const username = this.lusername;
      const password = this.lpassword;
      if (this.isFieldNull(username) || this.isFieldNull(password)) {
        this.$emit(
          "show-dialog",
          "Invalid Login",
          "Check Again",
          "Okay, Got it"
        );
        this.lusername = "";
        this.lpassword = "";
      } else {
        console.log("Sending data");
        axios
          .post("http://localhost:8080/api/login", {
            username: username,
            password: password,
          })
          .then((response) => {
            if (response.status === 200) {
              if (response.data) {
                this.$emit(
                  "show-dialog",
                  "Login Error",
                  "Can't find username or password is wrong!",
                  "Understood!"
                );
                this.lusername = "";
                this.lpassword = "";
              } else {
                this.$emit(
                  "show-dialog",
                  "Successful",
                  "Successfully logged IN!",
                  "Okay"
                );

                this.updateUsername(this.lusername);
                this.updateIsLogout(false);

                localStorage.setItem("username", this.lusername);
                
                setTimeout(() => {
                  this.$router.push("/home");
                }, 2000);
              }
            }
          })
          .catch((error) => {
            console.log(error);
            console.log("Got Error bro");
          });
      }
    },
    isFieldNull(data) {
      if (data == "" || data == null) return true;
      else return false;
    },
  },
};
</script>

<style scoped>
/* TITLE STYLES */
section {
  widows: 100%;
  text-align: center;
}
section div {
  display: inline-block;
}
#left,
#right {
  cursor: pointer;
}
#left {
  float: left;
}
#left:hover {
  color: #2F2533;
}
#right {
  float: right;
}
#right:hover {
  color: #2F2533;
}

/* FIELDS STYLES */

.container {
  padding: 30px;
}
input {
  margin-bottom: 15px;
  border: 2px solid #2F2533;
  background-color: #f0c8ff;
}
button {
  float: right;
  border: 2px solid #2F2533;
  background-color: #f0c8ff;
  transform: scale(1);
  transition: background-color ease-in 0.3s, transform ease-out 0.1s;
  cursor: pointer;
}
button:hover {
  background-color: #f0c8ff;
}
button:active {
  background-color: #2f25335b(8, 100, 31, 0.8);
  transform: scale(0.99);
}
</style>
