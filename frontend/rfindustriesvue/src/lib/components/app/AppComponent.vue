<script setup lang="ts">
import { cssAppComponent, getAppContext } from "rfindustriescore";
import BodyComponent from "../body/BodyComponent.vue";
import HeaderComponent from "../header/HeaderComponent.vue";
import MenuComponent from "../menu/MenuComponent.vue";
import StyleComponent from "../style/StyleComponent.vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";

const context = getAppContext();

let KeyComponent: null;

if (context.frameles) {
  // TODO get component by key
}
</script>

<template>
  <StyleComponent></StyleComponent>
  <StyleCssVarComponent
    :css-vars-component="cssAppComponent()"
  ></StyleCssVarComponent>
  <div class="AppComponent">
    <template v-if="context.frameles">
      <Suspense>
        <component :is="KeyComponent"></component>
      </Suspense>
    </template>

    <template v-else>
      <slot name="appComponent-header">
        <HeaderComponent></HeaderComponent>
      </slot>
      <slot name="appComponent-menu">
        <MenuComponent></MenuComponent>
      </slot>
      <slot name="appComponent-body">
        <BodyComponent></BodyComponent>
      </slot>
    </template>
  </div>
</template>

<style scoped></style>
