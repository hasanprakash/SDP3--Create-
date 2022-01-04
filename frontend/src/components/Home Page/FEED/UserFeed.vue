<template>
  <div v-if="isLoading" class="loading">LOADING.....</div>
  <div v-else-if="!isLoading && isError">
    <h2 class="error">Failed to Fetch Data....</h2>
  </div>
  <div v-else>
    <gallery-container></gallery-container>
  </div>
</template>

<script>
import GalleryContainer from "./GalleryContainer.vue";
export default {
  components: { GalleryContainer },
  provide() {
    return {
      data: this.imgUrls,
    };
  },
  data() {
    return {
      isLoading: false,
      isError: false,
      imgUrls: [
        {
          imageName: "forza",
          imageUrl:
            "https://www.windowscentral.com/sites/wpcentral.com/files/styles/large/public/field/image/2021/10/forza-horizon-5-screenshot-01.jpg?itok=_X-_0X_I",
        },
        {
          imageName: "far cry 6",
          imageUrl:
            "https://cdn1.epicgames.com/b4565296c22549e4830c13bc7506642d/offer/TETRA_PREORDER_STANDARD%20EDITION_EPIC_Store_Portrait_1200x1600-1200x1600-ca8b802ff13813c37a44ebf68d0946a2.png",
        },
        {
          imageName: "weeknd",
          imageUrl:
            "https://images.complex.com/complex/images/c_fill,dpr_auto,f_auto,q_auto,w_1400/fl_lossy,pg_1/z7chrdedpd9r1shno2zv/weeknd?fimg-ssr-default",
        },
        {
          imageName: "billie eilish",
          imageUrl: "https://wallpapercave.com/wp/wp4434079.jpg",
        },
        {
          imageName: "red dead redemption 2",
          imageUrl:
            "https://cdn1.epicgames.com/epic/offer/RDR2PC1227_Epic%20Games_860x1148-860x1148-b4c2210ee0c3c3b843a8de399bfe7f5c.jpg",
        },
        {
          imageName: "fifa 19",
          imageUrl:
            "https://eu-images.contentstack.com/v3/assets/bltcc7a7ffd2fbf71f5/blt07d1fb71b00a4c0c/60dd0bbb5543520fcbc72d7d/8606fa6b360dcf41d648b9836256ba0b083f1a23.jpg?auto=webp&fit=crop&format=jpg&quality=100",
        },
        {
          imageName: "call of duty",
          imageUrl:
            "https://media.gamestop.com/i/gamestop/COD_HeroM_New/call-of-duty-modern-warfare.jpg?$POI$&w=768&aspect=1:1.2",
        },
        {
          imageName: "dribble",
          imageUrl:
            "https://images.dribbble.com/users/17078/screenshots/5696831/dribble_1.png",
        },
        {
          imageName: "fortnite",
          imageUrl:
            "https://cdn2.unrealengine.com/7up-v2-3840x2160-e11fc91a84d6.jpg",
        },
        {
          imageName: "django",
          imageUrl:
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAiPw2RC-tHsbbVVSXIBPNQZCpq0aJS-LmcQ&usqp=CAU",
        },
        {
          imageName: "sony",
          imageUrl:
            "https://www.sony.com/content/dam/sony/images/products/gaming/xperia-z5/xperia-z5-hero-image.jpg",
        },
        {
          imageName: "nintendo",
          imageUrl:
            "https://www.imore.com/sites/imore.com/files/styles/xlarge_wm_blw/public/field/image/2021/09/mario-nintendo-switch.jpg",
        },
        {
          imageName: "microsoft",
          imageUrl:
            "https://www.microsoft.com/en-us/store/p/microsoft-surface-pro-6/9nblggh5h8j1",
        },
        {
          imageName: "setup",
          imageUrl:
            "https://cdn.autonomous.ai/static/upload/images/new_post/21-multi-monitor-computer-desk-setup-ideas-for-tech-lovers-654.jpg",
        },
        {
          imageName: "marhsall",
          imageUrl:
            "https://www.marshallheadphones.com/on/demandware.static/-/Library-Sites-SharedLibrary-Marshall/default/dw348e9857/images/front-page/year/2021/juli/Multi-col_Mobile_Woburn-II_Lifestyle.jpg",
        },
        {
          imageName: "spiderman",
          imageUrl:
            "https://i.pinimg.com/564x/2b/f9/e7/2bf9e75abe77a820565bb0a382446201.jpg",
        },
        {
          imageName: "star wars",
          imageUrl: "https://cdn.mos.cms.futurecdn.net/DEpYy8jSdvD9dkvVDSPNoD.jpg",
        },
        {
          imageName: "strom trooper",
          imageUrl: "https://wallpapercave.com/wp/wp1882977.png",
        },
        {
          imageName: "halo",
          imageUrl:
            "https://i.pinimg.com/564x/21/fc/97/21fc9782afbcc7b516ad80584512bb83.jpg",
        },
        {
          imageName: "ssunset forest",
          imageUrl:
            "https://i.pinimg.com/564x/89/f5/cb/89f5cbc02ae52b2d43a970083bc50e17.jpg",
        },
        {
          imageName: "harry potter",
          imageUrl:
            "https://variety.com/wp-content/uploads/2018/08/mv5bmdqwywrlyzytmwy2ny00ngi2ltkzzdmtzgu2nzkxymi4ntgyl2ltywdll2ltywdlxkeyxkfqcgdeqxvynjk4mtgzmdi-_v1_.jpg?crop=0px%2C64px%2C1000px%2C563px&resize=681%2C383",
        },
        {
          imageName: "aesthetic",
          imageUrl:
            "https://i.pinimg.com/564x/11/86/88/118688ecdf8cc819b94a29974aa8a6fd.jpg",
        },
        {
          imageName: "smart home",
          imageUrl:
            "https://i.pinimg.com/564x/67/01/fa/6701fa097c5223f0c998cada32868db2.jpg",
        },
        {
          imageName: "smart watch",
          imageUrl:
            "https://www.tuvie.com/wp-content/uploads/smartwatch-a-concept-by-andrea-ponti1.jpg",
        },
        {
          imageName: "tesla",
          imageUrl:
            "https://i.pinimg.com/564x/65/58/c5/6558c525070b5470168db8be035fcbff.jpg",
        },
        {
          imageName: "tesla1",
          imageUrl:
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2022-tesla-cyber-truck-mmp-1-1579127142.jpg?crop=0.923xw:0.880xh;0.0577xw,0.120xh&resize=1200:*",
        },
        {
          imageName: "app",
          imageUrl:
            "https://i.pinimg.com/564x/eb/a4/e3/eba4e3b69dc04982e21c0e7f2cbd3e16.jpg",
        },
        {
          imageName: "oxygenOS",
          imageUrl:
            "https://i.pinimg.com/564x/2c/20/c0/2c20c0249068f06ee9a72ffd06680d63.jpg",
        },
        {
          imageName: "windows",
          imageUrl:
            "https://i.pinimg.com/564x/e7/46/cb/e746cbe647438ead9262561a0dfd5236.jpg",
        },
        {
          imageName: "streets",
          imageUrl:
            "https://i.pinimg.com/564x/b3/e7/09/b3e709ae8e086a4df8250e8dd24cdbdc.jpg",
        },
        {
          imageName: "Gradients",
          imageUrl:
            "https://i.pinimg.com/564x/52/62/65/52626532c2d8605986092cfc1ff3cb71.jpg",
        },
        {
          imageName: "wallpaper",
          imageUrl:
            "https://i.pinimg.com/564x/37/84/f4/3784f4df2ce4947b83053bb4df3854f0.jpg",
        },
        {
          imageName: "mandalorian",
          imageUrl:
            "https://i.pinimg.com/736x/b0/2e/3a/b02e3a238b47bf0cd67dac2b99543f61.jpg",
        },
        {
          imageName: "forest roughs",
          imageUrl:
            "https://i.pinimg.com/564x/f6/be/5b/f6be5b327d87232ab8c56a244dc75387.jpg",
        },
        {
          imageName: "homescreen",
          imageUrl:
            "https://i.pinimg.com/564x/e8/83/5f/e8835fd3246f901dc1bae85717dbb875.jpg",
        },
        {
          imageName: "gradient11",
          imageUrl:
            "https://i.pinimg.com/564x/6a/88/67/6a8867fc6790665c047aaa4c23598313.jpg",
        },
        {
          imageName: "app",
          imageUrl:
            "https://i.pinimg.com/564x/c8/c5/67/c8c567a4f2c78d3fa4f8cfcb87ad05d7.jpg",
        },
      ],
    };
  },
  methods: {
    shuffle(array) {
      let currentIndex = array.length,
        randomIndex;

      // While there remain elements to shuffle...
      while (currentIndex != 0) {
        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex--;

        // And swap it with the current element.
        [array[currentIndex], array[randomIndex]] = [
          array[randomIndex],
          array[currentIndex],
        ];
      }

      return array;
    },
  },
  created() {
    this.isLoading = true;
    this.axios
      .get("http://localhost:8080/api/feed")
      .then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          this.imgUrls.push(response.data[i]);
        }
        this.shuffle(this.imgUrls);
        // console.log(response.data);
        this.isLoading = false;
      })
      .catch((e) => {
        console.log(e);
        this.isError = true;
        this.isLoading = false;
      });


  },
};
</script>

<style scoped>
.loading {
  height: 400px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(231, 231, 231);
}
</style>
