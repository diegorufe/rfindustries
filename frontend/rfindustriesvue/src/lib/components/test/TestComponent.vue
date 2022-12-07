<script setup lang="ts">
const props = defineProps({
  msg: {
    default: "Hello",
    type: String,
  },
});
</script>

<template>
  <p>{{ props.msg }}</p>
</template>

<style scoped></style>
