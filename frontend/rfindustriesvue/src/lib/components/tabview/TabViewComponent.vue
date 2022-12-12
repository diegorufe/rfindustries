<script setup lang="ts">
import { cssTabViewComponent } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssTabViewComponent()"
  ></StyleCssVarComponent>
  <div class="TabViewComponent" id="TabViewComponent">
    <div class="TabViewComponentHeaders" id="TabViewComponentHeaders"></div>
    <div class="TabViewComponentHeaders" id="TabViewComponentHeaders"></div>
    <div class="TabViewComponentBodys" id="TabViewComponentBodys"></div>
  </div>
</template>

<style scoped></style>
