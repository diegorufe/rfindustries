<script setup lang="ts">
import { BaseCrudController, cssToolBarCrudComponent } from "rfindustriescore";
import StyleCssVarComponent from "../../style/StyleCssVarComponent.vue";

const props = defineProps({
  controller: {
    type: BaseCrudController,
    required: false,
  },
});
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssToolBarCrudComponent()"
  ></StyleCssVarComponent>

  <div class="ToolBarCrudComponent"></div>
</template>

<style scoped></style>
