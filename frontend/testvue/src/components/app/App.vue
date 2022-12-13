<script setup lang="ts">
import '@fortawesome/fontawesome-free/css/all.css';
import { addTabEvent } from 'rfindustriescore';
import { AppComponent } from "rfindustriesvue";
import { config } from '../../config/Config';

// Configuramos la aplicación
config();

</script>

<template>
  <button @click="()=>{
    addTabEvent('TEST', 'Test')
  }"></button>
  <AppComponent>
  </AppComponent>
  
</template>

<style scoped>

</style>
