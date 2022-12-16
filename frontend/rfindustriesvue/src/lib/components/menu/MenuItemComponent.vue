<script setup lang="ts">
import { cssMenuItemComponent, MenuItem } from "rfindustriescore";
import { ref } from "vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";

const props = defineProps({
  menuItem: {
    type: MenuItem,
    required: true,
  },
  forceOpen: {
    type: Boolean,
    default: false,
  },
});

const open = ref(props.forceOpen);

function clickMenuItem() {
  if (!props.forceOpen) {
    if (props.menuItem.key) {
      // TODO
    } else {
      open.value = !open.value;
    }
  }
}

function clickMenuItemChild(menuItem: MenuItem) {
  if (menuItem.key) {
    // TODO
  }
}
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssMenuItemComponent()"
  ></StyleCssVarComponent>
  <div class="MenuItemComponent" @click="clickMenuItem">
    <div class="MenuItemComponentLabel">
      {{ props.menuItem.label }}
    </div>
    <div class="MenuItemComponentChidls">
      <template v-if="open" v-for="child in props.menuItem.menuItems">
        <div
          class="MenuItemComponentChild"
          @click="() => clickMenuItemChild(child)"
        >
          <div class="MenuItemComponentChildLabel">
            {{ props.menuItem.label }}
          </div>
        </div>
      </template>
    </div>
  </div>
</template>

<style scoped></style>
