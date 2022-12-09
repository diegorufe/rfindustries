<script setup lang="ts">
import { cssBodyComponent } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssBodyComponent()"
  ></StyleCssVarComponent>
  <div class="BodyComponent"></div>
</template>

<style scoped></style>
