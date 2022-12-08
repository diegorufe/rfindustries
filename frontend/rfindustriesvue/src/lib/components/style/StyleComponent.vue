<script setup lang="ts">
import { cssVars, defaultCssVarsProps, CssVarProps } from "rfindustriescore"

const props = defineProps({
    cssVarsProps: {
        default: defaultCssVarsProps()
    },
    otherProps: {
        default: {}
    }
})

</script>

<template>
    <span class="StyleComponent" v-html="cssVars(props.cssVarsProps, props.otherProps)"></span>
</template>

<style scoped>
.StyleComponent {
    margin: 0;
    padding: 0;
    width: 0;
    height: 0;
    visibility: hidden;
}
</style>