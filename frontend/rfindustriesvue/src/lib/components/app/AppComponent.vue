<script setup lang="ts">
import { cssVarsAppComponent } from "rfindustriescore";
import StyleComponent from "../style/StyleComponent.vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleComponent></StyleComponent>
  <StyleCssVarComponent
    :css-vars-component="cssVarsAppComponent()"
  ></StyleCssVarComponent>
  <div class="AppComponent">
    <slot name="appComponent-header"></slot>
    <slot name="appComponent-menu"></slot>
    <slot name="appComponent-body"></slot>
  </div>
</template>

<style scoped></style>
