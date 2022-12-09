<script setup lang="ts">
import { cssHeaderComponent, openCloseMenu } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssHeaderComponent()"
  ></StyleCssVarComponent>
  <div class="HeaderComponent">
    <button
      type="button"
      @click="openCloseMenu()"
      class="CoreButtons fa fa-bars"
    ></button>
  </div>
</template>

<style scoped></style>
