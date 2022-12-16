<script setup lang="ts">
import {
  cssAppComponent,
  getAppContext,
  loadComponentByKey,
} from "rfindustriescore";
import { defineAsyncComponent } from "vue";
import { setReactivityFeature } from "../../utils/ReactivityVueUtils";
import BodyComponent from "../body/BodyComponent.vue";
import HeaderComponent from "../header/HeaderComponent.vue";
import MenuComponent from "../menu/MenuComponent.vue";
import StyleComponent from "../style/StyleComponent.vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";

// Fijamos la funcionalidad para fijar la reactividad
setReactivityFeature();

const context = getAppContext();

let KeyComponent: null;

if (context.frameles) {
  KeyComponent = defineAsyncComponent(() => loadComponentByKey(context.key!));
}
</script>

<template>
  <StyleComponent></StyleComponent>
  <StyleCssVarComponent
    :css-vars-component="cssAppComponent()"
  ></StyleCssVarComponent>
  <Suspense>
    <div class="AppComponent">
      <template v-if="context.frameles">
        <component :is="KeyComponent"></component>
      </template>

      <template v-else>
        <slot name="appComponent-header">
          <HeaderComponent></HeaderComponent>
        </slot>
        <slot name="appComponent-menu">
          <!-- <MenuComponent></MenuComponent> -->
          <menu-component></menu-component>
        </slot>
        <slot name="appComponent-body">
          <BodyComponent></BodyComponent>
        </slot>
      </template>
    </div>
  </Suspense>
</template>

<style scoped></style>
