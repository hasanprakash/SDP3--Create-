<template>

  <scroll-to-bottom></scroll-to-bottom>
  <chat-container :chats="chats"></chat-container>
  <msg-text-area @changeData="changeData"></msg-text-area>
  
</template>

<script>
import ScrollToBottom from './ScrollToBottom.vue';
import ChatContainer from './ChatContainer.vue';
import MsgTextArea from './MsgTextArea.vue';
import axios from 'axios';
export default {
  inject: ['userName', 'updateUsername'],
  components: {
    ScrollToBottom,
    ChatContainer,
    MsgTextArea
  },
  watch:{
    // chats(value) {
    //   console.log("Data Changed", value);
    // }
  },
  data() {
    return {
      username: '',
      chats: [
        // {
        //   isFriend: true,
        //   username: 'Krishanth',
        //   message: "Hello. How are you today?",
        //   localDateTime: "11:00"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Hey! I'm fine. Thanks for asking!",
        //   localDateTime: "11:01"
        // },
        // {
        //   isFriend: true,
        //   username: 'Krishanth',
        //   message: "Sweet! So, what do you wanna do today?",
        //   localDateTime: "11:02"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Nah, I dunno. Play soccer.. or learn more coding perhaps?",
        //   localDateTime: "11:03"
        // },
        // {
        //   isFriend: true,
        //   username: 'Krishanth',
        //   message: "Hello. How are you today?",
        //   localDateTime: "11:04"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Hey! I'm fine. Thanks for asking!",
        //   localDateTime: "11:05"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Nah, I dunno. Play soccer.. or learn more coding perhaps?",
        //   localDateTime: "11:03"
        // },
        // {
        //   isFriend: true,
        //   username: 'Krishanth',
        //   message: "Hello. How are you today?",
        //   localDateTime: "11:04"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Hey! I'm fine. Thanks for asking!",
        //   localDateTime: "11:05"
        // },
        // {
        //   isFriend: true,
        //   username: 'Krishanth',
        //   message: "Hello. How are you today?",
        //   localDateTime: "11:04"
        // },
        // {
        //   isFriend: false,
        //   username: 'Sri Hasan Prakash',
        //   message: "Hey! I'm fine. Thanks for asking!",
        //   localDateTime: "11:05"
        // },
      ]
    };
  },
  methods: {
    loadData() {
      // this.generateUsername();
      axios
        .get("http://localhost:8080/api/message")
        .then((response) => {
          if(response.status === 200) {
            console.log(response.data);
            this.chats = response.data;
          }
        })
        .catch((e) => {
          console.log(e);
          console.log("GOT ERROR");
        })
    },
    changeData(newData) {
      if(this.chats.length != newData.length) {
        this.chats = newData;
        window.scrollTo(0,document.body.scrollHeight);
      }
    }
    // generateUsername() {
    //   axios
    //     .get("http://localhost:8080/api/username")
    //     .then((response) => {
    //       if(response.status === 200) {
    //         this.updateUsername(response.data);
    //         console.log("Updated username is", this.userName);
    //       }
    //     })
    //     .catch((e) => {
    //       console.log(e);
    //       console.log("GOT ERROR");
    //     })
    // },

  },
  created() {
    this.username = localStorage.getItem("username");
    this.loadData();
  }
};
</script>

<style scoped>
body {
  margin: 0 auto;
  max-width: 800px;
  padding: 0 20px;
}

.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right: 0;
}

.time-right {
  float: right;
  color: #aaa;
}

.time-left {
  float: left;
  color: #999;
}

.example::-webkit-scrollbar {
  display: none;
}
.example {
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
}

/* SCROLL BAR CREATION */
::-webkit-scrollbar {
  width: 2px;
}

/* Track */
::-webkit-scrollbar-track {
  /* background: #f1f1f1;  */
  background: transparent;
}

/* Handle */
::-webkit-scrollbar-thumb {
  background: #888;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555;
}
</style>
