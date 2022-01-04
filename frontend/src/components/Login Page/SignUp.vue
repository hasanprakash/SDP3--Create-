<template>
  <section>
    <div id="left">
      <font-awesome-icon @click="gotoLogin" icon="arrow-left" class="icons" />
    </div>
    <div id="register-title">REGISTER</div>
    <div id="right">
      <font-awesome-icon @click="gotoLogin" icon="arrow-right" class="icons" />
    </div>
  </section>
  <div class="container">
    <form v-on:submit.prevent="submitSignUpForm">
      <label for="username">USERNAME</label><br />
      <input
        type="text"
        id="username"
        v-model="rusername"
        placeholder="Enter Username"
      /><br />
      <label for="email">EMAIL</label><br />
      <input
        type="text"
        id="email"
        v-model="remail"
        placeholder="Enter Email"
      /><br />
      <label for="username">PASSWORD</label><br />
      <input
        type="password"
        id="password"
        v-model="rpassword"
        placeholder="Enter Password"
      /><br />
      <button type="submit">SIGN UP</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  emits: ["show-dialog"],
  data() {
    return {
      rusername: "",
      remail: "",
      rpassword: "",
    };
  },
  methods: {
    gotoLogin() {
      this.$router.push("/join/signin");
    },
    submitSignUpForm() {
      const username = this.rusername;
      const email = this.remail;
      const password = this.rpassword;
      if (
        this.isFieldNull(username) ||
        this.isFieldNull(email) ||
        this.isFieldNull(password)
      ) {
        this.$emit(
          "show-dialog",
          "Can't able to create account",
          "Check Again",
          "Okay, Got it"
        );
      } else {
        axios
          .post("http://localhost:8080/api/register", {
            username: username,
            email: email,
            password: password,
          })
          .then((response) => {
            console.log(response);
            this.$emit(
              "show-dialog",
              "Account created successfully!, redirecting to home page...",
              "You are good to go!!",
              "Okay, Got it"
            );
            setTimeout(() => {
              this.$router.push("/home");
            }, 2000);
          })
          .catch((e) => {
            this.error.push(e);
            this.$emit(
              "show-dialog",
              "Unable to create account",
              "Its not you, it's us",
              "Try Again"
            );
          });
      }
    },
    isFieldNull(data) {
      if (data == "" || data == null) return true;
      else return false;
    },
  },
};

{
  // fetch("http://localhost:8080/api/register", {
  //   method: "POST",
  //   headers: { "Content-Type": "application/json" },
  //   body: JSON.stringify({
  //     username:this.rusername,
  //     email: this.remail,
  //     password: this.rpassword
  //   }),
  // })
  //   .then(async (response) => {
  //     const data = await response.json();
  //     if (!response.ok) {
  //       const error = (data && data.message) || response.status;
  //       return Promise.reject(error);
  //     }
  //   })
  //   .catch((error) => {
  //     this.errorMessage = error;
  //     console.log("There was an error!", error);
  //   });
}
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
  color: green;
}
#right {
  float: right;
}
#right:hover {
  color: green;
}

/* FIELDS STYLES */
.container {
  /* border: 2px solid black; */
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
  background-color: #3b284242;
  transform: scale(0.99);
}
span {
  justify-self: center;
}

#background {
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  backdrop-filter: blur(4px);
}
</style>
