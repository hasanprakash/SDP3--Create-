<template>
  <textarea
    @keydown.ctrl="onControl"
    v-model="messageValue"
    class="text-area"
    placeholder="Click On Control to Send Message..."
  ></textarea>

  <base-dialog v-if="isDialogueVisible" @okay="confirmError">
    <template #default>{{ dialogErrorName }}</template>
    <template #matter>{{ dialogErrorDescription }}</template>
    <template #action
      ><button @click="confirmError">{{ dialogErrorAction }}</button></template
    >
  </base-dialog>
</template>

<script>
import axios from "axios";
export default {
  emits: ["changeData"],
  data() {
    return {
      messageValue: "",
      isDialogueVisible: false,
      dialogErrorName: "",
      dialogErrorDescription: "",
      dialogErrorAction: "",
    };
  },
  methods: {
    onControl() {
      const username = localStorage.getItem("username");
      const message = this.messageValue;
      const isFriend = false;
      if (username == null || username == "") {
        this.messageValue = "Got Error";
        console.log("User didn't logged in!!");
        this.dialogErrorName = "SENT ERROR";
        this.dialogErrorDescription = "I guess you haven't logged in yet!";
        this.dialogErrorAction = "Okay Bro";
        this.isDialogueVisible = true;
        return;
      }
      if (message == null || message == "") {
        console.log("Enter Message First!!");
        return;
      }
      axios
        .post("http://localhost:8080/api/message", {
          username: username,
          message: message,
          isFriend: isFriend,
        })
        .then((response) => {
          if (response.status === 200) {
            if (response.data.length > 0) {
              console.log("Message Sent");
              this.$emit("changeData", response.data);
              console.log(response.data);
              this.messageValue = "";
            }
          } else {
            console.log("Response is not 200");
          }
        })
        .catch((e) => {
          console.log(e, "GOT ERROR");
        });
    },
    confirmError() {
      this.isDialogueVisible = false;
    },
  },
  created() {
    var that = this;
    window.setInterval(function() {
      axios
        .get("http://localhost:8080/api/message")
        .then((response) => {
          that.$emit("changeData", response.data);
        })
    }, 2000);
  },
};
</script>

<style>
.text-area {
  width: 99%;
  border: 2px solid green;
  border-radius: 7px;
  height: 50px;
  z-index: 100;
  resize: none;
}
</style>
