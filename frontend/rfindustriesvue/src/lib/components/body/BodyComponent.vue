<script setup lang="ts">
import { cssBodyComponent } from "rfindustriescore";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
import TabViewComponent from "../tabview/TabViewComponent.vue";
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssBodyComponent()"
  ></StyleCssVarComponent>
  <div class="BodyComponent">
    <TabViewComponent></TabViewComponent>
  </div>
</template>

<style scoped></style>
