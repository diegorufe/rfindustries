<script setup lang="ts">
import {
  cssMenuComponent,
  getAppContext,
  isNotEmpty,
  isNotNull,
  MenuItem,
} from "rfindustriescore";
import { ref } from "vue";
import StyleCssVarComponent from "../style/StyleCssVarComponent.vue";
import MenuItemComponent from "./MenuItemComponent.vue";

const context = getAppContext();

const menuItems: MenuItem[] = await context.loaderMenu.findMenuItems();
let searchMenuItems: MenuItem[] = { ...menuItems };
const menuKey = ref(0);
let searchingMenu: boolean = false;

function search(event: any) {
  const text = event.target.value;

  if (menuItems.length > 0) {
    if (isNotNull(text) && isNotEmpty(text)) {
      searchMenuItems = context.loaderMenu.searchInMenu(menuItems, text);
      searchingMenu = true;
    } else {
      searchMenuItems = { ...menuItems };
      searchingMenu = false;
    }

    menuKey.value = menuKey.value + 1;
  }
}
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssMenuComponent()"
  ></StyleCssVarComponent>
  <div class="MenuComponent">
    <div class="MenuComponentSearch">
      <input
        class="MenuComponentSearchInput"
        type="text"
        @keyup="search"
        :placeholder="context.translate('rf.search')"
      />
    </div>
    <div :key="menuKey" class="MenuComponentItems">
      <template v-for="menuItem in searchMenuItems">
        <MenuItemComponent
          :menu-item="menuItem"
          :force-open="searchingMenu"
        ></MenuItemComponent>
      </template>
    </div>
  </div>
</template>

<style scoped></style>
