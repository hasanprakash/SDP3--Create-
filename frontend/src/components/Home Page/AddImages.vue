<template>

  <div class="container">
    <div class="close"><font-awesome-icon @click="closeAddImage" icon="times-circle" class="icons" /></div>
    <!-- Left Part -->
    <div class="fields">
      <form @submit.prevent="onSubmit">
        <input
          type="text"
          placeholder="Enter Image Name"
          ref="imgname"
        /><br /><br />

        <input
          type="url"
          placeholder="Enter Image URL"
          ref="imgurl"
        /><br /><br />

        <!-- <button type="submit" v-on:click="addImage">test</button> -->
        <base-button type="submit" @click="addImage">TEST</base-button>
        <div v-if="isImagePreviewed">

          <p>Image Resolution : {{ imgMainWidth }} x {{ imgMainHeight }}</p>

          <textarea
            type="text"
            placeholder="Enter Image HashTags, Separated by commas.."
            ref="imghashtag"
          /><br /><br />

          <button @click="addDataToDatabase" type="button">Confirm</button>
        </div>
      </form>
      <br />
    </div>

    <!-- Right Part -->
    <div class="imagePreview">
      <p v-if="!isImagePreviewed">Your Image Will Be Previewed Here!</p>
      <div v-else class="imgContainer" :style="getImageContainerStyle">
        <img :style="getImageStyle" :src="url" />
      </div>
    </div>
  </div>




  <base-dialog v-if="isInputInvalid" @okay="confirmError">
    <template #default>{{errorName}}</template>
    <template #matter>{{errorDescription}}</template>
    <template #action><button @click="confirmError">{{errorAction}}</button></template>
  </base-dialog>
</template>

<script>
import axios from 'axios';
import BaseButton from '../UI/BaseButton.vue';
export default {
  components: { BaseButton },
  data() {
    return {
      errorName: '',
      errorDescription: '',
      errorAction: '',



      isImagePreviewed: false,
      url: null,
      imgWidth: null,
      imgHeight: null,
      imgMainWidth: null,
      imgMainHeight: null,
      isInputInvalid:false,
    };
  },
  methods: {
    isValid(str) {
      return str != null && str.trim() != "";
    },
    onSubmit() {
      // const name = this.$refs.imgname.value;
      const url = this.$refs.imgurl.value;
      // console.log(name, url);

      if (this.isValid(url)) {
        this.getMeta(url);
        this.url = url;
        this.isImagePreviewed = true;
      }
      else {
        this.errorName="Invalid Input";
        this.errorDescription="Please Enter Complete Details";
        this.errorAction="Okay Bro";
        this.isInputInvalid = true;
      }
    },
    getMeta(url) {
      var img = new Image();
      img.src = url;
      var that = this;
      img.onload = function() {
        // console.log(img.width, img.height); or this.width, this.heigth
        that.imgMainWidth = img.width;
        that.imgMainHeight = img.height;
        if (img.width > img.height) {
          that.imgWidth = 100;
          that.imgHeight = (img.height * 100) / img.width;
        } else {
          that.imgHeight = 100;
          that.imgWidth = (img.width * 100) / img.height;
        }
      };
    },
    confirmError() {
      this.isInputInvalid = false;
    },
    closeAddImage() {
      this.$router.push("/home");
    },
    addDataToDatabase() {
      var name = this.$refs.imgname.value;
      var url = this.$refs.imgurl.value;
      var data = this.$refs.imghashtag.value.replace(/ /g,'').split(",");
      var username = localStorage.getItem("username");
      // var date = new Date();
      // let formatted_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + "T" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds()+".0";
      if(this.isValid(name) && this.isValid(url) && data.length != 0 && this.isValid(username)) {
        console.log("adding data to database");
        axios
          .post("http://localhost:8080/api/image", {
            imageName: name,
            imageUrl: url,
            authorName: username,
            hash_tags: data,
            // localDateTime: formatted_date
          })
          .then((response) => {
            if(response.status === 200) {
              console.log(response.data);
              this.closeAddImage();
            }
          })
      }
      else {
        this.errorName="Client Side Error";
        this.errorDescription="Details should be filled perfectly!";
        this.errorAction="Okay";
        this.isInputInvalid = true;
      }
    }
  },
  computed: {
    getImageStyle() {
      if (this.imgWidth != null && this.imgHeight != null)
        return {
          width: this.imgWidth + "%",
          height: this.imgHeight + "%",
        };
      else
        return {
          width: "0",
          height: "0",
        };
    },
    getImageContainerStyle() {
      var imgcon = document.querySelector(".imagePreview");
      var mini = Math.min(imgcon.clientWidth, imgcon.clientHeight);
      return {
        width: mini + "px",
        height: mini + "px",
      };
    },
  },
};
</script>

<style scoped>
.container {
  position: relative;
  display: grid;
  grid-template-columns: 1fr 1fr;
  width: 100%;
  border: 2px solid #2F2533;
  height: 500px;
  background-color: #ccc;
  border-radius: 15px;
  align-items: center;
  justify-content: center;
  overflow: auto;

  margin-top: 20px;
  margin-bottom: 20px;
}
.fields,
.imagePreview {
  justify-self: center;
  /* border: 2px solid yellow; */
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
form {
  width: 60%;
}
input,
textarea {
  width: 100%;
  resize: none;
}
.imgContainer {
  /* border: 2px solid violet; */
  display: flex;
  align-items: center;
  justify-content: center;
}


.close {
  position: absolute;
  left: 15px;
  top: 15px;
  cursor: pointer;
}
</style>
