<script setup lang="ts">
const props = defineProps({
  cssVarsComponent: {
    type: String,
    default: "",
  },
});
</script>

<template>
  <span class="StyleCssVarComponent" v-html="props.cssVarsComponent"></span>
</template>

<style scoped>
.StyleCssVarComponent {
  margin: 0;
  padding: 0;
  width: 0;
  height: 0;
  visibility: hidden;
}
</style>
