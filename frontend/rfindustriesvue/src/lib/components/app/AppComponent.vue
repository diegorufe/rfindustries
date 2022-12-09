<script setup lang="ts">
import { cssAppComponent } from "rfindustriescore";
import BodyComponent from "../body/BodyComponent.vue";
import HeaderComponent from "../header/HeaderComponent.vue";
import MenuComponent from "../menu/MenuComponent.vue";
import StyleComponent from "../style/StyleComponent.vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
</script>

<template>
  <StyleComponent></StyleComponent>
  <StyleCssVarComponent
    :css-vars-component="cssAppComponent()"
  ></StyleCssVarComponent>
  <div class="AppComponent">
    <slot name="appComponent-header">
      <HeaderComponent></HeaderComponent>
    </slot>
    <slot name="appComponent-menu">
      <MenuComponent></MenuComponent>
    </slot>
    <slot name="appComponent-body">
      <BodyComponent></BodyComponent>
    </slot>
  </div>
</template>

<style scoped></style>
