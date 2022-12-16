<script setup lang="ts">
import { addTabEvent, cssMenuItemComponent, MenuItem } from "rfindustriescore";
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

function clickMenuItem(event: any) {
  const target = event.target as HTMLElement;
  if (
    target.classList.contains("MenuItemComponent") ||
    (target.classList.contains("MenuItemComponentLabel") && !props.forceOpen)
  ) {
    open.value = !open.value;
  }
}

function clickMenuItemChild(menuItem: MenuItem) {
  if (menuItem.key) {
    addTabEvent(menuItem.key, menuItem.label);
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
            {{ child.label }}
          </div>
        </div>
      </template>
    </div>
  </div>
</template>

<style scoped></style>
