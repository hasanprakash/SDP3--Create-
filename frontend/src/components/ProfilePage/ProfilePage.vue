<template>
  <div class="center">
    <img src="../../assets/profile.png" width="150" height="150" />
  </div>
  <div>
    <span class="center title">{{ username }}</span>
  </div>
  <br />
  <div>SAVED IMAGES</div>
  <!-- <gallery-container></gallery-container> -->
  <profile-container></profile-container>

  <!-- <form @submit.prevent="sendEmail">
    <input type="text" placeholder="Name" name="name" ref="name" /><br />
    <input type="email" placeholder="Email" name="email" ref="email" /><br />
    <input
      type="text"
      placeholder="Messsage"
      name="message"
      ref="message"
    /><br />
    <input type="submit" />
  </form> -->
</template>

<script>
import axios from "axios";
import ProfileContainer from './ProfileContainer.vue';
// import GalleryContainer from '../Home Page/FEED/GalleryContainer.vue';
// import emailjs from "emailjs-com";
export default {
  provide() {
    return {
      data: this.imgUrls
    }
  },
  components: {
    ProfileContainer
    // GalleryContainer
  },
  data() {
    return {
      username: "",
      imgUrls: []
    };
  },
  methods: {
    //   sendEmail(e) {
    //     console.log(e);
    //     try {
    //       var name = this.$refs.name.value;
    //       var email = this.$refs.email.value;
    //       var message = this.$refs.message.value;
    //       console.log(name, email, message);
    //       emailjs.send(
    //         "service_hg84j19",
    //         "template_vej1zqq",
    //         {
    //           to_name: name,
    //           message: message,
    //           reply_to: email,
    //           from_name: "Create Team",
    //         },
    //         "user_XkoPuDdwKhRXdNWEl6dWy"
    //       );
    //       console.log("Email Sent");
    //     } catch (error) {
    //       console.log({ error });
    //     }
    //   },
  },
  created() {
    this.username = localStorage.getItem("username");
    if (
      this.username != null &&
      this.username != "" &&
      this.username != "null"
    ) {
      axios
        .get("http://localhost:8080/api/profile", {
          params: {
            username: this.username,
          },
        })
        .then((response) => {
          if (response.status === 200) {
            this.imgUrls.push(response.data);
            console.log(response.data);
          }
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
};
</script>

<style scoped>
.center {
  width: 100%;
  display: flex;
  justify-content: center;
}
.title {
  font-size: 45px;
  padding: 0;
  font-weight: bold;
}
</style>
