<script setup lang="ts">
import {
  BaseCrudController,
  cssCrudContainerComponent,
} from "rfindustriescore";
import StyleCssVarComponent from "../../style/StyleCssVarComponent.vue";
import ToolBarCrudComponent from "../../toolbars/crud/ToolBarCrudComponent.vue";

const props = defineProps({
  controller: {
    type: BaseCrudController,
    required: true,
  },
});
</script>

<template>
  <StyleCssVarComponent
    :css-vars-component="cssCrudContainerComponent()"
  ></StyleCssVarComponent>

  <div class="CrudContainerComponent">
    <div class="CrudContainerComponentToolBar">
      <template v-if="props.controller.isStatePageList()">
        <stlot name="CrudContainerComponent-list-toolbar"> </stlot>
      </template>

      <template v-else-if="props.controller.isStatePageCrud()">
        <stlot name="CrudContainerComponent-crud-toolbar">
          <ToolBarCrudComponent
            :controller="props.controller"
          ></ToolBarCrudComponent>
        </stlot>
      </template>
    </div>

    <div class="CrudContainerComponentBody">
      <template v-if="props.controller.isStatePageList()">
        <stlot name="CrudContainerComponent-list-body"> </stlot>
      </template>

      <template v-else-if="props.controller.isStatePageCrud()">
        <stlot name="CrudContainerComponent-crud-body"> </stlot>
      </template>
    </div>
  </div>
</template>

<style scoped></style>
