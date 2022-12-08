<script setup lang="ts">
import { cssMenuComponent } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssMenuComponent()"
  ></StyleCssVarComponent>
  <div class="MenuComponent"></div>
</template>

<style scoped></style>
