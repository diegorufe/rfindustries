<script setup lang="ts">
import {
  closeAllTabsEvent,
  cssHeaderComponent,
  openCloseMenu,
} from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssHeaderComponent()"
  ></StyleCssVarComponent>
  <div class="HeaderComponent">
    <div class="HeaderComponentLeft">
      <button
        type="button"
        @click="openCloseMenu()"
        class="CoreButtons fa fa-bars"
      ></button>
    </div>

    <div class="HeaderComponentMiddle">
      <button
        type="button"
        @click="closeAllTabsEvent()"
        class="CoreButtons fa-solid fa-rectangle-xmark"
      ></button>
    </div>
  </div>
</template>

<style scoped></style>
