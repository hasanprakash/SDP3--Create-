import { createApp } from "vue";
import axios from "axios";
import { createRouter, createWebHistory } from "vue-router";
import VueAxios from "vue-axios";
import emailjs from 'emailjs-com';

import App from "./App.vue";

import AddImages from "./components/Home Page/AddImages.vue";
import UserFeed from "./components/Home Page/FEED/UserFeed.vue";
import ChatPage from "./components/ChatPage/ChatPage.vue";
import HomePage from "./components/Home Page/HomePage.vue";
import LoginPage from "./components/Login Page/LoginPage.vue";
import ProfilePage from './components/ProfilePage/ProfilePage.vue';
import SignIn from "./components/Login Page/SignIn.vue";
import SignUp from "./components/Login Page/SignUp.vue";
import ShowImage from "./components/Home Page/FEED/ShowImage.vue";

import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faUserSecret,
  faBars,
  faCommentDots,
  faUsers,
  faUser,
  faQuestionCircle,
  faImages,
  faTimesCircle,
  faArrowLeft,
  faArrowRight,
  faUserSlash,
  faSignOutAlt,
  faTimes,
  faArrowDown,
  faHome,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

import BaseIcon from "./components/UI/BaseIcon.vue";
import BaseDialog from "./components/UI/BaseDialog.vue";
import BaseNavbar from "./components/UI/BaseNavbar.vue";
import BaseChat from "./components/UI/BaseChat.vue";
import BaseButton from './components/UI/BaseButton.vue';

// creating routes
const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", redirect: "/home" },
    {
      path: "/home",
      components: { default: HomePage, feed: UserFeed },
      children: [
        { path: "add-image", components: { imageAndLogin: AddImages } },
        // { path: "feed", component: UserFeed },
        {
          path: "/join",
          components: { imageAndLogin: LoginPage },
          children: [
            { path: "signin", component: SignIn },
            { path: "signup", component: SignUp },
          ],
        },
        { path: ":imageId", components: { showImage: ShowImage }, props: true },
      ],
    },
    { path: "/interact", components: { default: HomePage, feed: ChatPage } },
    { path: "/profile", components: { default: HomePage, feed: ProfilePage } },
  ],
});

library.add(
  faBars,
  faUserSecret,
  faCommentDots,
  faUsers,
  faUser,
  faQuestionCircle,
  faImages,
  faTimesCircle,
  faArrowLeft,
  faArrowRight,
  faUserSlash,
  faSignOutAlt,
  faTimes,
  faArrowDown,
  faHome
);

const app = createApp(App);
app.component("font-awesome-icon", FontAwesomeIcon);
app.component("base-icon", BaseIcon);
app.component("base-dialog", BaseDialog);
app.component("base-navbar", BaseNavbar);
app.component("base-chat", BaseChat);
app.component("base-button", BaseButton);

app.use(VueAxios, axios);

app.use(router);

app.use(emailjs);

app.config.unwrapInjectedRef = true;

app.mount("#app");
