<script setup lang="ts">
import { cssHeaderComponent } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssHeaderComponent()"
  ></StyleCssVarComponent>
  <div class="HeaderComponent"></div>
</template>

<style scoped></style>
